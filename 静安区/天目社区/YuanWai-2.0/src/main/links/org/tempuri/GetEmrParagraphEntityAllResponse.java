/**
 * GetEmrParagraphEntityAllResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmrParagraphEntityAllResponse  implements java.io.Serializable {
    private java.lang.String getEmrParagraphEntityAllResult;

    public GetEmrParagraphEntityAllResponse() {
    }

    public GetEmrParagraphEntityAllResponse(
           java.lang.String getEmrParagraphEntityAllResult) {
           this.getEmrParagraphEntityAllResult = getEmrParagraphEntityAllResult;
    }


    /**
     * Gets the getEmrParagraphEntityAllResult value for this GetEmrParagraphEntityAllResponse.
     * 
     * @return getEmrParagraphEntityAllResult
     */
    public java.lang.String getGetEmrParagraphEntityAllResult() {
        return getEmrParagraphEntityAllResult;
    }


    /**
     * Sets the getEmrParagraphEntityAllResult value for this GetEmrParagraphEntityAllResponse.
     * 
     * @param getEmrParagraphEntityAllResult
     */
    public void setGetEmrParagraphEntityAllResult(java.lang.String getEmrParagraphEntityAllResult) {
        this.getEmrParagraphEntityAllResult = getEmrParagraphEntityAllResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmrParagraphEntityAllResponse)) return false;
        GetEmrParagraphEntityAllResponse other = (GetEmrParagraphEntityAllResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmrParagraphEntityAllResult==null && other.getGetEmrParagraphEntityAllResult()==null) || 
             (this.getEmrParagraphEntityAllResult!=null &&
              this.getEmrParagraphEntityAllResult.equals(other.getGetEmrParagraphEntityAllResult())));
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
        if (getGetEmrParagraphEntityAllResult() != null) {
            _hashCode += getGetEmrParagraphEntityAllResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmrParagraphEntityAllResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmrParagraphEntityAllResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmrParagraphEntityAllResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmrParagraphEntityAllResult"));
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
