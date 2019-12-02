/**
 * AutoBuildHospitalResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AutoBuildHospitalResponse  implements java.io.Serializable {
    private java.lang.String autoBuildHospitalResult;

    public AutoBuildHospitalResponse() {
    }

    public AutoBuildHospitalResponse(
           java.lang.String autoBuildHospitalResult) {
           this.autoBuildHospitalResult = autoBuildHospitalResult;
    }


    /**
     * Gets the autoBuildHospitalResult value for this AutoBuildHospitalResponse.
     * 
     * @return autoBuildHospitalResult
     */
    public java.lang.String getAutoBuildHospitalResult() {
        return autoBuildHospitalResult;
    }


    /**
     * Sets the autoBuildHospitalResult value for this AutoBuildHospitalResponse.
     * 
     * @param autoBuildHospitalResult
     */
    public void setAutoBuildHospitalResult(java.lang.String autoBuildHospitalResult) {
        this.autoBuildHospitalResult = autoBuildHospitalResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutoBuildHospitalResponse)) return false;
        AutoBuildHospitalResponse other = (AutoBuildHospitalResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autoBuildHospitalResult==null && other.getAutoBuildHospitalResult()==null) || 
             (this.autoBuildHospitalResult!=null &&
              this.autoBuildHospitalResult.equals(other.getAutoBuildHospitalResult())));
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
        if (getAutoBuildHospitalResult() != null) {
            _hashCode += getAutoBuildHospitalResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutoBuildHospitalResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AutoBuildHospitalResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoBuildHospitalResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AutoBuildHospitalResult"));
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
