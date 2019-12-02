/**
 * ReturnRecord_UHIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ReturnRecord_UHIDResponse  implements java.io.Serializable {
    private boolean returnRecord_UHIDResult;

    private java.lang.String msg;

    public ReturnRecord_UHIDResponse() {
    }

    public ReturnRecord_UHIDResponse(
           boolean returnRecord_UHIDResult,
           java.lang.String msg) {
           this.returnRecord_UHIDResult = returnRecord_UHIDResult;
           this.msg = msg;
    }


    /**
     * Gets the returnRecord_UHIDResult value for this ReturnRecord_UHIDResponse.
     * 
     * @return returnRecord_UHIDResult
     */
    public boolean isReturnRecord_UHIDResult() {
        return returnRecord_UHIDResult;
    }


    /**
     * Sets the returnRecord_UHIDResult value for this ReturnRecord_UHIDResponse.
     * 
     * @param returnRecord_UHIDResult
     */
    public void setReturnRecord_UHIDResult(boolean returnRecord_UHIDResult) {
        this.returnRecord_UHIDResult = returnRecord_UHIDResult;
    }


    /**
     * Gets the msg value for this ReturnRecord_UHIDResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this ReturnRecord_UHIDResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnRecord_UHIDResponse)) return false;
        ReturnRecord_UHIDResponse other = (ReturnRecord_UHIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.returnRecord_UHIDResult == other.isReturnRecord_UHIDResult() &&
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
        _hashCode += (isReturnRecord_UHIDResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReturnRecord_UHIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReturnRecord_UHIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnRecord_UHIDResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReturnRecord_UHIDResult"));
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
