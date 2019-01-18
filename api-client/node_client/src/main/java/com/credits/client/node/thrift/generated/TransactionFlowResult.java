/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-18")
public class TransactionFlowResult implements org.apache.thrift.TBase<TransactionFlowResult, TransactionFlowResult._Fields>, java.io.Serializable, Cloneable, Comparable<TransactionFlowResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TransactionFlowResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField SMART_CONTRACT_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("smart_contract_result", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField ROUND_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("roundNum", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TransactionFlowResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TransactionFlowResultTupleSchemeFactory();

  public com.credits.general.thrift.generated.APIResponse status; // required
  public com.credits.general.thrift.generated.Variant smart_contract_result; // optional
  public int roundNum; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    SMART_CONTRACT_RESULT((short)2, "smart_contract_result"),
    ROUND_NUM((short)3, "roundNum");

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
        case 2: // SMART_CONTRACT_RESULT
          return SMART_CONTRACT_RESULT;
        case 3: // ROUND_NUM
          return ROUND_NUM;
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
  private static final int __ROUNDNUM_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SMART_CONTRACT_RESULT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.APIResponse.class)));
    tmpMap.put(_Fields.SMART_CONTRACT_RESULT, new org.apache.thrift.meta_data.FieldMetaData("smart_contract_result", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.Variant.class)));
    tmpMap.put(_Fields.ROUND_NUM, new org.apache.thrift.meta_data.FieldMetaData("roundNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TransactionFlowResult.class, metaDataMap);
  }

  public TransactionFlowResult() {
  }

  public TransactionFlowResult(
    com.credits.general.thrift.generated.APIResponse status,
    int roundNum)
  {
    this();
    this.status = status;
    this.roundNum = roundNum;
    setRoundNumIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TransactionFlowResult(TransactionFlowResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStatus()) {
      this.status = new com.credits.general.thrift.generated.APIResponse(other.status);
    }
    if (other.isSetSmart_contract_result()) {
      this.smart_contract_result = new com.credits.general.thrift.generated.Variant(other.smart_contract_result);
    }
    this.roundNum = other.roundNum;
  }

  public TransactionFlowResult deepCopy() {
    return new TransactionFlowResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.smart_contract_result = null;
    setRoundNumIsSet(false);
    this.roundNum = 0;
  }

  public com.credits.general.thrift.generated.APIResponse getStatus() {
    return this.status;
  }

  public TransactionFlowResult setStatus(com.credits.general.thrift.generated.APIResponse status) {
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

  public com.credits.general.thrift.generated.Variant getSmart_contract_result() {
    return this.smart_contract_result;
  }

  public TransactionFlowResult setSmart_contract_result(com.credits.general.thrift.generated.Variant smart_contract_result) {
    this.smart_contract_result = smart_contract_result;
    return this;
  }

  public void unsetSmart_contract_result() {
    this.smart_contract_result = null;
  }

  /** Returns true if field smart_contract_result is set (has been assigned a value) and false otherwise */
  public boolean isSetSmart_contract_result() {
    return this.smart_contract_result != null;
  }

  public void setSmart_contract_resultIsSet(boolean value) {
    if (!value) {
      this.smart_contract_result = null;
    }
  }

  public int getRoundNum() {
    return this.roundNum;
  }

  public TransactionFlowResult setRoundNum(int roundNum) {
    this.roundNum = roundNum;
    setRoundNumIsSet(true);
    return this;
  }

  public void unsetRoundNum() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ROUNDNUM_ISSET_ID);
  }

  /** Returns true if field roundNum is set (has been assigned a value) and false otherwise */
  public boolean isSetRoundNum() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ROUNDNUM_ISSET_ID);
  }

  public void setRoundNumIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ROUNDNUM_ISSET_ID, value);
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

    case SMART_CONTRACT_RESULT:
      if (value == null) {
        unsetSmart_contract_result();
      } else {
        setSmart_contract_result((com.credits.general.thrift.generated.Variant)value);
      }
      break;

    case ROUND_NUM:
      if (value == null) {
        unsetRoundNum();
      } else {
        setRoundNum((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case SMART_CONTRACT_RESULT:
      return getSmart_contract_result();

    case ROUND_NUM:
      return getRoundNum();

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
    case SMART_CONTRACT_RESULT:
      return isSetSmart_contract_result();
    case ROUND_NUM:
      return isSetRoundNum();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TransactionFlowResult)
      return this.equals((TransactionFlowResult)that);
    return false;
  }

  public boolean equals(TransactionFlowResult that) {
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

    boolean this_present_smart_contract_result = true && this.isSetSmart_contract_result();
    boolean that_present_smart_contract_result = true && that.isSetSmart_contract_result();
    if (this_present_smart_contract_result || that_present_smart_contract_result) {
      if (!(this_present_smart_contract_result && that_present_smart_contract_result))
        return false;
      if (!this.smart_contract_result.equals(that.smart_contract_result))
        return false;
    }

    boolean this_present_roundNum = true;
    boolean that_present_roundNum = true;
    if (this_present_roundNum || that_present_roundNum) {
      if (!(this_present_roundNum && that_present_roundNum))
        return false;
      if (this.roundNum != that.roundNum)
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

    hashCode = hashCode * 8191 + ((isSetSmart_contract_result()) ? 131071 : 524287);
    if (isSetSmart_contract_result())
      hashCode = hashCode * 8191 + smart_contract_result.hashCode();

    hashCode = hashCode * 8191 + roundNum;

    return hashCode;
  }

  @Override
  public int compareTo(TransactionFlowResult other) {
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
    lastComparison = java.lang.Boolean.valueOf(isSetSmart_contract_result()).compareTo(other.isSetSmart_contract_result());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSmart_contract_result()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.smart_contract_result, other.smart_contract_result);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetRoundNum()).compareTo(other.isSetRoundNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoundNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roundNum, other.roundNum);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TransactionFlowResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (isSetSmart_contract_result()) {
      if (!first) sb.append(", ");
      sb.append("smart_contract_result:");
      if (this.smart_contract_result == null) {
        sb.append("null");
      } else {
        sb.append(this.smart_contract_result);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("roundNum:");
    sb.append(this.roundNum);
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

  private static class TransactionFlowResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TransactionFlowResultStandardScheme getScheme() {
      return new TransactionFlowResultStandardScheme();
    }
  }

  private static class TransactionFlowResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TransactionFlowResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TransactionFlowResult struct) throws org.apache.thrift.TException {
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
          case 2: // SMART_CONTRACT_RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.smart_contract_result = new com.credits.general.thrift.generated.Variant();
              struct.smart_contract_result.read(iprot);
              struct.setSmart_contract_resultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ROUND_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.roundNum = iprot.readI32();
              struct.setRoundNumIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TransactionFlowResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.smart_contract_result != null) {
        if (struct.isSetSmart_contract_result()) {
          oprot.writeFieldBegin(SMART_CONTRACT_RESULT_FIELD_DESC);
          struct.smart_contract_result.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(ROUND_NUM_FIELD_DESC);
      oprot.writeI32(struct.roundNum);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TransactionFlowResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TransactionFlowResultTupleScheme getScheme() {
      return new TransactionFlowResultTupleScheme();
    }
  }

  private static class TransactionFlowResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TransactionFlowResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TransactionFlowResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetSmart_contract_result()) {
        optionals.set(1);
      }
      if (struct.isSetRoundNum()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatus()) {
        struct.status.write(oprot);
      }
      if (struct.isSetSmart_contract_result()) {
        struct.smart_contract_result.write(oprot);
      }
      if (struct.isSetRoundNum()) {
        oprot.writeI32(struct.roundNum);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TransactionFlowResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.status = new com.credits.general.thrift.generated.APIResponse();
        struct.status.read(iprot);
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.smart_contract_result = new com.credits.general.thrift.generated.Variant();
        struct.smart_contract_result.read(iprot);
        struct.setSmart_contract_resultIsSet(true);
      }
      if (incoming.get(2)) {
        struct.roundNum = iprot.readI32();
        struct.setRoundNumIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

