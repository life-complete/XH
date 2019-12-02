/**
 * SplitEmrReturnXmlForJava.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SplitEmrReturnXmlForJava  implements java.io.Serializable {
    private java.lang.String HISIDS;

    private java.lang.String docType;

    public SplitEmrReturnXmlForJava() {
    }

    public SplitEmrReturnXmlForJava(
           java.lang.String HISIDS,
           java.lang.String docType) {
           this.HISIDS = HISIDS;
           this.docType = docType;
    }


    /**
     * Gets the HISIDS value for this SplitEmrReturnXmlForJava.
     * 
     * @return HISIDS
     */
    public java.lang.String getHISIDS() {
        return HISIDS;
    }


    /**
     * Sets the HISIDS value for this SplitEmrReturnXmlForJava.
     * 
     * @param HISIDS
     */
    public void setHISIDS(java.lang.String HISIDS) {
        this.HISIDS = HISIDS;
    }


    /**
     * Gets the docType value for this SplitEmrReturnXmlForJava.
     * 
     * @return docType
     */
    public java.lang.String getDocType() {
        return docType;
    }


    /**
     * Sets the docType value for this SplitEmrReturnXmlForJava.
     * 
     * @param docType
     */
    public void setDocType(java.lang.String docType) {
        this.docType = docType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlForJava)) return false;
        SplitEmrReturnXmlForJava other = (SplitEmrReturnXmlForJava) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.HISIDS==null && other.getHISIDS()==null) || 
             (this.HISIDS!=null &&
              this.HISIDS.equals(other.getHISIDS()))) &&
            ((this.docType==null && other.getDocType()==null) || 
             (this.docType!=null &&
              this.docType.equals(other.getDocType())));
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
        if (getHISIDS() != null) {
            _hashCode += getHISIDS().hashCode();
        }
        if (getDocType() != null) {
            _hashCode += getDocType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlForJava.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlForJava"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HISIDS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HISIDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DocType"));
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
