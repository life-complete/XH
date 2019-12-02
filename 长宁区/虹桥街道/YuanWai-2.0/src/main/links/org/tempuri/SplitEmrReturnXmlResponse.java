/**
 * SplitEmrReturnXmlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SplitEmrReturnXmlResponse  implements java.io.Serializable {
    private int splitEmrReturnXmlResult;

    private java.lang.String splitList;

    public SplitEmrReturnXmlResponse() {
    }

    public SplitEmrReturnXmlResponse(
           int splitEmrReturnXmlResult,
           java.lang.String splitList) {
           this.splitEmrReturnXmlResult = splitEmrReturnXmlResult;
           this.splitList = splitList;
    }


    /**
     * Gets the splitEmrReturnXmlResult value for this SplitEmrReturnXmlResponse.
     * 
     * @return splitEmrReturnXmlResult
     */
    public int getSplitEmrReturnXmlResult() {
        return splitEmrReturnXmlResult;
    }


    /**
     * Sets the splitEmrReturnXmlResult value for this SplitEmrReturnXmlResponse.
     * 
     * @param splitEmrReturnXmlResult
     */
    public void setSplitEmrReturnXmlResult(int splitEmrReturnXmlResult) {
        this.splitEmrReturnXmlResult = splitEmrReturnXmlResult;
    }


    /**
     * Gets the splitList value for this SplitEmrReturnXmlResponse.
     * 
     * @return splitList
     */
    public java.lang.String getSplitList() {
        return splitList;
    }


    /**
     * Sets the splitList value for this SplitEmrReturnXmlResponse.
     * 
     * @param splitList
     */
    public void setSplitList(java.lang.String splitList) {
        this.splitList = splitList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlResponse)) return false;
        SplitEmrReturnXmlResponse other = (SplitEmrReturnXmlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.splitEmrReturnXmlResult == other.getSplitEmrReturnXmlResult() &&
            ((this.splitList==null && other.getSplitList()==null) || 
             (this.splitList!=null &&
              this.splitList.equals(other.getSplitList())));
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
        _hashCode += getSplitEmrReturnXmlResult();
        if (getSplitList() != null) {
            _hashCode += getSplitList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitEmrReturnXmlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SplitEmrReturnXmlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "splitList"));
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
