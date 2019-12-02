/**
 * GetRecruitCharts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruitCharts  implements java.io.Serializable {
    private java.lang.String[] hisid;

    private java.lang.String resultXml;

    public GetRecruitCharts() {
    }

    public GetRecruitCharts(
           java.lang.String[] hisid,
           java.lang.String resultXml) {
           this.hisid = hisid;
           this.resultXml = resultXml;
    }


    /**
     * Gets the hisid value for this GetRecruitCharts.
     * 
     * @return hisid
     */
    public java.lang.String[] getHisid() {
        return hisid;
    }


    /**
     * Sets the hisid value for this GetRecruitCharts.
     * 
     * @param hisid
     */
    public void setHisid(java.lang.String[] hisid) {
        this.hisid = hisid;
    }


    /**
     * Gets the resultXml value for this GetRecruitCharts.
     * 
     * @return resultXml
     */
    public java.lang.String getResultXml() {
        return resultXml;
    }


    /**
     * Sets the resultXml value for this GetRecruitCharts.
     * 
     * @param resultXml
     */
    public void setResultXml(java.lang.String resultXml) {
        this.resultXml = resultXml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitCharts)) return false;
        GetRecruitCharts other = (GetRecruitCharts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hisid==null && other.getHisid()==null) || 
             (this.hisid!=null &&
              java.util.Arrays.equals(this.hisid, other.getHisid()))) &&
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
        if (getHisid() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHisid());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHisid(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultXml() != null) {
            _hashCode += getResultXml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitCharts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruitCharts"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Hisid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
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
