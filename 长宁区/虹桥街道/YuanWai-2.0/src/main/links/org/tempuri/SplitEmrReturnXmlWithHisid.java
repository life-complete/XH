/**
 * SplitEmrReturnXmlWithHisid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SplitEmrReturnXmlWithHisid  implements java.io.Serializable {
    private java.lang.String hisId;

    private java.lang.String splitName;

    public SplitEmrReturnXmlWithHisid() {
    }

    public SplitEmrReturnXmlWithHisid(
           java.lang.String hisId,
           java.lang.String splitName) {
           this.hisId = hisId;
           this.splitName = splitName;
    }


    /**
     * Gets the hisId value for this SplitEmrReturnXmlWithHisid.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this SplitEmrReturnXmlWithHisid.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the splitName value for this SplitEmrReturnXmlWithHisid.
     * 
     * @return splitName
     */
    public java.lang.String getSplitName() {
        return splitName;
    }


    /**
     * Sets the splitName value for this SplitEmrReturnXmlWithHisid.
     * 
     * @param splitName
     */
    public void setSplitName(java.lang.String splitName) {
        this.splitName = splitName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlWithHisid)) return false;
        SplitEmrReturnXmlWithHisid other = (SplitEmrReturnXmlWithHisid) obj;
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
            ((this.splitName==null && other.getSplitName()==null) || 
             (this.splitName!=null &&
              this.splitName.equals(other.getSplitName())));
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
        if (getSplitName() != null) {
            _hashCode += getSplitName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlWithHisid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlWithHisid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HisId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "splitName"));
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
