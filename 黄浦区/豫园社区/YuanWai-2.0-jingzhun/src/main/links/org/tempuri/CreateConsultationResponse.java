/**
 * CreateConsultationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CreateConsultationResponse  implements java.io.Serializable {
    private java.lang.String createConsultationResult;

    public CreateConsultationResponse() {
    }

    public CreateConsultationResponse(
           java.lang.String createConsultationResult) {
           this.createConsultationResult = createConsultationResult;
    }


    /**
     * Gets the createConsultationResult value for this CreateConsultationResponse.
     * 
     * @return createConsultationResult
     */
    public java.lang.String getCreateConsultationResult() {
        return createConsultationResult;
    }


    /**
     * Sets the createConsultationResult value for this CreateConsultationResponse.
     * 
     * @param createConsultationResult
     */
    public void setCreateConsultationResult(java.lang.String createConsultationResult) {
        this.createConsultationResult = createConsultationResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateConsultationResponse)) return false;
        CreateConsultationResponse other = (CreateConsultationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createConsultationResult==null && other.getCreateConsultationResult()==null) || 
             (this.createConsultationResult!=null &&
              this.createConsultationResult.equals(other.getCreateConsultationResult())));
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
        if (getCreateConsultationResult() != null) {
            _hashCode += getCreateConsultationResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateConsultationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CreateConsultationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createConsultationResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CreateConsultationResult"));
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
