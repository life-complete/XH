/**
 * GetConfigInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetConfigInfoResponse  implements java.io.Serializable {
    private org.tempuri.GetConfigInfoResponseGetConfigInfoResult getConfigInfoResult;

    public GetConfigInfoResponse() {
    }

    public GetConfigInfoResponse(
           org.tempuri.GetConfigInfoResponseGetConfigInfoResult getConfigInfoResult) {
           this.getConfigInfoResult = getConfigInfoResult;
    }


    /**
     * Gets the getConfigInfoResult value for this GetConfigInfoResponse.
     * 
     * @return getConfigInfoResult
     */
    public org.tempuri.GetConfigInfoResponseGetConfigInfoResult getGetConfigInfoResult() {
        return getConfigInfoResult;
    }


    /**
     * Sets the getConfigInfoResult value for this GetConfigInfoResponse.
     * 
     * @param getConfigInfoResult
     */
    public void setGetConfigInfoResult(org.tempuri.GetConfigInfoResponseGetConfigInfoResult getConfigInfoResult) {
        this.getConfigInfoResult = getConfigInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConfigInfoResponse)) return false;
        GetConfigInfoResponse other = (GetConfigInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getConfigInfoResult==null && other.getGetConfigInfoResult()==null) || 
             (this.getConfigInfoResult!=null &&
              this.getConfigInfoResult.equals(other.getGetConfigInfoResult())));
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
        if (getGetConfigInfoResult() != null) {
            _hashCode += getGetConfigInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConfigInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getConfigInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getConfigInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getConfigInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>getConfigInfoResponse>getConfigInfoResult"));
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
