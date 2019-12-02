/**
 * GetRecruitSepStrResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruitSepStrResponse  implements java.io.Serializable {
    private java.lang.String getRecruitSepStrResult;

    private java.lang.String errorMsg;

    public GetRecruitSepStrResponse() {
    }

    public GetRecruitSepStrResponse(
           java.lang.String getRecruitSepStrResult,
           java.lang.String errorMsg) {
           this.getRecruitSepStrResult = getRecruitSepStrResult;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getRecruitSepStrResult value for this GetRecruitSepStrResponse.
     * 
     * @return getRecruitSepStrResult
     */
    public java.lang.String getGetRecruitSepStrResult() {
        return getRecruitSepStrResult;
    }


    /**
     * Sets the getRecruitSepStrResult value for this GetRecruitSepStrResponse.
     * 
     * @param getRecruitSepStrResult
     */
    public void setGetRecruitSepStrResult(java.lang.String getRecruitSepStrResult) {
        this.getRecruitSepStrResult = getRecruitSepStrResult;
    }


    /**
     * Gets the errorMsg value for this GetRecruitSepStrResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetRecruitSepStrResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitSepStrResponse)) return false;
        GetRecruitSepStrResponse other = (GetRecruitSepStrResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getRecruitSepStrResult==null && other.getGetRecruitSepStrResult()==null) || 
             (this.getRecruitSepStrResult!=null &&
              this.getRecruitSepStrResult.equals(other.getGetRecruitSepStrResult()))) &&
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
        if (getGetRecruitSepStrResult() != null) {
            _hashCode += getGetRecruitSepStrResult().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitSepStrResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getRecruitSepStrResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getRecruitSepStrResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getRecruitSepStrResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
