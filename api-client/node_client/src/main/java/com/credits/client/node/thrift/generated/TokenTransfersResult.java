/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-12-11")
public class TokenTransfersResult implements org.apache.thrift.TBase<TokenTransfersResult, TokenTransfersResult._Fields>, java.io.Serializable, Cloneable, Comparable<TokenTransfersResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TokenTransfersResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TRANSFERS_FIELD_DESC = new org.apache.thrift.protocol.TField("transfers", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TokenTransfersResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TokenTransfersResultTupleSchemeFactory();

  public com.credits.general.thrift.generated.APIResponse status; // required
  public int count; // required
  public java.util.List<TokenTransfer> transfers; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    COUNT((short)2, "count"),
    TRANSFERS((short)3, "transfers");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS
          return STATUS;
        case 2: // COUNT
          return COUNT;
        case 3: // TRANSFERS
          return TRANSFERS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __COUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.APIResponse.class)));
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TRANSFERS, new org.apache.thrift.meta_data.FieldMetaData("transfers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TokenTransfer.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TokenTransfersResult.class, metaDataMap);
  }

  public TokenTransfersResult() {
  }

  public TokenTransfersResult(
    com.credits.general.thrift.generated.APIResponse status,
    int count,
    java.util.List<TokenTransfer> transfers)
  {
    this();
    this.status = status;
    this.count = count;
    setCountIsSet(true);
    this.transfers = transfers;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TokenTransfersResult(TokenTransfersResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStatus()) {
      this.status = new com.credits.general.thrift.generated.APIResponse(other.status);
    }
    this.count = other.count;
    if (other.isSetTransfers()) {
      java.util.List<TokenTransfer> __this__transfers = new java.util.ArrayList<TokenTransfer>(other.transfers.size());
      for (TokenTransfer other_element : other.transfers) {
        __this__transfers.add(new TokenTransfer(other_element));
      }
      this.transfers = __this__transfers;
    }
  }

  public TokenTransfersResult deepCopy() {
    return new TokenTransfersResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    setCountIsSet(false);
    this.count = 0;
    this.transfers = null;
  }

  public com.credits.general.thrift.generated.APIResponse getStatus() {
    return this.status;
  }

  public TokenTransfersResult setStatus(com.credits.general.thrift.generated.APIResponse status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getCount() {
    return this.count;
  }

  public TokenTransfersResult setCount(int count) {
    this.count = count;
    setCountIsSet(true);
    return this;
  }

  public void unsetCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public int getTransfersSize() {
    return (this.transfers == null) ? 0 : this.transfers.size();
  }

  public java.util.Iterator<TokenTransfer> getTransfersIterator() {
    return (this.transfers == null) ? null : this.transfers.iterator();
  }

  public void addToTransfers(TokenTransfer elem) {
    if (this.transfers == null) {
      this.transfers = new java.util.ArrayList<TokenTransfer>();
    }
    this.transfers.add(elem);
  }

  public java.util.List<TokenTransfer> getTransfers() {
    return this.transfers;
  }

  public TokenTransfersResult setTransfers(java.util.List<TokenTransfer> transfers) {
    this.transfers = transfers;
    return this;
  }

  public void unsetTransfers() {
    this.transfers = null;
  }

  /** Returns true if field transfers is set (has been assigned a value) and false otherwise */
  public boolean isSetTransfers() {
    return this.transfers != null;
  }

  public void setTransfersIsSet(boolean value) {
    if (!value) {
      this.transfers = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((com.credits.general.thrift.generated.APIResponse)value);
      }
      break;

    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((java.lang.Integer)value);
      }
      break;

    case TRANSFERS:
      if (value == null) {
        unsetTransfers();
      } else {
        setTransfers((java.util.List<TokenTransfer>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case COUNT:
      return getCount();

    case TRANSFERS:
      return getTransfers();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case COUNT:
      return isSetCount();
    case TRANSFERS:
      return isSetTransfers();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TokenTransfersResult)
      return this.equals((TokenTransfersResult)that);
    return false;
  }

  public boolean equals(TokenTransfersResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    boolean this_present_transfers = true && this.isSetTransfers();
    boolean that_present_transfers = true && that.isSetTransfers();
    if (this_present_transfers || that_present_transfers) {
      if (!(this_present_transfers && that_present_transfers))
        return false;
      if (!this.transfers.equals(that.transfers))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.hashCode();

    hashCode = hashCode * 8191 + count;

    hashCode = hashCode * 8191 + ((isSetTransfers()) ? 131071 : 524287);
    if (isSetTransfers())
      hashCode = hashCode * 8191 + transfers.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TokenTransfersResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTransfers()).compareTo(other.isSetTransfers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransfers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transfers, other.transfers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TokenTransfersResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("transfers:");
    if (this.transfers == null) {
      sb.append("null");
    } else {
      sb.append(this.transfers);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (status != null) {
      status.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TokenTransfersResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TokenTransfersResultStandardScheme getScheme() {
      return new TokenTransfersResultStandardScheme();
    }
  }

  private static class TokenTransfersResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TokenTransfersResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TokenTransfersResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new com.credits.general.thrift.generated.APIResponse();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.count = iprot.readI32();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TRANSFERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list134 = iprot.readListBegin();
                struct.transfers = new java.util.ArrayList<TokenTransfer>(_list134.size);
                TokenTransfer _elem135;
                for (int _i136 = 0; _i136 < _list134.size; ++_i136)
                {
                  _elem135 = new TokenTransfer();
                  _elem135.read(iprot);
                  struct.transfers.add(_elem135);
                }
                iprot.readListEnd();
              }
              struct.setTransfersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TokenTransfersResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI32(struct.count);
      oprot.writeFieldEnd();
      if (struct.transfers != null) {
        oprot.writeFieldBegin(TRANSFERS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.transfers.size()));
          for (TokenTransfer _iter137 : struct.transfers)
          {
            _iter137.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TokenTransfersResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TokenTransfersResultTupleScheme getScheme() {
      return new TokenTransfersResultTupleScheme();
    }
  }

  private static class TokenTransfersResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TokenTransfersResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TokenTransfersResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetCount()) {
        optionals.set(1);
      }
      if (struct.isSetTransfers()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatus()) {
        struct.status.write(oprot);
      }
      if (struct.isSetCount()) {
        oprot.writeI32(struct.count);
      }
      if (struct.isSetTransfers()) {
        {
          oprot.writeI32(struct.transfers.size());
          for (TokenTransfer _iter138 : struct.transfers)
          {
            _iter138.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TokenTransfersResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.status = new com.credits.general.thrift.generated.APIResponse();
        struct.status.read(iprot);
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.count = iprot.readI32();
        struct.setCountIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list139 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.transfers = new java.util.ArrayList<TokenTransfer>(_list139.size);
          TokenTransfer _elem140;
          for (int _i141 = 0; _i141 < _list139.size; ++_i141)
          {
            _elem140 = new TokenTransfer();
            _elem140.read(iprot);
            struct.transfers.add(_elem140);
          }
        }
        struct.setTransfersIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

