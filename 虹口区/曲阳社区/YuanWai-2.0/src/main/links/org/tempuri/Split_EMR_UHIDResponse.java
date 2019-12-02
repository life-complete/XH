/**
 * Split_EMR_UHIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_EMR_UHIDResponse  implements java.io.Serializable {
    private int split_EMR_UHIDResult;

    private java.lang.String[] splitList;

    public Split_EMR_UHIDResponse() {
    }

    public Split_EMR_UHIDResponse(
           int split_EMR_UHIDResult,
           java.lang.String[] splitList) {
           this.split_EMR_UHIDResult = split_EMR_UHIDResult;
           this.splitList = splitList;
    }


    /**
     * Gets the split_EMR_UHIDResult value for this Split_EMR_UHIDResponse.
     * 
     * @return split_EMR_UHIDResult
     */
    public int getSplit_EMR_UHIDResult() {
        return split_EMR_UHIDResult;
    }


    /**
     * Sets the split_EMR_UHIDResult value for this Split_EMR_UHIDResponse.
     * 
     * @param split_EMR_UHIDResult
     */
    public void setSplit_EMR_UHIDResult(int split_EMR_UHIDResult) {
        this.split_EMR_UHIDResult = split_EMR_UHIDResult;
    }


    /**
     * Gets the splitList value for this Split_EMR_UHIDResponse.
     * 
     * @return splitList
     */
    public java.lang.String[] getSplitList() {
        return splitList;
    }


    /**
     * Sets the splitList value for this Split_EMR_UHIDResponse.
     * 
     * @param splitList
     */
    public void setSplitList(java.lang.String[] splitList) {
        this.splitList = splitList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_EMR_UHIDResponse)) return false;
        Split_EMR_UHIDResponse other = (Split_EMR_UHIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.split_EMR_UHIDResult == other.getSplit_EMR_UHIDResult() &&
            ((this.splitList==null && other.getSplitList()==null) || 
             (this.splitList!=null &&
              java.util.Arrays.equals(this.splitList, other.getSplitList())));
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
        _hashCode += getSplit_EMR_UHIDResult();
        if (getSplitList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSplitList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSplitList(), i);
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
        new org.apache.axis.description.TypeDesc(Split_EMR_UHIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_EMR_UHIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_EMR_UHIDResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Split_EMR_UHIDResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "splitList"));
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
