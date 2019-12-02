/**
 * GetRecruit3BasicInfoExResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruit3BasicInfoExResponse  implements java.io.Serializable {
    private boolean getRecruit3BasicInfoExResult;

    private java.lang.String returnXml;

    private java.lang.String errorMsg;

    public GetRecruit3BasicInfoExResponse() {
    }

    public GetRecruit3BasicInfoExResponse(
           boolean getRecruit3BasicInfoExResult,
           java.lang.String returnXml,
           java.lang.String errorMsg) {
           this.getRecruit3BasicInfoExResult = getRecruit3BasicInfoExResult;
           this.returnXml = returnXml;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the getRecruit3BasicInfoExResult value for this GetRecruit3BasicInfoExResponse.
     * 
     * @return getRecruit3BasicInfoExResult
     */
    public boolean isGetRecruit3BasicInfoExResult() {
        return getRecruit3BasicInfoExResult;
    }


    /**
     * Sets the getRecruit3BasicInfoExResult value for this GetRecruit3BasicInfoExResponse.
     * 
     * @param getRecruit3BasicInfoExResult
     */
    public void setGetRecruit3BasicInfoExResult(boolean getRecruit3BasicInfoExResult) {
        this.getRecruit3BasicInfoExResult = getRecruit3BasicInfoExResult;
    }


    /**
     * Gets the returnXml value for this GetRecruit3BasicInfoExResponse.
     * 
     * @return returnXml
     */
    public java.lang.String getReturnXml() {
        return returnXml;
    }


    /**
     * Sets the returnXml value for this GetRecruit3BasicInfoExResponse.
     * 
     * @param returnXml
     */
    public void setReturnXml(java.lang.String returnXml) {
        this.returnXml = returnXml;
    }


    /**
     * Gets the errorMsg value for this GetRecruit3BasicInfoExResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetRecruit3BasicInfoExResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruit3BasicInfoExResponse)) return false;
        GetRecruit3BasicInfoExResponse other = (GetRecruit3BasicInfoExResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getRecruit3BasicInfoExResult == other.isGetRecruit3BasicInfoExResult() &&
            ((this.returnXml==null && other.getReturnXml()==null) || 
             (this.returnXml!=null &&
              this.returnXml.equals(other.getReturnXml()))) &&
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
        _hashCode += (isGetRecruit3BasicInfoExResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReturnXml() != null) {
            _hashCode += getReturnXml().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruit3BasicInfoExResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruit3BasicInfoExResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getRecruit3BasicInfoExResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetRecruit3BasicInfoExResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReturnXml"));
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
