/**
 * GetMISCELLANEOUSInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetMISCELLANEOUSInfoResponse  implements java.io.Serializable {
    private boolean getMISCELLANEOUSInfoResult;

    private java.lang.String HTML;

    private java.lang.String errorMsg;

    public GetMISCELLANEOUSInfoResponse() {
    }

    public GetMISCELLANEOUSInfoResponse(
           boolean getMISCELLANEOUSInfoResult,
           java.lang.String HTML,
           java.lang.String errorMsg) {
           this.getMISCELLANEOUSInfoResult = getMISCELLANEOUSInfoResult;
           this.HTML = HTML;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getMISCELLANEOUSInfoResult value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @return getMISCELLANEOUSInfoResult
     */
    public boolean isGetMISCELLANEOUSInfoResult() {
        return getMISCELLANEOUSInfoResult;
    }


    /**
     * Sets the getMISCELLANEOUSInfoResult value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @param getMISCELLANEOUSInfoResult
     */
    public void setGetMISCELLANEOUSInfoResult(boolean getMISCELLANEOUSInfoResult) {
        this.getMISCELLANEOUSInfoResult = getMISCELLANEOUSInfoResult;
    }


    /**
     * Gets the HTML value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @return HTML
     */
    public java.lang.String getHTML() {
        return HTML;
    }


    /**
     * Sets the HTML value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @param HTML
     */
    public void setHTML(java.lang.String HTML) {
        this.HTML = HTML;
    }


    /**
     * Gets the errorMsg value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetMISCELLANEOUSInfoResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMISCELLANEOUSInfoResponse)) return false;
        GetMISCELLANEOUSInfoResponse other = (GetMISCELLANEOUSInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getMISCELLANEOUSInfoResult == other.isGetMISCELLANEOUSInfoResult() &&
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
        _hashCode += (isGetMISCELLANEOUSInfoResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        new org.apache.axis.description.TypeDesc(GetMISCELLANEOUSInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetMISCELLANEOUSInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMISCELLANEOUSInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetMISCELLANEOUSInfoResult"));
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
