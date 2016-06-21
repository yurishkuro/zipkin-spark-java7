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


object Dependencies extends ThriftStructCodec3[Dependencies] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("Dependencies")
  val StartTsField = new TField("start_ts", TType.I64, 1)
  val StartTsFieldManifest = implicitly[Manifest[Long]]
  val EndTsField = new TField("end_ts", TType.I64, 2)
  val EndTsFieldManifest = implicitly[Manifest[Long]]
  val LinksField = new TField("links", TType.LIST, 3)
  val LinksFieldManifest = implicitly[Manifest[Seq[com.twitter.zipkin.thriftscala.DependencyLink]]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      StartTsField,
      false,
      false,
      StartTsFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      EndTsField,
      false,
      false,
      EndTsFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    ),
    new ThriftStructFieldInfo(
      LinksField,
      false,
      false,
      LinksFieldManifest,
      _root_.scala.None,
      _root_.scala.Some(implicitly[Manifest[com.twitter.zipkin.thriftscala.DependencyLink]]),
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String]
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Dependencies): Unit = {
  }

  def withoutPassthroughFields(original: Dependencies): Dependencies =
    new Immutable(
      startTs =
        {
          val field = original.startTs
          field
        },
      endTs =
        {
          val field = original.endTs
          field
        },
      links =
        {
          val field = original.links
          field.map { field =>
            com.twitter.zipkin.thriftscala.DependencyLink.withoutPassthroughFields(field)
          }
        }
    )

  override def encode(_item: Dependencies, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  private[this] def lazyDecode(_iprot: LazyTProtocol): Dependencies = {

    var startTs: Long = 0L
    var endTs: Long = 0L
    var links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = Seq[com.twitter.zipkin.thriftscala.DependencyLink]()

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
    
                startTs = readStartTsValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'startTs' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I64 =>
    
                endTs = readEndTsValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'endTs' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.LIST =>
    
                links = readLinksValue(_iprot)
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'links' (expected=%s, actual=%s).".format(
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
      startTs,
      endTs,
      links,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): Dependencies =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[this] def eagerDecode(_iprot: TProtocol): Dependencies = {
    var startTs: Long = 0L
    var endTs: Long = 0L
    var links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = Seq[com.twitter.zipkin.thriftscala.DependencyLink]()
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
                startTs = readStartTsValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'startTs' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I64 =>
                endTs = readEndTsValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'endTs' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.LIST =>
                links = readLinksValue(_iprot)
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'links' (expected=%s, actual=%s).".format(
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
      startTs,
      endTs,
      links,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    startTs: Long,
    endTs: Long,
    links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = Seq[com.twitter.zipkin.thriftscala.DependencyLink]()
  ): Dependencies =
    new Immutable(
      startTs,
      endTs,
      links
    )

  def unapply(_item: Dependencies): _root_.scala.Option[scala.Product3[Long, Long, Seq[com.twitter.zipkin.thriftscala.DependencyLink]]] = _root_.scala.Some(_item)


  @inline private def readStartTsValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeStartTsField(startTs_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(StartTsField)
    writeStartTsValue(startTs_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeStartTsValue(startTs_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(startTs_item)
  }

  @inline private def readEndTsValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeEndTsField(endTs_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(EndTsField)
    writeEndTsValue(endTs_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeEndTsValue(endTs_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(endTs_item)
  }

  @inline private def readLinksValue(_iprot: TProtocol): Seq[com.twitter.zipkin.thriftscala.DependencyLink] = {
    val _list = _iprot.readListBegin()
    if (_list.size == 0) {
      _iprot.readListEnd()
      Nil
    } else {
      val _rv = new mutable$ArrayBuffer[com.twitter.zipkin.thriftscala.DependencyLink](_list.size)
      var _i = 0
      while (_i < _list.size) {
        _rv += {
          com.twitter.zipkin.thriftscala.DependencyLink.decode(_iprot)
        }
        _i += 1
      }
      _iprot.readListEnd()
      _rv
    }
  }

  @inline private def writeLinksField(links_item: Seq[com.twitter.zipkin.thriftscala.DependencyLink], _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(LinksField)
    writeLinksValue(links_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeLinksValue(links_item: Seq[com.twitter.zipkin.thriftscala.DependencyLink], _oprot: TProtocol): Unit = {
    _oprot.writeListBegin(new TList(TType.STRUCT, links_item.size))
    links_item match {
      case _: IndexedSeq[_] =>
        var _i = 0
        val _size = links_item.size
        while (_i < _size) {
          val links_item_element = links_item(_i)
          links_item_element.write(_oprot)
          _i += 1
        }
      case _ =>
        links_item.foreach { links_item_element =>
          links_item_element.write(_oprot)
        }
    }
    _oprot.writeListEnd()
  }


  object Immutable extends ThriftStructCodec3[Dependencies] {
    override def encode(_item: Dependencies, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Dependencies = Dependencies.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Dependencies] = Dependencies.metaData
  }

  /**
   * The default read-only implementation of Dependencies.  You typically should not need to
   * directly reference this class; instead, use the Dependencies.apply method to construct
   * new instances.
   */
  class Immutable(
      val startTs: Long,
      val endTs: Long,
      val links: Seq[com.twitter.zipkin.thriftscala.DependencyLink],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Dependencies {
    def this(
      startTs: Long,
      endTs: Long,
      links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = Seq[com.twitter.zipkin.thriftscala.DependencyLink]()
    ) = this(
      startTs,
      endTs,
      links,
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
      val startTs: Long,
      val endTs: Long,
      val links: Seq[com.twitter.zipkin.thriftscala.DependencyLink],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Dependencies {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
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
   * This Proxy trait allows you to extend the Dependencies trait with additional state or
   * behavior and implement the read-only methods from Dependencies using an underlying
   * instance.
   */
  trait Proxy extends Dependencies {
    protected def _underlying_Dependencies: Dependencies
    override def startTs: Long = _underlying_Dependencies.startTs
    override def endTs: Long = _underlying_Dependencies.endTs
    override def links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = _underlying_Dependencies.links
    override def _passthroughFields = _underlying_Dependencies._passthroughFields
  }
}

trait Dependencies
  extends ThriftStruct
  with scala.Product3[Long, Long, Seq[com.twitter.zipkin.thriftscala.DependencyLink]]
  with java.io.Serializable
{
  import Dependencies._

  def startTs: Long
  def endTs: Long
  def links: Seq[com.twitter.zipkin.thriftscala.DependencyLink]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = startTs
  def _2 = endTs
  def _3 = links


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
                writeStartTsValue(startTs, _oprot)
                _root_.scala.Some(Dependencies.StartTsField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (true) {
                writeEndTsValue(endTs, _oprot)
                _root_.scala.Some(Dependencies.EndTsField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (links ne null) {
                writeLinksValue(links, _oprot)
                _root_.scala.Some(Dependencies.LinksField)
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
  def setField(_blob: TFieldBlob): Dependencies = {
    var startTs: Long = this.startTs
    var endTs: Long = this.endTs
    var links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = this.links
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        startTs = readStartTsValue(_blob.read)
      case 2 =>
        endTs = readEndTsValue(_blob.read)
      case 3 =>
        links = readLinksValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      startTs,
      endTs,
      links,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Dependencies = {
    var startTs: Long = this.startTs
    var endTs: Long = this.endTs
    var links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = this.links

    _fieldId match {
      case 1 =>
        startTs = 0L
      case 2 =>
        endTs = 0L
      case 3 =>
        links = Seq[com.twitter.zipkin.thriftscala.DependencyLink]()
      case _ =>
    }
    new Immutable(
      startTs,
      endTs,
      links,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetStartTs: Dependencies = unsetField(1)

  def unsetEndTs: Dependencies = unsetField(2)

  def unsetLinks: Dependencies = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    Dependencies.validate(this)
    _oprot.writeStructBegin(Struct)
    writeStartTsField(startTs, _oprot)
    writeEndTsField(endTs, _oprot)
    if (links ne null) writeLinksField(links, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    startTs: Long = this.startTs,
    endTs: Long = this.endTs,
    links: Seq[com.twitter.zipkin.thriftscala.DependencyLink] = this.links,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Dependencies =
    new Immutable(
      startTs,
      endTs,
      links,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Dependencies]

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
      _passthroughFields == other.asInstanceOf[Dependencies]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.startTs
    case 1 => this.endTs
    case 2 => this.links
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Dependencies"
}
