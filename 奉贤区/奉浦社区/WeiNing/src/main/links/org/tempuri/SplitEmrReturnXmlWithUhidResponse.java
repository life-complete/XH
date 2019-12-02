/**
 * SplitEmrReturnXmlWithUhidResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SplitEmrReturnXmlWithUhidResponse  implements java.io.Serializable {
    private java.lang.String splitEmrReturnXmlWithUhidResult;

    public SplitEmrReturnXmlWithUhidResponse() {
    }

    public SplitEmrReturnXmlWithUhidResponse(
           java.lang.String splitEmrReturnXmlWithUhidResult) {
           this.splitEmrReturnXmlWithUhidResult = splitEmrReturnXmlWithUhidResult;
    }


    /**
     * Gets the splitEmrReturnXmlWithUhidResult value for this SplitEmrReturnXmlWithUhidResponse.
     * 
     * @return splitEmrReturnXmlWithUhidResult
     */
    public java.lang.String getSplitEmrReturnXmlWithUhidResult() {
        return splitEmrReturnXmlWithUhidResult;
    }


    /**
     * Sets the splitEmrReturnXmlWithUhidResult value for this SplitEmrReturnXmlWithUhidResponse.
     * 
     * @param splitEmrReturnXmlWithUhidResult
     */
    public void setSplitEmrReturnXmlWithUhidResult(java.lang.String splitEmrReturnXmlWithUhidResult) {
        this.splitEmrReturnXmlWithUhidResult = splitEmrReturnXmlWithUhidResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlWithUhidResponse)) return false;
        SplitEmrReturnXmlWithUhidResponse other = (SplitEmrReturnXmlWithUhidResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.splitEmrReturnXmlWithUhidResult==null && other.getSplitEmrReturnXmlWithUhidResult()==null) || 
             (this.splitEmrReturnXmlWithUhidResult!=null &&
              this.splitEmrReturnXmlWithUhidResult.equals(other.getSplitEmrReturnXmlWithUhidResult())));
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
        if (getSplitEmrReturnXmlWithUhidResult() != null) {
            _hashCode += getSplitEmrReturnXmlWithUhidResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlWithUhidResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlWithUhidResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitEmrReturnXmlWithUhidResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SplitEmrReturnXmlWithUhidResult"));
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
