/**
 * GetInfoNewChartResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetInfoNewChartResponse  implements java.io.Serializable {
    private boolean getInfoNewChartResult;

    private java.lang.String xmlStr;

    private java.lang.String errorMsg;

    public GetInfoNewChartResponse() {
    }

    public GetInfoNewChartResponse(
           boolean getInfoNewChartResult,
           java.lang.String xmlStr,
           java.lang.String errorMsg) {
           this.getInfoNewChartResult = getInfoNewChartResult;
           this.xmlStr = xmlStr;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getInfoNewChartResult value for this GetInfoNewChartResponse.
     * 
     * @return getInfoNewChartResult
     */
    public boolean isGetInfoNewChartResult() {
        return getInfoNewChartResult;
    }


    /**
     * Sets the getInfoNewChartResult value for this GetInfoNewChartResponse.
     * 
     * @param getInfoNewChartResult
     */
    public void setGetInfoNewChartResult(boolean getInfoNewChartResult) {
        this.getInfoNewChartResult = getInfoNewChartResult;
    }


    /**
     * Gets the xmlStr value for this GetInfoNewChartResponse.
     * 
     * @return xmlStr
     */
    public java.lang.String getXmlStr() {
        return xmlStr;
    }


    /**
     * Sets the xmlStr value for this GetInfoNewChartResponse.
     * 
     * @param xmlStr
     */
    public void setXmlStr(java.lang.String xmlStr) {
        this.xmlStr = xmlStr;
    }


    /**
     * Gets the errorMsg value for this GetInfoNewChartResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetInfoNewChartResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetInfoNewChartResponse)) return false;
        GetInfoNewChartResponse other = (GetInfoNewChartResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getInfoNewChartResult == other.isGetInfoNewChartResult() &&
            ((this.xmlStr==null && other.getXmlStr()==null) || 
             (this.xmlStr!=null &&
              this.xmlStr.equals(other.getXmlStr()))) &&
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
        _hashCode += (isGetInfoNewChartResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getXmlStr() != null) {
            _hashCode += getXmlStr().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInfoNewChartResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetInfoNewChartResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getInfoNewChartResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetInfoNewChartResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "xmlStr"));
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
