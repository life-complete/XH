/**
 * Split_Template_HISIDS_XML.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_Template_HISIDS_XML  implements java.io.Serializable {
    private java.lang.String HISIDS;

    private java.lang.String resultXML;

    public Split_Template_HISIDS_XML() {
    }

    public Split_Template_HISIDS_XML(
           java.lang.String HISIDS,
           java.lang.String resultXML) {
           this.HISIDS = HISIDS;
           this.resultXML = resultXML;
    }


    /**
     * Gets the HISIDS value for this Split_Template_HISIDS_XML.
     * 
     * @return HISIDS
     */
    public java.lang.String getHISIDS() {
        return HISIDS;
    }


    /**
     * Sets the HISIDS value for this Split_Template_HISIDS_XML.
     * 
     * @param HISIDS
     */
    public void setHISIDS(java.lang.String HISIDS) {
        this.HISIDS = HISIDS;
    }


    /**
     * Gets the resultXML value for this Split_Template_HISIDS_XML.
     * 
     * @return resultXML
     */
    public java.lang.String getResultXML() {
        return resultXML;
    }


    /**
     * Sets the resultXML value for this Split_Template_HISIDS_XML.
     * 
     * @param resultXML
     */
    public void setResultXML(java.lang.String resultXML) {
        this.resultXML = resultXML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_Template_HISIDS_XML)) return false;
        Split_Template_HISIDS_XML other = (Split_Template_HISIDS_XML) obj;
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
            ((this.resultXML==null && other.getResultXML()==null) || 
             (this.resultXML!=null &&
              this.resultXML.equals(other.getResultXML())));
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
        if (getResultXML() != null) {
            _hashCode += getResultXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Split_Template_HISIDS_XML.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_Template_HISIDS_XML"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HISIDS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HISIDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultXML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "resultXML"));
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
