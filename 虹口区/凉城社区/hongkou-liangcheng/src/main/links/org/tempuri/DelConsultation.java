/**
 * DelConsultation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DelConsultation  implements java.io.Serializable {
    private java.lang.String HISis;

    private java.lang.String consultationID;

    public DelConsultation() {
    }

    public DelConsultation(
           java.lang.String HISis,
           java.lang.String consultationID) {
           this.HISis = HISis;
           this.consultationID = consultationID;
    }


    /**
     * Gets the HISis value for this DelConsultation.
     * 
     * @return HISis
     */
    public java.lang.String getHISis() {
        return HISis;
    }


    /**
     * Sets the HISis value for this DelConsultation.
     * 
     * @param HISis
     */
    public void setHISis(java.lang.String HISis) {
        this.HISis = HISis;
    }


    /**
     * Gets the consultationID value for this DelConsultation.
     * 
     * @return consultationID
     */
    public java.lang.String getConsultationID() {
        return consultationID;
    }


    /**
     * Sets the consultationID value for this DelConsultation.
     * 
     * @param consultationID
     */
    public void setConsultationID(java.lang.String consultationID) {
        this.consultationID = consultationID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DelConsultation)) return false;
        DelConsultation other = (DelConsultation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.HISis==null && other.getHISis()==null) || 
             (this.HISis!=null &&
              this.HISis.equals(other.getHISis()))) &&
            ((this.consultationID==null && other.getConsultationID()==null) || 
             (this.consultationID!=null &&
              this.consultationID.equals(other.getConsultationID())));
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
        if (getHISis() != null) {
            _hashCode += getHISis().hashCode();
        }
        if (getConsultationID() != null) {
            _hashCode += getConsultationID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DelConsultation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">DelConsultation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HISis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HISis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultationID"));
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
