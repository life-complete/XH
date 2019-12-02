/**
 * Split_EMR_HISIDS_HTML_XML.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_EMR_HISIDS_HTML_XML  implements java.io.Serializable {
    private java.lang.String HISIDS;

    private java.lang.String strHtml;

    private java.lang.String splitList;

    public Split_EMR_HISIDS_HTML_XML() {
    }

    public Split_EMR_HISIDS_HTML_XML(
           java.lang.String HISIDS,
           java.lang.String strHtml,
           java.lang.String splitList) {
           this.HISIDS = HISIDS;
           this.strHtml = strHtml;
           this.splitList = splitList;
    }


    /**
     * Gets the HISIDS value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @return HISIDS
     */
    public java.lang.String getHISIDS() {
        return HISIDS;
    }


    /**
     * Sets the HISIDS value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @param HISIDS
     */
    public void setHISIDS(java.lang.String HISIDS) {
        this.HISIDS = HISIDS;
    }


    /**
     * Gets the strHtml value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @return strHtml
     */
    public java.lang.String getStrHtml() {
        return strHtml;
    }


    /**
     * Sets the strHtml value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @param strHtml
     */
    public void setStrHtml(java.lang.String strHtml) {
        this.strHtml = strHtml;
    }


    /**
     * Gets the splitList value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @return splitList
     */
    public java.lang.String getSplitList() {
        return splitList;
    }


    /**
     * Sets the splitList value for this Split_EMR_HISIDS_HTML_XML.
     * 
     * @param splitList
     */
    public void setSplitList(java.lang.String splitList) {
        this.splitList = splitList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_EMR_HISIDS_HTML_XML)) return false;
        Split_EMR_HISIDS_HTML_XML other = (Split_EMR_HISIDS_HTML_XML) obj;
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
            ((this.strHtml==null && other.getStrHtml()==null) || 
             (this.strHtml!=null &&
              this.strHtml.equals(other.getStrHtml()))) &&
            ((this.splitList==null && other.getSplitList()==null) || 
             (this.splitList!=null &&
              this.splitList.equals(other.getSplitList())));
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
        if (getStrHtml() != null) {
            _hashCode += getStrHtml().hashCode();
        }
        if (getSplitList() != null) {
            _hashCode += getSplitList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Split_EMR_HISIDS_HTML_XML.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_EMR_HISIDS_HTML_XML"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HISIDS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HISIDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strHtml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "strHtml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "splitList"));
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
