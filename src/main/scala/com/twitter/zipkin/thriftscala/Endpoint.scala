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
 * Indicates the network context of a service recording an annotation with two
 * exceptions.
 *
 * When a BinaryAnnotation, and key is CLIENT_ADDR or SERVER_ADDR,
 * the endpoint indicates the source or destination of an RPC. This exception
 * allows zipkin to display network context of uninstrumented services, or
 * clients such as web browsers.
 */
object Endpoint extends ThriftStructCodec3[Endpoint] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("Endpoint")
  val Ipv4Field = new TField("ipv4", TType.I32, 1)
  val Ipv4FieldManifest = implicitly[Manifest[Int]]
  val PortField = new TField("port", TType.I16, 2)
  val PortFieldManifest = implicitly[Manifest[Short]]
  val ServiceNameField = new TField("service_name", TType.STRING, 3)
  val ServiceNameFieldManifest = implicitly[Manifest[String]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      Ipv4Field,
      false,
      false,
      Ipv4FieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      PortField,
      false,
      false,
      PortFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      ServiceNameField,
      false,
      false,
      ServiceNameFieldManifest,
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
  def validate(_item: Endpoint): Unit = {
  }

  def withoutPassthroughFields(original: Endpoint): Endpoint =
    new Immutable(
      ipv4 =
        {
          val field = original.ipv4
          field
        },
      port =
        {
          val field = original.port
          field
        },
      serviceName =
        {
          val field = original.serviceName
          field
        }
    )

  override def encode(_item: Endpoint, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  private[this] def lazyDecode(_iprot: LazyTProtocol): Endpoint = {

    var ipv4: Int = 0
    var port: Short = 0
    var service_nameOffset: Int = -1

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
              case TType.I32 =>
    
                ipv4 = readIpv4Value(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'ipv4' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I16 =>
    
                port = readPortValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I16
                throw new TProtocolException(
                  "Received wrong type for field 'port' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                service_nameOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'serviceName' (expected=%s, actual=%s).".format(
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
      ipv4,
      port,
      service_nameOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): Endpoint =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[this] def eagerDecode(_iprot: TProtocol): Endpoint = {
    var ipv4: Int = 0
    var port: Short = 0
    var serviceName: String = null
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
              case TType.I32 =>
                ipv4 = readIpv4Value(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'ipv4' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I16 =>
                port = readPortValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I16
                throw new TProtocolException(
                  "Received wrong type for field 'port' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                serviceName = readServiceNameValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'serviceName' (expected=%s, actual=%s).".format(
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
      ipv4,
      port,
      serviceName,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    ipv4: Int,
    port: Short,
    serviceName: String
  ): Endpoint =
    new Immutable(
      ipv4,
      port,
      serviceName
    )

  def unapply(_item: Endpoint): _root_.scala.Option[scala.Product3[Int, Short, String]] = _root_.scala.Some(_item)


  @inline private def readIpv4Value(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeIpv4Field(ipv4_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(Ipv4Field)
    writeIpv4Value(ipv4_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeIpv4Value(ipv4_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(ipv4_item)
  }

  @inline private def readPortValue(_iprot: TProtocol): Short = {
    _iprot.readI16()
  }

  @inline private def writePortField(port_item: Short, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(PortField)
    writePortValue(port_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writePortValue(port_item: Short, _oprot: TProtocol): Unit = {
    _oprot.writeI16(port_item)
  }

  @inline private def readServiceNameValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeServiceNameField(serviceName_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ServiceNameField)
    writeServiceNameValue(serviceName_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeServiceNameValue(serviceName_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(serviceName_item)
  }


  object Immutable extends ThriftStructCodec3[Endpoint] {
    override def encode(_item: Endpoint, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Endpoint = Endpoint.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Endpoint] = Endpoint.metaData
  }

  /**
   * The default read-only implementation of Endpoint.  You typically should not need to
   * directly reference this class; instead, use the Endpoint.apply method to construct
   * new instances.
   */
  class Immutable(
      val ipv4: Int,
      val port: Short,
      val serviceName: String,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Endpoint {
    def this(
      ipv4: Int,
      port: Short,
      serviceName: String
    ) = this(
      ipv4,
      port,
      serviceName,
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
      val ipv4: Int,
      val port: Short,
      service_nameOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Endpoint {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val serviceName: String =
      if (service_nameOffset == -1)
        null
      else {
        _proto.decodeString(_buf, service_nameOffset)
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
   * This Proxy trait allows you to extend the Endpoint trait with additional state or
   * behavior and implement the read-only methods from Endpoint using an underlying
   * instance.
   */
  trait Proxy extends Endpoint {
    protected def _underlying_Endpoint: Endpoint
    override def ipv4: Int = _underlying_Endpoint.ipv4
    override def port: Short = _underlying_Endpoint.port
    override def serviceName: String = _underlying_Endpoint.serviceName
    override def _passthroughFields = _underlying_Endpoint._passthroughFields
  }
}

trait Endpoint
  extends ThriftStruct
  with scala.Product3[Int, Short, String]
  with java.io.Serializable
{
  import Endpoint._

  def ipv4: Int
  def port: Short
  def serviceName: String

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = ipv4
  def _2 = port
  def _3 = serviceName


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
                writeIpv4Value(ipv4, _oprot)
                _root_.scala.Some(Endpoint.Ipv4Field)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (true) {
                writePortValue(port, _oprot)
                _root_.scala.Some(Endpoint.PortField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (serviceName ne null) {
                writeServiceNameValue(serviceName, _oprot)
                _root_.scala.Some(Endpoint.ServiceNameField)
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
  def setField(_blob: TFieldBlob): Endpoint = {
    var ipv4: Int = this.ipv4
    var port: Short = this.port
    var serviceName: String = this.serviceName
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        ipv4 = readIpv4Value(_blob.read)
      case 2 =>
        port = readPortValue(_blob.read)
      case 3 =>
        serviceName = readServiceNameValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      ipv4,
      port,
      serviceName,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Endpoint = {
    var ipv4: Int = this.ipv4
    var port: Short = this.port
    var serviceName: String = this.serviceName

    _fieldId match {
      case 1 =>
        ipv4 = 0
      case 2 =>
        port = 0
      case 3 =>
        serviceName = null
      case _ =>
    }
    new Immutable(
      ipv4,
      port,
      serviceName,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetIpv4: Endpoint = unsetField(1)

  def unsetPort: Endpoint = unsetField(2)

  def unsetServiceName: Endpoint = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    Endpoint.validate(this)
    _oprot.writeStructBegin(Struct)
    writeIpv4Field(ipv4, _oprot)
    writePortField(port, _oprot)
    if (serviceName ne null) writeServiceNameField(serviceName, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    ipv4: Int = this.ipv4,
    port: Short = this.port,
    serviceName: String = this.serviceName,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Endpoint =
    new Immutable(
      ipv4,
      port,
      serviceName,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Endpoint]

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
      _passthroughFields == other.asInstanceOf[Endpoint]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.ipv4
    case 1 => this.port
    case 2 => this.serviceName
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Endpoint"
}