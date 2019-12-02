/**
 * GetServerDateTimeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetServerDateTimeResponse  implements java.io.Serializable {
    private java.util.Calendar getServerDateTimeResult;

    public GetServerDateTimeResponse() {
    }

    public GetServerDateTimeResponse(
           java.util.Calendar getServerDateTimeResult) {
           this.getServerDateTimeResult = getServerDateTimeResult;
    }


    /**
     * Gets the getServerDateTimeResult value for this GetServerDateTimeResponse.
     * 
     * @return getServerDateTimeResult
     */
    public java.util.Calendar getGetServerDateTimeResult() {
        return getServerDateTimeResult;
    }


    /**
     * Sets the getServerDateTimeResult value for this GetServerDateTimeResponse.
     * 
     * @param getServerDateTimeResult
     */
    public void setGetServerDateTimeResult(java.util.Calendar getServerDateTimeResult) {
        this.getServerDateTimeResult = getServerDateTimeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetServerDateTimeResponse)) return false;
        GetServerDateTimeResponse other = (GetServerDateTimeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getServerDateTimeResult==null && other.getGetServerDateTimeResult()==null) || 
             (this.getServerDateTimeResult!=null &&
              this.getServerDateTimeResult.equals(other.getGetServerDateTimeResult())));
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
        if (getGetServerDateTimeResult() != null) {
            _hashCode += getGetServerDateTimeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetServerDateTimeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetServerDateTimeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getServerDateTimeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetServerDateTimeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
