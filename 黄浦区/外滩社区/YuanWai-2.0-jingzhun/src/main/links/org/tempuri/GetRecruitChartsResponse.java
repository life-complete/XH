/**
 * GetRecruitChartsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruitChartsResponse  implements java.io.Serializable {
    private int getRecruitChartsResult;

    private java.lang.String resultXml;

    public GetRecruitChartsResponse() {
    }

    public GetRecruitChartsResponse(
           int getRecruitChartsResult,
           java.lang.String resultXml) {
           this.getRecruitChartsResult = getRecruitChartsResult;
           this.resultXml = resultXml;
    }


    /**
     * Gets the getRecruitChartsResult value for this GetRecruitChartsResponse.
     * 
     * @return getRecruitChartsResult
     */
    public int getGetRecruitChartsResult() {
        return getRecruitChartsResult;
    }


    /**
     * Sets the getRecruitChartsResult value for this GetRecruitChartsResponse.
     * 
     * @param getRecruitChartsResult
     */
    public void setGetRecruitChartsResult(int getRecruitChartsResult) {
        this.getRecruitChartsResult = getRecruitChartsResult;
    }


    /**
     * Gets the resultXml value for this GetRecruitChartsResponse.
     * 
     * @return resultXml
     */
    public java.lang.String getResultXml() {
        return resultXml;
    }


    /**
     * Sets the resultXml value for this GetRecruitChartsResponse.
     * 
     * @param resultXml
     */
    public void setResultXml(java.lang.String resultXml) {
        this.resultXml = resultXml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitChartsResponse)) return false;
        GetRecruitChartsResponse other = (GetRecruitChartsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getRecruitChartsResult == other.getGetRecruitChartsResult() &&
            ((this.resultXml==null && other.getResultXml()==null) || 
             (this.resultXml!=null &&
              this.resultXml.equals(other.getResultXml())));
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
        _hashCode += getGetRecruitChartsResult();
        if (getResultXml() != null) {
            _hashCode += getResultXml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitChartsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruitChartsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getRecruitChartsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetRecruitChartsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ResultXml"));
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
