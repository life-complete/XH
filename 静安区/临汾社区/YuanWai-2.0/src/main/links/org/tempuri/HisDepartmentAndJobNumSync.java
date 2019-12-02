/**
 * HisDepartmentAndJobNumSync.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class HisDepartmentAndJobNumSync  implements java.io.Serializable {
    private java.lang.String detailXml;

    private java.lang.String otherText;

    public HisDepartmentAndJobNumSync() {
    }

    public HisDepartmentAndJobNumSync(
           java.lang.String detailXml,
           java.lang.String otherText) {
           this.detailXml = detailXml;
           this.otherText = otherText;
    }


    /**
     * Gets the detailXml value for this HisDepartmentAndJobNumSync.
     * 
     * @return detailXml
     */
    public java.lang.String getDetailXml() {
        return detailXml;
    }


    /**
     * Sets the detailXml value for this HisDepartmentAndJobNumSync.
     * 
     * @param detailXml
     */
    public void setDetailXml(java.lang.String detailXml) {
        this.detailXml = detailXml;
    }


    /**
     * Gets the otherText value for this HisDepartmentAndJobNumSync.
     * 
     * @return otherText
     */
    public java.lang.String getOtherText() {
        return otherText;
    }


    /**
     * Sets the otherText value for this HisDepartmentAndJobNumSync.
     * 
     * @param otherText
     */
    public void setOtherText(java.lang.String otherText) {
        this.otherText = otherText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HisDepartmentAndJobNumSync)) return false;
        HisDepartmentAndJobNumSync other = (HisDepartmentAndJobNumSync) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.detailXml==null && other.getDetailXml()==null) || 
             (this.detailXml!=null &&
              this.detailXml.equals(other.getDetailXml()))) &&
            ((this.otherText==null && other.getOtherText()==null) || 
             (this.otherText!=null &&
              this.otherText.equals(other.getOtherText())));
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
        if (getDetailXml() != null) {
            _hashCode += getDetailXml().hashCode();
        }
        if (getOtherText() != null) {
            _hashCode += getOtherText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HisDepartmentAndJobNumSync.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">HisDepartmentAndJobNumSync"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detailXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "detailXml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "otherText"));
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
