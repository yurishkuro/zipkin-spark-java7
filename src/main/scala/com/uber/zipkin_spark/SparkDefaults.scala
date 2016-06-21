package com.uber.zipkin_spark_java7

import java.util.concurrent.TimeUnit._

import com.twitter.util.{Duration, Time}
import org.apache.spark.{SparkContext, SparkConf}

/**
  * To run with local Cassandra and Spark Master, specify env RUN_LOCAL_SPARK=1
  */
object SparkDefaults {

  val runLocal: Boolean = sys.env.get("RUN_LOCAL_SPARK").isDefined

  val keyspace = if (runLocal) {
    sys.env.getOrElse("CASSANDRA_KEYSPACE", "zipkin")
  } else {
    sys.env.getOrElse("CASSANDRA_KEYSPACE", "zipkin")
  }

  val cassandraProperties = if (runLocal) {
    Map(
      "spark.cassandra.connection.host" -> sys.env.getOrElse("CASSANDRA_HOST", "127.0.0.1"),
      "spark.cassandra.connection.local_dc" -> sys.env.getOrElse("CASSANDRA_LOCAL_DC", "datacenter1"),
      "spark.cassandra.read.timeout_ms" -> sys.env.getOrElse("CASSANDRA_READ_TIMEOUT_MS", "300000")
    )
  } else {
    Map(
      "spark.cassandra.connection.host" -> sys.env.getOrElse("CASSANDRA_HOST", "127.0.0.1"),
      "spark.cassandra.connection.port" -> sys.env.getOrElse("CASSANDRA_PORT", "9042"),
      "spark.cassandra.auth.username" -> sys.env.getOrElse("CASSANDRA_USERNAME", ""),
      "spark.cassandra.auth.password" -> sys.env.getOrElse("CASSANDRA_PASSWORD", ""),
      "spark.cassandra.connection.local_dc" -> sys.env.getOrElse("CASSANDRA_LOCAL_DC", "dc1"),
      "spark.cassandra.read.timeout_ms" -> sys.env.getOrElse("CASSANDRA_READ_TIMEOUT_MS", "300000")
    )
  }

  val udkDefaultProperties: Map[String, String] = if (runLocal) {
    Map()
  } else {
    Map(
    )
  }

  // local[*] master lets us run & test the job locally without setting a Spark cluster
  val sparkMaster = sys.env.getOrElse("SPARK_MASTER", "local[*]")

  // By default the job only considers spans with timestamps up to previous midnight
  val defaultEndTs: Long = Time.now.floor(Duration.fromTimeUnit(1, DAYS)).inMilliseconds

  // By default the job only accounts for spans in the 24hrs prior to previous midnight
  val defaultLookback: Long = Duration.fromTimeUnit(1, DAYS).inMilliseconds
}

case class SparkDefaults(sparkMaster: String = SparkDefaults.sparkMaster,
                          cassandraProperties: Map[String, String] = SparkDefaults.cassandraProperties,
                          keyspace: String = SparkDefaults.keyspace,
                          endTs: Long = SparkDefaults.defaultEndTs,
                          lookback: Long = SparkDefaults.defaultLookback) {

  val startTs = endTs - lookback
  val microsUpper = endTs * 1000
  val microsLower = startTs * 1000

  def getSparkContext[T](cls: Class[T]): SparkContext = {
    val conf = new SparkConf(true)
      .setAll(SparkDefaults.udkDefaultProperties ++ cassandraProperties)
      .setAppName(cls.getName)
    val conf1 = if (SparkDefaults.runLocal) {
      conf.setMaster(sparkMaster)
    } else {
      conf
    }
    val sc = new SparkContext(conf1)

    System.err.println("CLASSPATH:" + System.getProperty("java.class.path"))

    return sc
  }
}
