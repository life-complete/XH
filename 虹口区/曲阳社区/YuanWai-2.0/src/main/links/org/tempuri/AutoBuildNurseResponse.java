/**
 * AutoBuildNurseResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AutoBuildNurseResponse  implements java.io.Serializable {
    private java.lang.String autoBuildNurseResult;

    public AutoBuildNurseResponse() {
    }

    public AutoBuildNurseResponse(
           java.lang.String autoBuildNurseResult) {
           this.autoBuildNurseResult = autoBuildNurseResult;
    }


    /**
     * Gets the autoBuildNurseResult value for this AutoBuildNurseResponse.
     * 
     * @return autoBuildNurseResult
     */
    public java.lang.String getAutoBuildNurseResult() {
        return autoBuildNurseResult;
    }


    /**
     * Sets the autoBuildNurseResult value for this AutoBuildNurseResponse.
     * 
     * @param autoBuildNurseResult
     */
    public void setAutoBuildNurseResult(java.lang.String autoBuildNurseResult) {
        this.autoBuildNurseResult = autoBuildNurseResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutoBuildNurseResponse)) return false;
        AutoBuildNurseResponse other = (AutoBuildNurseResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autoBuildNurseResult==null && other.getAutoBuildNurseResult()==null) || 
             (this.autoBuildNurseResult!=null &&
              this.autoBuildNurseResult.equals(other.getAutoBuildNurseResult())));
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
        if (getAutoBuildNurseResult() != null) {
            _hashCode += getAutoBuildNurseResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutoBuildNurseResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AutoBuildNurseResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoBuildNurseResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AutoBuildNurseResult"));
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
