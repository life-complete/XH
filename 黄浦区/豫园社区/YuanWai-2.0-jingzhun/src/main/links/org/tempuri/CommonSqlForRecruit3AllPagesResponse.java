/**
 * CommonSqlForRecruit3AllPagesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CommonSqlForRecruit3AllPagesResponse  implements java.io.Serializable {
    private int commonSqlForRecruit3AllPagesResult;

    private org.tempuri.CommonSqlForRecruit3AllPagesResponseDsResult dsResult;

    private java.lang.String msg;

    public CommonSqlForRecruit3AllPagesResponse() {
    }

    public CommonSqlForRecruit3AllPagesResponse(
           int commonSqlForRecruit3AllPagesResult,
           org.tempuri.CommonSqlForRecruit3AllPagesResponseDsResult dsResult,
           java.lang.String msg) {
           this.commonSqlForRecruit3AllPagesResult = commonSqlForRecruit3AllPagesResult;
           this.dsResult = dsResult;
           this.msg = msg;
    }


    /**
     * Gets the commonSqlForRecruit3AllPagesResult value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @return commonSqlForRecruit3AllPagesResult
     */
    public int getCommonSqlForRecruit3AllPagesResult() {
        return commonSqlForRecruit3AllPagesResult;
    }


    /**
     * Sets the commonSqlForRecruit3AllPagesResult value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @param commonSqlForRecruit3AllPagesResult
     */
    public void setCommonSqlForRecruit3AllPagesResult(int commonSqlForRecruit3AllPagesResult) {
        this.commonSqlForRecruit3AllPagesResult = commonSqlForRecruit3AllPagesResult;
    }


    /**
     * Gets the dsResult value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @return dsResult
     */
    public org.tempuri.CommonSqlForRecruit3AllPagesResponseDsResult getDsResult() {
        return dsResult;
    }


    /**
     * Sets the dsResult value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @param dsResult
     */
    public void setDsResult(org.tempuri.CommonSqlForRecruit3AllPagesResponseDsResult dsResult) {
        this.dsResult = dsResult;
    }


    /**
     * Gets the msg value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this CommonSqlForRecruit3AllPagesResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonSqlForRecruit3AllPagesResponse)) return false;
        CommonSqlForRecruit3AllPagesResponse other = (CommonSqlForRecruit3AllPagesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.commonSqlForRecruit3AllPagesResult == other.getCommonSqlForRecruit3AllPagesResult() &&
            ((this.dsResult==null && other.getDsResult()==null) || 
             (this.dsResult!=null &&
              this.dsResult.equals(other.getDsResult()))) &&
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
        _hashCode += getCommonSqlForRecruit3AllPagesResult();
        if (getDsResult() != null) {
            _hashCode += getDsResult().hashCode();
        }
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonSqlForRecruit3AllPagesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CommonSqlForRecruit3AllPagesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commonSqlForRecruit3AllPagesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CommonSqlForRecruit3AllPagesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>CommonSqlForRecruit3AllPagesResponse>DsResult"));
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
