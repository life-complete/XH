/**
 * GetEmrFileSetInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmrFileSetInfoResponse  implements java.io.Serializable {
    private java.lang.String[] getEmrFileSetInfoResult;

    private java.lang.String errorMsg;

    public GetEmrFileSetInfoResponse() {
    }

    public GetEmrFileSetInfoResponse(
           java.lang.String[] getEmrFileSetInfoResult,
           java.lang.String errorMsg) {
           this.getEmrFileSetInfoResult = getEmrFileSetInfoResult;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getEmrFileSetInfoResult value for this GetEmrFileSetInfoResponse.
     * 
     * @return getEmrFileSetInfoResult
     */
    public java.lang.String[] getGetEmrFileSetInfoResult() {
        return getEmrFileSetInfoResult;
    }


    /**
     * Sets the getEmrFileSetInfoResult value for this GetEmrFileSetInfoResponse.
     * 
     * @param getEmrFileSetInfoResult
     */
    public void setGetEmrFileSetInfoResult(java.lang.String[] getEmrFileSetInfoResult) {
        this.getEmrFileSetInfoResult = getEmrFileSetInfoResult;
    }


    /**
     * Gets the errorMsg value for this GetEmrFileSetInfoResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetEmrFileSetInfoResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmrFileSetInfoResponse)) return false;
        GetEmrFileSetInfoResponse other = (GetEmrFileSetInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmrFileSetInfoResult==null && other.getGetEmrFileSetInfoResult()==null) || 
             (this.getEmrFileSetInfoResult!=null &&
              java.util.Arrays.equals(this.getEmrFileSetInfoResult, other.getGetEmrFileSetInfoResult()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg())));
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
        if (getGetEmrFileSetInfoResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetEmrFileSetInfoResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetEmrFileSetInfoResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmrFileSetInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmrFileSetInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmrFileSetInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmrFileSetInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "errorMsg"));
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
