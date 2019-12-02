/**
 * Split_Template_UHIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_Template_UHIDResponse  implements java.io.Serializable {
    private int split_Template_UHIDResult;

    private org.tempuri.Split_Template_UHIDResponseDt dt;

    public Split_Template_UHIDResponse() {
    }

    public Split_Template_UHIDResponse(
           int split_Template_UHIDResult,
           org.tempuri.Split_Template_UHIDResponseDt dt) {
           this.split_Template_UHIDResult = split_Template_UHIDResult;
           this.dt = dt;
    }


    /**
     * Gets the split_Template_UHIDResult value for this Split_Template_UHIDResponse.
     * 
     * @return split_Template_UHIDResult
     */
    public int getSplit_Template_UHIDResult() {
        return split_Template_UHIDResult;
    }


    /**
     * Sets the split_Template_UHIDResult value for this Split_Template_UHIDResponse.
     * 
     * @param split_Template_UHIDResult
     */
    public void setSplit_Template_UHIDResult(int split_Template_UHIDResult) {
        this.split_Template_UHIDResult = split_Template_UHIDResult;
    }


    /**
     * Gets the dt value for this Split_Template_UHIDResponse.
     * 
     * @return dt
     */
    public org.tempuri.Split_Template_UHIDResponseDt getDt() {
        return dt;
    }


    /**
     * Sets the dt value for this Split_Template_UHIDResponse.
     * 
     * @param dt
     */
    public void setDt(org.tempuri.Split_Template_UHIDResponseDt dt) {
        this.dt = dt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_Template_UHIDResponse)) return false;
        Split_Template_UHIDResponse other = (Split_Template_UHIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.split_Template_UHIDResult == other.getSplit_Template_UHIDResult() &&
            ((this.dt==null && other.getDt()==null) || 
             (this.dt!=null &&
              this.dt.equals(other.getDt())));
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
        _hashCode += getSplit_Template_UHIDResult();
        if (getDt() != null) {
            _hashCode += getDt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Split_Template_UHIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_Template_UHIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_Template_UHIDResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Split_Template_UHIDResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Split_Template_UHIDResponse>dt"));
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
