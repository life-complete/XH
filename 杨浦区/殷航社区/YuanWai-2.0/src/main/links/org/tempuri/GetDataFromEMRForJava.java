/**
 * GetDataFromEMRForJava.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetDataFromEMRForJava  implements java.io.Serializable {
    private java.lang.String selType;

    private java.lang.String selColumns;

    private java.lang.String keyWords;

    public GetDataFromEMRForJava() {
    }

    public GetDataFromEMRForJava(
           java.lang.String selType,
           java.lang.String selColumns,
           java.lang.String keyWords) {
           this.selType = selType;
           this.selColumns = selColumns;
           this.keyWords = keyWords;
    }


    /**
     * Gets the selType value for this GetDataFromEMRForJava.
     * 
     * @return selType
     */
    public java.lang.String getSelType() {
        return selType;
    }


    /**
     * Sets the selType value for this GetDataFromEMRForJava.
     * 
     * @param selType
     */
    public void setSelType(java.lang.String selType) {
        this.selType = selType;
    }


    /**
     * Gets the selColumns value for this GetDataFromEMRForJava.
     * 
     * @return selColumns
     */
    public java.lang.String getSelColumns() {
        return selColumns;
    }


    /**
     * Sets the selColumns value for this GetDataFromEMRForJava.
     * 
     * @param selColumns
     */
    public void setSelColumns(java.lang.String selColumns) {
        this.selColumns = selColumns;
    }


    /**
     * Gets the keyWords value for this GetDataFromEMRForJava.
     * 
     * @return keyWords
     */
    public java.lang.String getKeyWords() {
        return keyWords;
    }


    /**
     * Sets the keyWords value for this GetDataFromEMRForJava.
     * 
     * @param keyWords
     */
    public void setKeyWords(java.lang.String keyWords) {
        this.keyWords = keyWords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDataFromEMRForJava)) return false;
        GetDataFromEMRForJava other = (GetDataFromEMRForJava) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.selType==null && other.getSelType()==null) || 
             (this.selType!=null &&
              this.selType.equals(other.getSelType()))) &&
            ((this.selColumns==null && other.getSelColumns()==null) || 
             (this.selColumns!=null &&
              this.selColumns.equals(other.getSelColumns()))) &&
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
        if (getSelType() != null) {
            _hashCode += getSelType().hashCode();
        }
        if (getSelColumns() != null) {
            _hashCode += getSelColumns().hashCode();
        }
        if (getKeyWords() != null) {
            _hashCode += getKeyWords().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDataFromEMRForJava.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDataFromEMRForJava"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "selType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selColumns");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "selColumns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyWords");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "keyWords"));
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
