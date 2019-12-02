/**
 * DownLoadPatientImgResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class DownLoadPatientImgResponse  implements java.io.Serializable {
    private byte[] downLoadPatientImgResult;

    public DownLoadPatientImgResponse() {
    }

    public DownLoadPatientImgResponse(
           byte[] downLoadPatientImgResult) {
           this.downLoadPatientImgResult = downLoadPatientImgResult;
    }


    /**
     * Gets the downLoadPatientImgResult value for this DownLoadPatientImgResponse.
     * 
     * @return downLoadPatientImgResult
     */
    public byte[] getDownLoadPatientImgResult() {
        return downLoadPatientImgResult;
    }


    /**
     * Sets the downLoadPatientImgResult value for this DownLoadPatientImgResponse.
     * 
     * @param downLoadPatientImgResult
     */
    public void setDownLoadPatientImgResult(byte[] downLoadPatientImgResult) {
        this.downLoadPatientImgResult = downLoadPatientImgResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DownLoadPatientImgResponse)) return false;
        DownLoadPatientImgResponse other = (DownLoadPatientImgResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.downLoadPatientImgResult==null && other.getDownLoadPatientImgResult()==null) || 
             (this.downLoadPatientImgResult!=null &&
              java.util.Arrays.equals(this.downLoadPatientImgResult, other.getDownLoadPatientImgResult())));
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
        if (getDownLoadPatientImgResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDownLoadPatientImgResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDownLoadPatientImgResult(), i);
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
        new org.apache.axis.description.TypeDesc(DownLoadPatientImgResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">DownLoadPatientImgResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("downLoadPatientImgResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DownLoadPatientImgResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
