/**
 * DoInsertTempChartNew1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DoInsertTempChartNew1Response  implements java.io.Serializable {
    private boolean doInsertTempChartNew1Result;

    private java.lang.String errorMsg;

    public DoInsertTempChartNew1Response() {
    }

    public DoInsertTempChartNew1Response(
           boolean doInsertTempChartNew1Result,
           java.lang.String errorMsg) {
           this.doInsertTempChartNew1Result = doInsertTempChartNew1Result;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the doInsertTempChartNew1Result value for this DoInsertTempChartNew1Response.
     * 
     * @return doInsertTempChartNew1Result
     */
    public boolean isDoInsertTempChartNew1Result() {
        return doInsertTempChartNew1Result;
    }


    /**
     * Sets the doInsertTempChartNew1Result value for this DoInsertTempChartNew1Response.
     * 
     * @param doInsertTempChartNew1Result
     */
    public void setDoInsertTempChartNew1Result(boolean doInsertTempChartNew1Result) {
        this.doInsertTempChartNew1Result = doInsertTempChartNew1Result;
    }


    /**
     * Gets the errorMsg value for this DoInsertTempChartNew1Response.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this DoInsertTempChartNew1Response.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoInsertTempChartNew1Response)) return false;
        DoInsertTempChartNew1Response other = (DoInsertTempChartNew1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.doInsertTempChartNew1Result == other.isDoInsertTempChartNew1Result() &&
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
        _hashCode += (isDoInsertTempChartNew1Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoInsertTempChartNew1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">doInsertTempChartNew1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doInsertTempChartNew1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "doInsertTempChartNew1Result"));
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
