/**
 * GetEmrPrgrphEntityByPrgrphCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmrPrgrphEntityByPrgrphCode  implements java.io.Serializable {
    private java.lang.String hisId;

    private java.lang.String primaryType;

    private java.lang.String paragraphCode;

    public GetEmrPrgrphEntityByPrgrphCode() {
    }

    public GetEmrPrgrphEntityByPrgrphCode(
           java.lang.String hisId,
           java.lang.String primaryType,
           java.lang.String paragraphCode) {
           this.hisId = hisId;
           this.primaryType = primaryType;
           this.paragraphCode = paragraphCode;
    }


    /**
     * Gets the hisId value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the primaryType value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @return primaryType
     */
    public java.lang.String getPrimaryType() {
        return primaryType;
    }


    /**
     * Sets the primaryType value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @param primaryType
     */
    public void setPrimaryType(java.lang.String primaryType) {
        this.primaryType = primaryType;
    }


    /**
     * Gets the paragraphCode value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @return paragraphCode
     */
    public java.lang.String getParagraphCode() {
        return paragraphCode;
    }


    /**
     * Sets the paragraphCode value for this GetEmrPrgrphEntityByPrgrphCode.
     * 
     * @param paragraphCode
     */
    public void setParagraphCode(java.lang.String paragraphCode) {
        this.paragraphCode = paragraphCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmrPrgrphEntityByPrgrphCode)) return false;
        GetEmrPrgrphEntityByPrgrphCode other = (GetEmrPrgrphEntityByPrgrphCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hisId==null && other.getHisId()==null) || 
             (this.hisId!=null &&
              this.hisId.equals(other.getHisId()))) &&
            ((this.primaryType==null && other.getPrimaryType()==null) || 
             (this.primaryType!=null &&
              this.primaryType.equals(other.getPrimaryType()))) &&
            ((this.paragraphCode==null && other.getParagraphCode()==null) || 
             (this.paragraphCode!=null &&
              this.paragraphCode.equals(other.getParagraphCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHisId() != null) {
            _hashCode += getHisId().hashCode();
        }
        if (getPrimaryType() != null) {
            _hashCode += getPrimaryType().hashCode();
        }
        if (getParagraphCode() != null) {
            _hashCode += getParagraphCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmrPrgrphEntityByPrgrphCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmrPrgrphEntityByPrgrphCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "hisId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "primaryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "paragraphCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
