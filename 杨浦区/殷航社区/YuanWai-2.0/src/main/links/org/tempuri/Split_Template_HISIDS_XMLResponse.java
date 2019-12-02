/**
 * Split_Template_HISIDS_XMLResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_Template_HISIDS_XMLResponse  implements java.io.Serializable {
    private int split_Template_HISIDS_XMLResult;

    private java.lang.String resultXML;

    public Split_Template_HISIDS_XMLResponse() {
    }

    public Split_Template_HISIDS_XMLResponse(
           int split_Template_HISIDS_XMLResult,
           java.lang.String resultXML) {
           this.split_Template_HISIDS_XMLResult = split_Template_HISIDS_XMLResult;
           this.resultXML = resultXML;
    }


    /**
     * Gets the split_Template_HISIDS_XMLResult value for this Split_Template_HISIDS_XMLResponse.
     * 
     * @return split_Template_HISIDS_XMLResult
     */
    public int getSplit_Template_HISIDS_XMLResult() {
        return split_Template_HISIDS_XMLResult;
    }


    /**
     * Sets the split_Template_HISIDS_XMLResult value for this Split_Template_HISIDS_XMLResponse.
     * 
     * @param split_Template_HISIDS_XMLResult
     */
    public void setSplit_Template_HISIDS_XMLResult(int split_Template_HISIDS_XMLResult) {
        this.split_Template_HISIDS_XMLResult = split_Template_HISIDS_XMLResult;
    }


    /**
     * Gets the resultXML value for this Split_Template_HISIDS_XMLResponse.
     * 
     * @return resultXML
     */
    public java.lang.String getResultXML() {
        return resultXML;
    }


    /**
     * Sets the resultXML value for this Split_Template_HISIDS_XMLResponse.
     * 
     * @param resultXML
     */
    public void setResultXML(java.lang.String resultXML) {
        this.resultXML = resultXML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_Template_HISIDS_XMLResponse)) return false;
        Split_Template_HISIDS_XMLResponse other = (Split_Template_HISIDS_XMLResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.split_Template_HISIDS_XMLResult == other.getSplit_Template_HISIDS_XMLResult() &&
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
        _hashCode += getSplit_Template_HISIDS_XMLResult();
        if (getResultXML() != null) {
            _hashCode += getResultXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Split_Template_HISIDS_XMLResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_Template_HISIDS_XMLResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_Template_HISIDS_XMLResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Split_Template_HISIDS_XMLResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
