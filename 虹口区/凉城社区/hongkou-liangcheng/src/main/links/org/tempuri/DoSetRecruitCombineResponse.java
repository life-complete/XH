/**
 * DoSetRecruitCombineResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DoSetRecruitCombineResponse  implements java.io.Serializable {
    private boolean doSetRecruitCombineResult;

    private java.lang.String errorMsg;

    public DoSetRecruitCombineResponse() {
    }

    public DoSetRecruitCombineResponse(
           boolean doSetRecruitCombineResult,
           java.lang.String errorMsg) {
           this.doSetRecruitCombineResult = doSetRecruitCombineResult;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the doSetRecruitCombineResult value for this DoSetRecruitCombineResponse.
     * 
     * @return doSetRecruitCombineResult
     */
    public boolean isDoSetRecruitCombineResult() {
        return doSetRecruitCombineResult;
    }


    /**
     * Sets the doSetRecruitCombineResult value for this DoSetRecruitCombineResponse.
     * 
     * @param doSetRecruitCombineResult
     */
    public void setDoSetRecruitCombineResult(boolean doSetRecruitCombineResult) {
        this.doSetRecruitCombineResult = doSetRecruitCombineResult;
    }


    /**
     * Gets the errorMsg value for this DoSetRecruitCombineResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this DoSetRecruitCombineResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoSetRecruitCombineResponse)) return false;
        DoSetRecruitCombineResponse other = (DoSetRecruitCombineResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.doSetRecruitCombineResult == other.isDoSetRecruitCombineResult() &&
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
        _hashCode += (isDoSetRecruitCombineResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoSetRecruitCombineResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">doSetRecruitCombineResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doSetRecruitCombineResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "doSetRecruitCombineResult"));
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
