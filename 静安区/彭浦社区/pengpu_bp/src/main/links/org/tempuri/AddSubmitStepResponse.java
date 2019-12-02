/**
 * AddSubmitStepResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AddSubmitStepResponse  implements java.io.Serializable {
    private java.lang.String addSubmitStepResult;

    public AddSubmitStepResponse() {
    }

    public AddSubmitStepResponse(
           java.lang.String addSubmitStepResult) {
           this.addSubmitStepResult = addSubmitStepResult;
    }


    /**
     * Gets the addSubmitStepResult value for this AddSubmitStepResponse.
     * 
     * @return addSubmitStepResult
     */
    public java.lang.String getAddSubmitStepResult() {
        return addSubmitStepResult;
    }


    /**
     * Sets the addSubmitStepResult value for this AddSubmitStepResponse.
     * 
     * @param addSubmitStepResult
     */
    public void setAddSubmitStepResult(java.lang.String addSubmitStepResult) {
        this.addSubmitStepResult = addSubmitStepResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddSubmitStepResponse)) return false;
        AddSubmitStepResponse other = (AddSubmitStepResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addSubmitStepResult==null && other.getAddSubmitStepResult()==null) || 
             (this.addSubmitStepResult!=null &&
              this.addSubmitStepResult.equals(other.getAddSubmitStepResult())));
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
        if (getAddSubmitStepResult() != null) {
            _hashCode += getAddSubmitStepResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddSubmitStepResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AddSubmitStepResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addSubmitStepResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AddSubmitStepResult"));
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
