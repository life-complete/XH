/**
 * ReturnRecord_HisIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ReturnRecord_HisIdResponse  implements java.io.Serializable {
    private boolean returnRecord_HisIdResult;

    private java.lang.String msg;

    public ReturnRecord_HisIdResponse() {
    }

    public ReturnRecord_HisIdResponse(
           boolean returnRecord_HisIdResult,
           java.lang.String msg) {
           this.returnRecord_HisIdResult = returnRecord_HisIdResult;
           this.msg = msg;
    }


    /**
     * Gets the returnRecord_HisIdResult value for this ReturnRecord_HisIdResponse.
     * 
     * @return returnRecord_HisIdResult
     */
    public boolean isReturnRecord_HisIdResult() {
        return returnRecord_HisIdResult;
    }


    /**
     * Sets the returnRecord_HisIdResult value for this ReturnRecord_HisIdResponse.
     * 
     * @param returnRecord_HisIdResult
     */
    public void setReturnRecord_HisIdResult(boolean returnRecord_HisIdResult) {
        this.returnRecord_HisIdResult = returnRecord_HisIdResult;
    }


    /**
     * Gets the msg value for this ReturnRecord_HisIdResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this ReturnRecord_HisIdResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnRecord_HisIdResponse)) return false;
        ReturnRecord_HisIdResponse other = (ReturnRecord_HisIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.returnRecord_HisIdResult == other.isReturnRecord_HisIdResult() &&
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
        _hashCode += (isReturnRecord_HisIdResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReturnRecord_HisIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReturnRecord_HisIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnRecord_HisIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReturnRecord_HisIdResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
