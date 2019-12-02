/**
 * DoInsertTempChartNewResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DoInsertTempChartNewResponse  implements java.io.Serializable {
    private boolean doInsertTempChartNewResult;

    private java.lang.String errorMsg;

    public DoInsertTempChartNewResponse() {
    }

    public DoInsertTempChartNewResponse(
           boolean doInsertTempChartNewResult,
           java.lang.String errorMsg) {
           this.doInsertTempChartNewResult = doInsertTempChartNewResult;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the doInsertTempChartNewResult value for this DoInsertTempChartNewResponse.
     * 
     * @return doInsertTempChartNewResult
     */
    public boolean isDoInsertTempChartNewResult() {
        return doInsertTempChartNewResult;
    }


    /**
     * Sets the doInsertTempChartNewResult value for this DoInsertTempChartNewResponse.
     * 
     * @param doInsertTempChartNewResult
     */
    public void setDoInsertTempChartNewResult(boolean doInsertTempChartNewResult) {
        this.doInsertTempChartNewResult = doInsertTempChartNewResult;
    }


    /**
     * Gets the errorMsg value for this DoInsertTempChartNewResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this DoInsertTempChartNewResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoInsertTempChartNewResponse)) return false;
        DoInsertTempChartNewResponse other = (DoInsertTempChartNewResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.doInsertTempChartNewResult == other.isDoInsertTempChartNewResult() &&
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
        _hashCode += (isDoInsertTempChartNewResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoInsertTempChartNewResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">doInsertTempChartNewResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doInsertTempChartNewResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "doInsertTempChartNewResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
