/**
 * Split_EMR_HISIDS_HTML_XMLResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_EMR_HISIDS_HTML_XMLResponse  implements java.io.Serializable {
    private int split_EMR_HISIDS_HTML_XMLResult;

    private java.lang.String strHtml;

    private java.lang.String splitList;

    public Split_EMR_HISIDS_HTML_XMLResponse() {
    }

    public Split_EMR_HISIDS_HTML_XMLResponse(
           int split_EMR_HISIDS_HTML_XMLResult,
           java.lang.String strHtml,
           java.lang.String splitList) {
           this.split_EMR_HISIDS_HTML_XMLResult = split_EMR_HISIDS_HTML_XMLResult;
           this.strHtml = strHtml;
           this.splitList = splitList;
    }


    /**
     * Gets the split_EMR_HISIDS_HTML_XMLResult value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @return split_EMR_HISIDS_HTML_XMLResult
     */
    public int getSplit_EMR_HISIDS_HTML_XMLResult() {
        return split_EMR_HISIDS_HTML_XMLResult;
    }


    /**
     * Sets the split_EMR_HISIDS_HTML_XMLResult value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @param split_EMR_HISIDS_HTML_XMLResult
     */
    public void setSplit_EMR_HISIDS_HTML_XMLResult(int split_EMR_HISIDS_HTML_XMLResult) {
        this.split_EMR_HISIDS_HTML_XMLResult = split_EMR_HISIDS_HTML_XMLResult;
    }


    /**
     * Gets the strHtml value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @return strHtml
     */
    public java.lang.String getStrHtml() {
        return strHtml;
    }


    /**
     * Sets the strHtml value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @param strHtml
     */
    public void setStrHtml(java.lang.String strHtml) {
        this.strHtml = strHtml;
    }


    /**
     * Gets the splitList value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @return splitList
     */
    public java.lang.String getSplitList() {
        return splitList;
    }


    /**
     * Sets the splitList value for this Split_EMR_HISIDS_HTML_XMLResponse.
     * 
     * @param splitList
     */
    public void setSplitList(java.lang.String splitList) {
        this.splitList = splitList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_EMR_HISIDS_HTML_XMLResponse)) return false;
        Split_EMR_HISIDS_HTML_XMLResponse other = (Split_EMR_HISIDS_HTML_XMLResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.split_EMR_HISIDS_HTML_XMLResult == other.getSplit_EMR_HISIDS_HTML_XMLResult() &&
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
        _hashCode += getSplit_EMR_HISIDS_HTML_XMLResult();
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
        new org.apache.axis.description.TypeDesc(Split_EMR_HISIDS_HTML_XMLResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_EMR_HISIDS_HTML_XMLResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_EMR_HISIDS_HTML_XMLResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Split_EMR_HISIDS_HTML_XMLResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
