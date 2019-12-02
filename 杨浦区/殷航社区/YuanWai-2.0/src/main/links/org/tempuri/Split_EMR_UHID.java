/**
 * Split_EMR_UHID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_EMR_UHID  implements java.io.Serializable {
    private java.lang.String UHID;

    private java.lang.String DATE_VALIDATED;

    private java.lang.String splitName;

    private java.lang.String[] splitList;

    public Split_EMR_UHID() {
    }

    public Split_EMR_UHID(
           java.lang.String UHID,
           java.lang.String DATE_VALIDATED,
           java.lang.String splitName,
           java.lang.String[] splitList) {
           this.UHID = UHID;
           this.DATE_VALIDATED = DATE_VALIDATED;
           this.splitName = splitName;
           this.splitList = splitList;
    }


    /**
     * Gets the UHID value for this Split_EMR_UHID.
     * 
     * @return UHID
     */
    public java.lang.String getUHID() {
        return UHID;
    }


    /**
     * Sets the UHID value for this Split_EMR_UHID.
     * 
     * @param UHID
     */
    public void setUHID(java.lang.String UHID) {
        this.UHID = UHID;
    }


    /**
     * Gets the DATE_VALIDATED value for this Split_EMR_UHID.
     * 
     * @return DATE_VALIDATED
     */
    public java.lang.String getDATE_VALIDATED() {
        return DATE_VALIDATED;
    }


    /**
     * Sets the DATE_VALIDATED value for this Split_EMR_UHID.
     * 
     * @param DATE_VALIDATED
     */
    public void setDATE_VALIDATED(java.lang.String DATE_VALIDATED) {
        this.DATE_VALIDATED = DATE_VALIDATED;
    }


    /**
     * Gets the splitName value for this Split_EMR_UHID.
     * 
     * @return splitName
     */
    public java.lang.String getSplitName() {
        return splitName;
    }


    /**
     * Sets the splitName value for this Split_EMR_UHID.
     * 
     * @param splitName
     */
    public void setSplitName(java.lang.String splitName) {
        this.splitName = splitName;
    }


    /**
     * Gets the splitList value for this Split_EMR_UHID.
     * 
     * @return splitList
     */
    public java.lang.String[] getSplitList() {
        return splitList;
    }


    /**
     * Sets the splitList value for this Split_EMR_UHID.
     * 
     * @param splitList
     */
    public void setSplitList(java.lang.String[] splitList) {
        this.splitList = splitList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_EMR_UHID)) return false;
        Split_EMR_UHID other = (Split_EMR_UHID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UHID==null && other.getUHID()==null) || 
             (this.UHID!=null &&
              this.UHID.equals(other.getUHID()))) &&
            ((this.DATE_VALIDATED==null && other.getDATE_VALIDATED()==null) || 
             (this.DATE_VALIDATED!=null &&
              this.DATE_VALIDATED.equals(other.getDATE_VALIDATED()))) &&
            ((this.splitName==null && other.getSplitName()==null) || 
             (this.splitName!=null &&
              this.splitName.equals(other.getSplitName()))) &&
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
        if (getUHID() != null) {
            _hashCode += getUHID().hashCode();
        }
        if (getDATE_VALIDATED() != null) {
            _hashCode += getDATE_VALIDATED().hashCode();
        }
        if (getSplitName() != null) {
            _hashCode += getSplitName().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(Split_EMR_UHID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_EMR_UHID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UHID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UHID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_VALIDATED");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DATE_VALIDATED"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "splitName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
