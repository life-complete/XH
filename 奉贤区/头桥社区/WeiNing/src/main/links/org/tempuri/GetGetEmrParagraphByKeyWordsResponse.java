/**
 * GetGetEmrParagraphByKeyWordsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetGetEmrParagraphByKeyWordsResponse  implements java.io.Serializable {
    private java.lang.String[][] getGetEmrParagraphByKeyWordsResult;

    public GetGetEmrParagraphByKeyWordsResponse() {
    }

    public GetGetEmrParagraphByKeyWordsResponse(
           java.lang.String[][] getGetEmrParagraphByKeyWordsResult) {
           this.getGetEmrParagraphByKeyWordsResult = getGetEmrParagraphByKeyWordsResult;
    }


    /**
     * Gets the getGetEmrParagraphByKeyWordsResult value for this GetGetEmrParagraphByKeyWordsResponse.
     * 
     * @return getGetEmrParagraphByKeyWordsResult
     */
    public java.lang.String[][] getGetGetEmrParagraphByKeyWordsResult() {
        return getGetEmrParagraphByKeyWordsResult;
    }


    /**
     * Sets the getGetEmrParagraphByKeyWordsResult value for this GetGetEmrParagraphByKeyWordsResponse.
     * 
     * @param getGetEmrParagraphByKeyWordsResult
     */
    public void setGetGetEmrParagraphByKeyWordsResult(java.lang.String[][] getGetEmrParagraphByKeyWordsResult) {
        this.getGetEmrParagraphByKeyWordsResult = getGetEmrParagraphByKeyWordsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGetEmrParagraphByKeyWordsResponse)) return false;
        GetGetEmrParagraphByKeyWordsResponse other = (GetGetEmrParagraphByKeyWordsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getGetEmrParagraphByKeyWordsResult==null && other.getGetGetEmrParagraphByKeyWordsResult()==null) || 
             (this.getGetEmrParagraphByKeyWordsResult!=null &&
              java.util.Arrays.equals(this.getGetEmrParagraphByKeyWordsResult, other.getGetGetEmrParagraphByKeyWordsResult())));
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
        if (getGetGetEmrParagraphByKeyWordsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetGetEmrParagraphByKeyWordsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetGetEmrParagraphByKeyWordsResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetGetEmrParagraphByKeyWordsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetGetEmrParagraphByKeyWordsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGetEmrParagraphByKeyWordsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetGetEmrParagraphByKeyWordsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
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
