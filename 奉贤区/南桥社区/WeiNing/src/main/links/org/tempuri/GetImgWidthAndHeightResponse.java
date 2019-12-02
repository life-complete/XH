/**
 * GetImgWidthAndHeightResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetImgWidthAndHeightResponse  implements java.io.Serializable {
    private int getImgWidthAndHeightResult;

    private int imgHeight;

    public GetImgWidthAndHeightResponse() {
    }

    public GetImgWidthAndHeightResponse(
           int getImgWidthAndHeightResult,
           int imgHeight) {
           this.getImgWidthAndHeightResult = getImgWidthAndHeightResult;
           this.imgHeight = imgHeight;
    }


    /**
     * Gets the getImgWidthAndHeightResult value for this GetImgWidthAndHeightResponse.
     * 
     * @return getImgWidthAndHeightResult
     */
    public int getGetImgWidthAndHeightResult() {
        return getImgWidthAndHeightResult;
    }


    /**
     * Sets the getImgWidthAndHeightResult value for this GetImgWidthAndHeightResponse.
     * 
     * @param getImgWidthAndHeightResult
     */
    public void setGetImgWidthAndHeightResult(int getImgWidthAndHeightResult) {
        this.getImgWidthAndHeightResult = getImgWidthAndHeightResult;
    }


    /**
     * Gets the imgHeight value for this GetImgWidthAndHeightResponse.
     * 
     * @return imgHeight
     */
    public int getImgHeight() {
        return imgHeight;
    }


    /**
     * Sets the imgHeight value for this GetImgWidthAndHeightResponse.
     * 
     * @param imgHeight
     */
    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetImgWidthAndHeightResponse)) return false;
        GetImgWidthAndHeightResponse other = (GetImgWidthAndHeightResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getImgWidthAndHeightResult == other.getGetImgWidthAndHeightResult() &&
            this.imgHeight == other.getImgHeight();
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
        _hashCode += getGetImgWidthAndHeightResult();
        _hashCode += getImgHeight();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetImgWidthAndHeightResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetImgWidthAndHeightResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getImgWidthAndHeightResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetImgWidthAndHeightResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgHeight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "imgHeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
