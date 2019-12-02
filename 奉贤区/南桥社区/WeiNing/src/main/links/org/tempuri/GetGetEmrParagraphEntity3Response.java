/**
 * GetGetEmrParagraphEntity3Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetGetEmrParagraphEntity3Response  implements java.io.Serializable {
    private java.lang.String[] getGetEmrParagraphEntity3Result;

    public GetGetEmrParagraphEntity3Response() {
    }

    public GetGetEmrParagraphEntity3Response(
           java.lang.String[] getGetEmrParagraphEntity3Result) {
           this.getGetEmrParagraphEntity3Result = getGetEmrParagraphEntity3Result;
    }


    /**
     * Gets the getGetEmrParagraphEntity3Result value for this GetGetEmrParagraphEntity3Response.
     * 
     * @return getGetEmrParagraphEntity3Result
     */
    public java.lang.String[] getGetGetEmrParagraphEntity3Result() {
        return getGetEmrParagraphEntity3Result;
    }


    /**
     * Sets the getGetEmrParagraphEntity3Result value for this GetGetEmrParagraphEntity3Response.
     * 
     * @param getGetEmrParagraphEntity3Result
     */
    public void setGetGetEmrParagraphEntity3Result(java.lang.String[] getGetEmrParagraphEntity3Result) {
        this.getGetEmrParagraphEntity3Result = getGetEmrParagraphEntity3Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGetEmrParagraphEntity3Response)) return false;
        GetGetEmrParagraphEntity3Response other = (GetGetEmrParagraphEntity3Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getGetEmrParagraphEntity3Result==null && other.getGetGetEmrParagraphEntity3Result()==null) || 
             (this.getGetEmrParagraphEntity3Result!=null &&
              java.util.Arrays.equals(this.getGetEmrParagraphEntity3Result, other.getGetGetEmrParagraphEntity3Result())));
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
        if (getGetGetEmrParagraphEntity3Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetGetEmrParagraphEntity3Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetGetEmrParagraphEntity3Result(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGetEmrParagraphEntity3Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetGetEmrParagraphEntity3Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGetEmrParagraphEntity3Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetGetEmrParagraphEntity3Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
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
