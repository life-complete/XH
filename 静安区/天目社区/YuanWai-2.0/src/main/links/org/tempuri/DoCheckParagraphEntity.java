/**
 * DoCheckParagraphEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DoCheckParagraphEntity  implements java.io.Serializable {
    private java.lang.String hisId;

    private java.lang.String templateName;

    private int SNum;

    public DoCheckParagraphEntity() {
    }

    public DoCheckParagraphEntity(
           java.lang.String hisId,
           java.lang.String templateName,
           int SNum) {
           this.hisId = hisId;
           this.templateName = templateName;
           this.SNum = SNum;
    }


    /**
     * Gets the hisId value for this DoCheckParagraphEntity.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this DoCheckParagraphEntity.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the templateName value for this DoCheckParagraphEntity.
     * 
     * @return templateName
     */
    public java.lang.String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this DoCheckParagraphEntity.
     * 
     * @param templateName
     */
    public void setTemplateName(java.lang.String templateName) {
        this.templateName = templateName;
    }


    /**
     * Gets the SNum value for this DoCheckParagraphEntity.
     * 
     * @return SNum
     */
    public int getSNum() {
        return SNum;
    }


    /**
     * Sets the SNum value for this DoCheckParagraphEntity.
     * 
     * @param SNum
     */
    public void setSNum(int SNum) {
        this.SNum = SNum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoCheckParagraphEntity)) return false;
        DoCheckParagraphEntity other = (DoCheckParagraphEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hisId==null && other.getHisId()==null) || 
             (this.hisId!=null &&
              this.hisId.equals(other.getHisId()))) &&
            ((this.templateName==null && other.getTemplateName()==null) || 
             (this.templateName!=null &&
              this.templateName.equals(other.getTemplateName()))) &&
            this.SNum == other.getSNum();
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
        if (getHisId() != null) {
            _hashCode += getHisId().hashCode();
        }
        if (getTemplateName() != null) {
            _hashCode += getTemplateName().hashCode();
        }
        _hashCode += getSNum();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoCheckParagraphEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">doCheckParagraphEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HisId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TemplateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
