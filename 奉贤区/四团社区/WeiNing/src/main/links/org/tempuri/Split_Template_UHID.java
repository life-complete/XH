/**
 * Split_Template_UHID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Split_Template_UHID  implements java.io.Serializable {
    private java.lang.String UHID;

    private java.lang.String DATE_VALIDATED;

    private org.tempuri.Split_Template_UHIDDt dt;

    public Split_Template_UHID() {
    }

    public Split_Template_UHID(
           java.lang.String UHID,
           java.lang.String DATE_VALIDATED,
           org.tempuri.Split_Template_UHIDDt dt) {
           this.UHID = UHID;
           this.DATE_VALIDATED = DATE_VALIDATED;
           this.dt = dt;
    }


    /**
     * Gets the UHID value for this Split_Template_UHID.
     * 
     * @return UHID
     */
    public java.lang.String getUHID() {
        return UHID;
    }


    /**
     * Sets the UHID value for this Split_Template_UHID.
     * 
     * @param UHID
     */
    public void setUHID(java.lang.String UHID) {
        this.UHID = UHID;
    }


    /**
     * Gets the DATE_VALIDATED value for this Split_Template_UHID.
     * 
     * @return DATE_VALIDATED
     */
    public java.lang.String getDATE_VALIDATED() {
        return DATE_VALIDATED;
    }


    /**
     * Sets the DATE_VALIDATED value for this Split_Template_UHID.
     * 
     * @param DATE_VALIDATED
     */
    public void setDATE_VALIDATED(java.lang.String DATE_VALIDATED) {
        this.DATE_VALIDATED = DATE_VALIDATED;
    }


    /**
     * Gets the dt value for this Split_Template_UHID.
     * 
     * @return dt
     */
    public org.tempuri.Split_Template_UHIDDt getDt() {
        return dt;
    }


    /**
     * Sets the dt value for this Split_Template_UHID.
     * 
     * @param dt
     */
    public void setDt(org.tempuri.Split_Template_UHIDDt dt) {
        this.dt = dt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Split_Template_UHID)) return false;
        Split_Template_UHID other = (Split_Template_UHID) obj;
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
        if (getUHID() != null) {
            _hashCode += getUHID().hashCode();
        }
        if (getDATE_VALIDATED() != null) {
            _hashCode += getDATE_VALIDATED().hashCode();
        }
        if (getDt() != null) {
            _hashCode += getDt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Split_Template_UHID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Split_Template_UHID"));
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
        elemField.setFieldName("dt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Split_Template_UHID>dt"));
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
