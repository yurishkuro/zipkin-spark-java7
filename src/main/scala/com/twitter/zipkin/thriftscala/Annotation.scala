/**
 * Generated by Scrooge
 *   version: 4.3.0
 *   rev: 64fd5eddcaea45735958d3f67f49152ca9767a5e
 *   built at: 20151205-094831
 */
package com.twitter.zipkin.thriftscala

import com.twitter.scrooge.{
  LazyTProtocol,
  TFieldBlob, ThriftException, ThriftStruct, ThriftStructCodec3, ThriftStructFieldInfo,
  ThriftStructMetaData, ThriftUtil}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}

/**
 * Associates an event that explains latency with a timestamp.
 *
 * Unlike log statements, annotations are often codes: for example "sr".
 */
object Annotation extends ThriftStructCodec3[Annotation] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("Annotation")
  val TimestampField = new TField("timestamp", TType.I64, 1)
  val TimestampFieldManifest = implicitly[Manifest[Long]]
  val ValueField = new TField("value", TType.STRING, 2)
  val ValueFieldManifest = implicitly[Manifest[String]]
  val HostField = new TField("host", TType.STRUCT, 3)
  val HostFieldManifest = implicitly[Manifest[com.twitter.zipkin.thriftscala.Endpoint]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      TimestampField,
      false,
      false,
      TimestampFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      ValueField,
      false,
      false,
      ValueFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      HostField,
      true,
      false,
      HostFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Annotation): Unit = {
  }

  def withoutPassthroughFields(original: Annotation): Annotation =
    new Immutable(
      timestamp =
        {
          val field = original.timestamp
          field
        },
      value =
        {
          val field = original.value
          field
        },
      host =
        {
          val field = original.host
          field.map { field =>
            com.twitter.zipkin.thriftscala.Endpoint.withoutPassthroughFields(field)
          }
        }
    )

  override def encode(_item: Annotation, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  private[this] def lazyDecode(_iprot: LazyTProtocol): Annotation = {

    var timestamp: Long = 0L
    var valueOffset: Int = -1
    var host: Option[com.twitter.zipkin.thriftscala.Endpoint] = None

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>
    
                timestamp = readTimestampValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'timestamp' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                valueOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'value' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                host = Some(readHostValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'host' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      timestamp,
      valueOffset,
      host,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): Annotation =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[this] def eagerDecode(_iprot: TProtocol): Annotation = {
    var timestamp: Long = 0L
    var value: String = null
    var host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = _root_.scala.None
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>
                timestamp = readTimestampValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'timestamp' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                value = readValueValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'value' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
                host = _root_.scala.Some(readHostValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'host' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new Immutable(
      timestamp,
      value,
      host,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    timestamp: Long,
    value: String,
    host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = _root_.scala.None
  ): Annotation =
    new Immutable(
      timestamp,
      value,
      host
    )

  def unapply(_item: Annotation): _root_.scala.Option[scala.Product3[Long, String, Option[com.twitter.zipkin.thriftscala.Endpoint]]] = _root_.scala.Some(_item)


  @inline private def readTimestampValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeTimestampField(timestamp_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(TimestampField)
    writeTimestampValue(timestamp_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeTimestampValue(timestamp_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(timestamp_item)
  }

  @inline private def readValueValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeValueField(value_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ValueField)
    writeValueValue(value_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeValueValue(value_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(value_item)
  }

  @inline private def readHostValue(_iprot: TProtocol): com.twitter.zipkin.thriftscala.Endpoint = {
    com.twitter.zipkin.thriftscala.Endpoint.decode(_iprot)
  }

  @inline private def writeHostField(host_item: com.twitter.zipkin.thriftscala.Endpoint, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(HostField)
    writeHostValue(host_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeHostValue(host_item: com.twitter.zipkin.thriftscala.Endpoint, _oprot: TProtocol): Unit = {
    host_item.write(_oprot)
  }


  object Immutable extends ThriftStructCodec3[Annotation] {
    override def encode(_item: Annotation, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Annotation = Annotation.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Annotation] = Annotation.metaData
  }

  /**
   * The default read-only implementation of Annotation.  You typically should not need to
   * directly reference this class; instead, use the Annotation.apply method to construct
   * new instances.
   */
  class Immutable(
      val timestamp: Long,
      val value: String,
      val host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Annotation {
    def this(
      timestamp: Long,
      value: String,
      host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = _root_.scala.None
    ) = this(
      timestamp,
      value,
      host,
      Map.empty
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val timestamp: Long,
      valueOffset: Int,
      val host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Annotation {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val value: String =
      if (valueOffset == -1)
        null
      else {
        _proto.decodeString(_buf, valueOffset)
      }

    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the Annotation trait with additional state or
   * behavior and implement the read-only methods from Annotation using an underlying
   * instance.
   */
  trait Proxy extends Annotation {
    protected def _underlying_Annotation: Annotation
    override def timestamp: Long = _underlying_Annotation.timestamp
    override def value: String = _underlying_Annotation.value
    override def host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = _underlying_Annotation.host
    override def _passthroughFields = _underlying_Annotation._passthroughFields
  }
}

trait Annotation
  extends ThriftStruct
  with scala.Product3[Long, String, Option[com.twitter.zipkin.thriftscala.Endpoint]]
  with java.io.Serializable
{
  import Annotation._

  def timestamp: Long
  def value: String
  def host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = timestamp
  def _2 = value
  def _3 = host


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (true) {
                writeTimestampValue(timestamp, _oprot)
                _root_.scala.Some(Annotation.TimestampField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (value ne null) {
                writeValueValue(value, _oprot)
                _root_.scala.Some(Annotation.ValueField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (host.isDefined) {
                writeHostValue(host.get, _oprot)
                _root_.scala.Some(Annotation.HostField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
            _root_.scala.Some(TFieldBlob(_field, _data))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): Annotation = {
    var timestamp: Long = this.timestamp
    var value: String = this.value
    var host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = this.host
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        timestamp = readTimestampValue(_blob.read)
      case 2 =>
        value = readValueValue(_blob.read)
      case 3 =>
        host = _root_.scala.Some(readHostValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      timestamp,
      value,
      host,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Annotation = {
    var timestamp: Long = this.timestamp
    var value: String = this.value
    var host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = this.host

    _fieldId match {
      case 1 =>
        timestamp = 0L
      case 2 =>
        value = null
      case 3 =>
        host = _root_.scala.None
      case _ =>
    }
    new Immutable(
      timestamp,
      value,
      host,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetTimestamp: Annotation = unsetField(1)

  def unsetValue: Annotation = unsetField(2)

  def unsetHost: Annotation = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    Annotation.validate(this)
    _oprot.writeStructBegin(Struct)
    writeTimestampField(timestamp, _oprot)
    if (value ne null) writeValueField(value, _oprot)
    if (host.isDefined) writeHostField(host.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    timestamp: Long = this.timestamp,
    value: String = this.value,
    host: _root_.scala.Option[com.twitter.zipkin.thriftscala.Endpoint] = this.host,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Annotation =
    new Immutable(
      timestamp,
      value,
      host,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Annotation]

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
      _passthroughFields == other.asInstanceOf[Annotation]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.timestamp
    case 1 => this.value
    case 2 => this.host
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Annotation"
}
