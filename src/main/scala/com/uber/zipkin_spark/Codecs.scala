package com.uber.zipkin_spark_java7

import java.nio.ByteBuffer

import com.twitter.scrooge.{BinaryThriftStructSerializer, ThriftStruct, ThriftStructCodec}
import com.twitter.zipkin.thriftscala.{Dependencies => ThriftDependencies, Span => ThriftSpan}

/**
  * A bidirection encoding for column names or values.
  */
trait Codec[A] {
  def encode(obj: A): ByteBuffer
  def decode(ary: ByteBuffer): A

  /** To conveniently get the singleton/Object from Java. */
  def get() = this

  /** Helpers for conversion from ByteBuffers to byte arrays. Keep explicit! */
  def b2b(buff: ByteBuffer): Array[Byte] = {
    val bytes = new Array[Byte](buff.remaining)
    buff.duplicate.get(bytes)
    bytes
  }
  def b2b(array: Array[Byte]): ByteBuffer = ByteBuffer.wrap(array)
}

class ThriftCodec[T <: ThriftStruct](structCodec: ThriftStructCodec[T]) extends Codec[T] {
  val serializer = new BinaryThriftStructSerializer[T] { def codec = structCodec }

  def encode(t: T): ByteBuffer = b2b(serializer.toBytes(t))

  def decode(ary: ByteBuffer): T = serializer.fromBytes(b2b(ary))
}

object Codecs {
  val SpanCodec = new ThriftCodec[ThriftSpan](ThriftSpan)

  val DependenciesCodec = new ThriftCodec[ThriftDependencies](ThriftDependencies)
}
