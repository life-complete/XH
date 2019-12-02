/**
 * SplitEmrReturnXmlWithUhid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SplitEmrReturnXmlWithUhid  implements java.io.Serializable {
    private java.lang.String uhid;

    private java.lang.String splitName;

    public SplitEmrReturnXmlWithUhid() {
    }

    public SplitEmrReturnXmlWithUhid(
           java.lang.String uhid,
           java.lang.String splitName) {
           this.uhid = uhid;
           this.splitName = splitName;
    }


    /**
     * Gets the uhid value for this SplitEmrReturnXmlWithUhid.
     * 
     * @return uhid
     */
    public java.lang.String getUhid() {
        return uhid;
    }


    /**
     * Sets the uhid value for this SplitEmrReturnXmlWithUhid.
     * 
     * @param uhid
     */
    public void setUhid(java.lang.String uhid) {
        this.uhid = uhid;
    }


    /**
     * Gets the splitName value for this SplitEmrReturnXmlWithUhid.
     * 
     * @return splitName
     */
    public java.lang.String getSplitName() {
        return splitName;
    }


    /**
     * Sets the splitName value for this SplitEmrReturnXmlWithUhid.
     * 
     * @param splitName
     */
    public void setSplitName(java.lang.String splitName) {
        this.splitName = splitName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlWithUhid)) return false;
        SplitEmrReturnXmlWithUhid other = (SplitEmrReturnXmlWithUhid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uhid==null && other.getUhid()==null) || 
             (this.uhid!=null &&
              this.uhid.equals(other.getUhid()))) &&
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
        if (getUhid() != null) {
            _hashCode += getUhid().hashCode();
        }
        if (getSplitName() != null) {
            _hashCode += getSplitName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlWithUhid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlWithUhid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uhid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Uhid"));
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
