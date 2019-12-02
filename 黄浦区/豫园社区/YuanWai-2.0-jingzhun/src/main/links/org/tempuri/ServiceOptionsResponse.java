/**
 * ServiceOptionsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ServiceOptionsResponse  implements java.io.Serializable {
    private org.tempuri.ServiceOptionsResponseServiceOptionsResult serviceOptionsResult;

    public ServiceOptionsResponse() {
    }

    public ServiceOptionsResponse(
           org.tempuri.ServiceOptionsResponseServiceOptionsResult serviceOptionsResult) {
           this.serviceOptionsResult = serviceOptionsResult;
    }


    /**
     * Gets the serviceOptionsResult value for this ServiceOptionsResponse.
     * 
     * @return serviceOptionsResult
     */
    public org.tempuri.ServiceOptionsResponseServiceOptionsResult getServiceOptionsResult() {
        return serviceOptionsResult;
    }


    /**
     * Sets the serviceOptionsResult value for this ServiceOptionsResponse.
     * 
     * @param serviceOptionsResult
     */
    public void setServiceOptionsResult(org.tempuri.ServiceOptionsResponseServiceOptionsResult serviceOptionsResult) {
        this.serviceOptionsResult = serviceOptionsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceOptionsResponse)) return false;
        ServiceOptionsResponse other = (ServiceOptionsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serviceOptionsResult==null && other.getServiceOptionsResult()==null) || 
             (this.serviceOptionsResult!=null &&
              this.serviceOptionsResult.equals(other.getServiceOptionsResult())));
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
        if (getServiceOptionsResult() != null) {
            _hashCode += getServiceOptionsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceOptionsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ServiceOptionsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceOptionsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ServiceOptionsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ServiceOptionsResponse>ServiceOptionsResult"));
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
