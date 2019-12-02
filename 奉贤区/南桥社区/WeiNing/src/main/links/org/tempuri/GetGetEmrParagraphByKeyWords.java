/**
 * GetGetEmrParagraphByKeyWords.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetGetEmrParagraphByKeyWords  implements java.io.Serializable {
    private java.lang.String hisId;

    private java.lang.String keyWords;

    public GetGetEmrParagraphByKeyWords() {
    }

    public GetGetEmrParagraphByKeyWords(
           java.lang.String hisId,
           java.lang.String keyWords) {
           this.hisId = hisId;
           this.keyWords = keyWords;
    }


    /**
     * Gets the hisId value for this GetGetEmrParagraphByKeyWords.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this GetGetEmrParagraphByKeyWords.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the keyWords value for this GetGetEmrParagraphByKeyWords.
     * 
     * @return keyWords
     */
    public java.lang.String getKeyWords() {
        return keyWords;
    }


    /**
     * Sets the keyWords value for this GetGetEmrParagraphByKeyWords.
     * 
     * @param keyWords
     */
    public void setKeyWords(java.lang.String keyWords) {
        this.keyWords = keyWords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGetEmrParagraphByKeyWords)) return false;
        GetGetEmrParagraphByKeyWords other = (GetGetEmrParagraphByKeyWords) obj;
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
            ((this.keyWords==null && other.getKeyWords()==null) || 
             (this.keyWords!=null &&
              this.keyWords.equals(other.getKeyWords())));
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
        if (getKeyWords() != null) {
            _hashCode += getKeyWords().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGetEmrParagraphByKeyWords.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetGetEmrParagraphByKeyWords"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HisId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyWords");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "KeyWords"));
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
