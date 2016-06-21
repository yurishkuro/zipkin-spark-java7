package com.uber.zipkin_spark_java7.dependencies

import java.util.concurrent.TimeUnit._

import com.datastax.spark.connector._
import com.datastax.spark.connector.rdd.CassandraRDD
import com.twitter.util.{Duration, Time}
import com.twitter.zipkin.Constants
import com.twitter.zipkin.conversions.thrift._
import com.uber.zipkin_spark_java7.{Codecs, SparkDefaults}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ZipkinDependenciesJob {
  def main(args: Array[String]) = {
    new ZipkinDependenciesJob(SparkDefaults()).run()
  }
}

case class ZipkinDependenciesJob(params: SparkDefaults) {

  /**
    * RDD needs the data objects to be serializable, at least at some points. The zipkin.common.Span is not serializable,
    * and has a lot of extra stuff not needed for pure dependency graph job. This class captures only what's needed.
    */
  case class Span(traceId: Long, id: Long, parentId: Option[Long], timestamp: Option[Long], serviceName: Option[String], annotations: Seq[String]) {
    def mergeSpan(s: Span): Span = {
      require(this.traceId == s.traceId && this.id == s.id)
      val minTimestamp = Seq(timestamp, s.timestamp).flatten.reduceOption(_ min _)
      Span(traceId, id, parentId, minTimestamp, (serviceName ++ s.serviceName).headOption, this.annotations ++ s.annotations)
    }

    /**
      * @return true if Span contains at most one of each core annotation, false otherwise
      */
    def isValid: Boolean = {
      // TODO this has the potential to count the same span twice in runs with adjacent time windows.
      // Ideally, one of `<=` should be strict `<`. Depends on https://github.com/openzipkin/zipkin/issues/924.
      // TODO timestamp check should be moved to Trace.isValid
      val inTimeRange: Boolean = timestamp
        .exists(t => params.microsLower <= t && t <= params.microsUpper)
      inTimeRange && serviceName.isDefined && !Constants.CoreAnnotations.map { c =>
        annotations.count(_ == c) // how many times this core annotation 'c' is mentioned
      }.exists(_ > 1)
    }
  }

  case class Trace(id: Long, spans: Map[Long, Span]) {
    def mergeTrace(t: Trace): Trace = {
      Trace(id, spans ++ t.spans)
    }

    def getLinks: Iterable[(String, String)] = {
      spans.values
        .filter(_.parentId.isDefined)
        .flatMap(span => spans.get(span.parentId.get).map(parentSpan => (parentSpan.serviceName.get, span.serviceName.get)))
    }
  }

  private[this] def rowToSpan(row: CassandraRow): Span = {
    val thriftSpan = Codecs.SpanCodec.decode(row.getBytes("span"))
    // temp fix for some of HAProxy annotations containing zero timestamps
    val thriftAnnotation: Seq[com.twitter.zipkin.thriftscala.Annotation] =
      thriftSpan.annotations.filter(_.timestamp > 0)
    val span: com.twitter.zipkin.common.Span = thriftSpan.copy(
      annotations = thriftAnnotation
    ).toSpan
    val annotations = span.annotations.map(_.value)
    val timestamp: Option[Long] = span.timestamp orElse span.annotations.map(_.timestamp).sorted.headOption
    Span(traceId = span.traceId, id = span.id, parentId = span.parentId, timestamp = timestamp, serviceName = span.serviceName, annotations)
  }

  def run() {
    val sc = params.getSparkContext(classOf[ZipkinDependenciesJob])
    println(s"Running Dependencies job with startTs=${params.startTs} (${Time.fromMilliseconds(params.startTs)}) and endTs=${params.endTs} (${Time.fromMilliseconds(params.endTs)})")

    val table: CassandraRDD[CassandraRow] = sc.cassandraTable(params.keyspace, "traces")
    // ^^^ If need to drill further into the data, add this: .where("wsid='725030:14732'")

    def makeTrace(traceId: Long, rows: Iterable[CassandraRow]): Trace = {
      val spans: Map[Long, Span] = rows
        .map(rowToSpan)
        .groupBy(span => span.id)
        .mapValues(spans => spans.toList match {
          case span :: nil => span
          case head :: tail => tail.fold(head)((s1, s2) => s1.mergeSpan(s2))
          case _ => null // this can never happen
        })
        .filter(kv => kv._2.isValid)
      Trace(traceId, spans)
    }

    val aggregates: RDD[((String, String), Long)] = table
      .spanBy(row => row.getLong("trace_id"))    // read the whole partition
      .map(pair => makeTrace(pair._1, pair._2))  // and reduce it all at once, in memory
      .flatMap(_.getLinks)
      .map { case (parent, child) => ((parent, child), 1L) } // start the count
      .reduceByKey(_ + _) // add up the counts

    val toDepInfo: PartialFunction[Any, DependenciesInfo] = {
      case ((parent: String, child: String), callCount: Long) =>
        DependenciesInfo(
          Seq(DependencyLinkInfo(parent = parent, child = child, callCount = callCount)))
    }

    // reduce does not work on empty collections, so add an empty sentinel just in case
    val dependencies: DependenciesInfo =
      (aggregates.map(toDepInfo) ++ sc.parallelize(Seq(DependenciesInfo(Seq()))))
        .reduce(_ + _) // merge under one Dependencies object, which overrides +

    saveToCassandra(sc, dependencies)

    println(s"${"*" * 10}\nDependencies: $dependencies\n${"*" * 10}")

    sc.stop()
  }

  def saveToCassandra(sc: SparkContext, dependencies: DependenciesInfo): Unit = {
    val thrift = dependencies.toDependencies(startTs = params.startTs, endTs = params.endTs).toThrift
    val blob: Array[Byte] = Codecs.DependenciesCodec.encode(thrift).array()

    val day = Time.fromMilliseconds(params.endTs).floor(Duration.fromTimeUnit(1, DAYS)).inMilliseconds

    val output = (day, blob)

    sc.parallelize(Seq(output)).saveToCassandra(params.keyspace, "dependencies", SomeColumns("day" as "_1", "dependencies" as "_2"))
    println(s"Saved with day=$day (${Time.fromMilliseconds(day)})")
  }

  def floorToDay(ts: Long): Long = {
    Time.fromMilliseconds(ts).floor(Duration.fromTimeUnit(1, DAYS)).inMilliseconds
  }
}
