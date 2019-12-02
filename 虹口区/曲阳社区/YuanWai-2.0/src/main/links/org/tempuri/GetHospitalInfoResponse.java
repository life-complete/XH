/**
 * GetHospitalInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetHospitalInfoResponse  implements java.io.Serializable {
    private boolean getHospitalInfoResult;

    private java.lang.String HTML;

    private java.lang.String errorMsg;

    public GetHospitalInfoResponse() {
    }

    public GetHospitalInfoResponse(
           boolean getHospitalInfoResult,
           java.lang.String HTML,
           java.lang.String errorMsg) {
           this.getHospitalInfoResult = getHospitalInfoResult;
           this.HTML = HTML;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getHospitalInfoResult value for this GetHospitalInfoResponse.
     * 
     * @return getHospitalInfoResult
     */
    public boolean isGetHospitalInfoResult() {
        return getHospitalInfoResult;
    }


    /**
     * Sets the getHospitalInfoResult value for this GetHospitalInfoResponse.
     * 
     * @param getHospitalInfoResult
     */
    public void setGetHospitalInfoResult(boolean getHospitalInfoResult) {
        this.getHospitalInfoResult = getHospitalInfoResult;
    }


    /**
     * Gets the HTML value for this GetHospitalInfoResponse.
     * 
     * @return HTML
     */
    public java.lang.String getHTML() {
        return HTML;
    }


    /**
     * Sets the HTML value for this GetHospitalInfoResponse.
     * 
     * @param HTML
     */
    public void setHTML(java.lang.String HTML) {
        this.HTML = HTML;
    }


    /**
     * Gets the errorMsg value for this GetHospitalInfoResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetHospitalInfoResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHospitalInfoResponse)) return false;
        GetHospitalInfoResponse other = (GetHospitalInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getHospitalInfoResult == other.isGetHospitalInfoResult() &&
            ((this.HTML==null && other.getHTML()==null) || 
             (this.HTML!=null &&
              this.HTML.equals(other.getHTML()))) &&
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
        _hashCode += (isGetHospitalInfoResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHTML() != null) {
            _hashCode += getHTML().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetHospitalInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getHospitalInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getHospitalInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getHospitalInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HTML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HTML"));
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
