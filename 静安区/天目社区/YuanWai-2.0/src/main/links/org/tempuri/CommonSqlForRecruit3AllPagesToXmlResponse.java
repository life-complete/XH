/**
 * CommonSqlForRecruit3AllPagesToXmlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CommonSqlForRecruit3AllPagesToXmlResponse  implements java.io.Serializable {
    private int commonSqlForRecruit3AllPagesToXmlResult;

    private java.lang.String xmlResult;

    private java.lang.String msg;

    public CommonSqlForRecruit3AllPagesToXmlResponse() {
    }

    public CommonSqlForRecruit3AllPagesToXmlResponse(
           int commonSqlForRecruit3AllPagesToXmlResult,
           java.lang.String xmlResult,
           java.lang.String msg) {
           this.commonSqlForRecruit3AllPagesToXmlResult = commonSqlForRecruit3AllPagesToXmlResult;
           this.xmlResult = xmlResult;
           this.msg = msg;
    }


    /**
     * Gets the commonSqlForRecruit3AllPagesToXmlResult value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @return commonSqlForRecruit3AllPagesToXmlResult
     */
    public int getCommonSqlForRecruit3AllPagesToXmlResult() {
        return commonSqlForRecruit3AllPagesToXmlResult;
    }


    /**
     * Sets the commonSqlForRecruit3AllPagesToXmlResult value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @param commonSqlForRecruit3AllPagesToXmlResult
     */
    public void setCommonSqlForRecruit3AllPagesToXmlResult(int commonSqlForRecruit3AllPagesToXmlResult) {
        this.commonSqlForRecruit3AllPagesToXmlResult = commonSqlForRecruit3AllPagesToXmlResult;
    }


    /**
     * Gets the xmlResult value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @return xmlResult
     */
    public java.lang.String getXmlResult() {
        return xmlResult;
    }


    /**
     * Sets the xmlResult value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @param xmlResult
     */
    public void setXmlResult(java.lang.String xmlResult) {
        this.xmlResult = xmlResult;
    }


    /**
     * Gets the msg value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this CommonSqlForRecruit3AllPagesToXmlResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonSqlForRecruit3AllPagesToXmlResponse)) return false;
        CommonSqlForRecruit3AllPagesToXmlResponse other = (CommonSqlForRecruit3AllPagesToXmlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.commonSqlForRecruit3AllPagesToXmlResult == other.getCommonSqlForRecruit3AllPagesToXmlResult() &&
            ((this.xmlResult==null && other.getXmlResult()==null) || 
             (this.xmlResult!=null &&
              this.xmlResult.equals(other.getXmlResult()))) &&
            ((this.msg==null && other.getMsg()==null) || 
             (this.msg!=null &&
              this.msg.equals(other.getMsg())));
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
        _hashCode += getCommonSqlForRecruit3AllPagesToXmlResult();
        if (getXmlResult() != null) {
            _hashCode += getXmlResult().hashCode();
        }
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonSqlForRecruit3AllPagesToXmlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CommonSqlForRecruit3AllPagesToXmlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commonSqlForRecruit3AllPagesToXmlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CommonSqlForRecruit3AllPagesToXmlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "XmlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "msg"));
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
