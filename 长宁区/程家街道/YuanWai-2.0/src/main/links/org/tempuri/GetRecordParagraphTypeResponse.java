/**
 * GetRecordParagraphTypeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecordParagraphTypeResponse  implements java.io.Serializable {
    private java.lang.String getRecordParagraphTypeResult;

    public GetRecordParagraphTypeResponse() {
    }

    public GetRecordParagraphTypeResponse(
           java.lang.String getRecordParagraphTypeResult) {
           this.getRecordParagraphTypeResult = getRecordParagraphTypeResult;
    }


    /**
     * Gets the getRecordParagraphTypeResult value for this GetRecordParagraphTypeResponse.
     * 
     * @return getRecordParagraphTypeResult
     */
    public java.lang.String getGetRecordParagraphTypeResult() {
        return getRecordParagraphTypeResult;
    }


    /**
     * Sets the getRecordParagraphTypeResult value for this GetRecordParagraphTypeResponse.
     * 
     * @param getRecordParagraphTypeResult
     */
    public void setGetRecordParagraphTypeResult(java.lang.String getRecordParagraphTypeResult) {
        this.getRecordParagraphTypeResult = getRecordParagraphTypeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecordParagraphTypeResponse)) return false;
        GetRecordParagraphTypeResponse other = (GetRecordParagraphTypeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getRecordParagraphTypeResult==null && other.getGetRecordParagraphTypeResult()==null) || 
             (this.getRecordParagraphTypeResult!=null &&
              this.getRecordParagraphTypeResult.equals(other.getGetRecordParagraphTypeResult())));
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
        if (getGetRecordParagraphTypeResult() != null) {
            _hashCode += getGetRecordParagraphTypeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecordParagraphTypeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecordParagraphTypeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getRecordParagraphTypeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetRecordParagraphTypeResult"));
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
