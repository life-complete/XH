/**
 * GetConfigInfoToXmlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetConfigInfoToXmlResponse  implements java.io.Serializable {
    private java.lang.String getConfigInfoToXmlResult;

    public GetConfigInfoToXmlResponse() {
    }

    public GetConfigInfoToXmlResponse(
           java.lang.String getConfigInfoToXmlResult) {
           this.getConfigInfoToXmlResult = getConfigInfoToXmlResult;
    }


    /**
     * Gets the getConfigInfoToXmlResult value for this GetConfigInfoToXmlResponse.
     * 
     * @return getConfigInfoToXmlResult
     */
    public java.lang.String getGetConfigInfoToXmlResult() {
        return getConfigInfoToXmlResult;
    }


    /**
     * Sets the getConfigInfoToXmlResult value for this GetConfigInfoToXmlResponse.
     * 
     * @param getConfigInfoToXmlResult
     */
    public void setGetConfigInfoToXmlResult(java.lang.String getConfigInfoToXmlResult) {
        this.getConfigInfoToXmlResult = getConfigInfoToXmlResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConfigInfoToXmlResponse)) return false;
        GetConfigInfoToXmlResponse other = (GetConfigInfoToXmlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getConfigInfoToXmlResult==null && other.getGetConfigInfoToXmlResult()==null) || 
             (this.getConfigInfoToXmlResult!=null &&
              this.getConfigInfoToXmlResult.equals(other.getGetConfigInfoToXmlResult())));
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
        if (getGetConfigInfoToXmlResult() != null) {
            _hashCode += getGetConfigInfoToXmlResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConfigInfoToXmlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getConfigInfoToXmlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getConfigInfoToXmlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getConfigInfoToXmlResult"));
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
