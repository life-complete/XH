/**
 * GetDataFromEMRResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetDataFromEMRResponse  implements java.io.Serializable {
    private int getDataFromEMRResult;

    private java.lang.String resultXML;

    public GetDataFromEMRResponse() {
    }

    public GetDataFromEMRResponse(
           int getDataFromEMRResult,
           java.lang.String resultXML) {
           this.getDataFromEMRResult = getDataFromEMRResult;
           this.resultXML = resultXML;
    }


    /**
     * Gets the getDataFromEMRResult value for this GetDataFromEMRResponse.
     * 
     * @return getDataFromEMRResult
     */
    public int getGetDataFromEMRResult() {
        return getDataFromEMRResult;
    }


    /**
     * Sets the getDataFromEMRResult value for this GetDataFromEMRResponse.
     * 
     * @param getDataFromEMRResult
     */
    public void setGetDataFromEMRResult(int getDataFromEMRResult) {
        this.getDataFromEMRResult = getDataFromEMRResult;
    }


    /**
     * Gets the resultXML value for this GetDataFromEMRResponse.
     * 
     * @return resultXML
     */
    public java.lang.String getResultXML() {
        return resultXML;
    }


    /**
     * Sets the resultXML value for this GetDataFromEMRResponse.
     * 
     * @param resultXML
     */
    public void setResultXML(java.lang.String resultXML) {
        this.resultXML = resultXML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDataFromEMRResponse)) return false;
        GetDataFromEMRResponse other = (GetDataFromEMRResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getDataFromEMRResult == other.getGetDataFromEMRResult() &&
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
        _hashCode += getGetDataFromEMRResult();
        if (getResultXML() != null) {
            _hashCode += getResultXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDataFromEMRResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDataFromEMRResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDataFromEMRResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetDataFromEMRResult"));
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
