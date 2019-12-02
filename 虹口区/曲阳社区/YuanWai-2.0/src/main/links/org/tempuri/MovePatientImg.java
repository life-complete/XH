/**
 * MovePatientImg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class MovePatientImg  implements java.io.Serializable {
    private java.lang.String UHID;

    private java.lang.String imgClsName;

    private java.lang.String imgName;

    private java.lang.String destImgClsName;

    public MovePatientImg() {
    }

    public MovePatientImg(
           java.lang.String UHID,
           java.lang.String imgClsName,
           java.lang.String imgName,
           java.lang.String destImgClsName) {
           this.UHID = UHID;
           this.imgClsName = imgClsName;
           this.imgName = imgName;
           this.destImgClsName = destImgClsName;
    }


    /**
     * Gets the UHID value for this MovePatientImg.
     * 
     * @return UHID
     */
    public java.lang.String getUHID() {
        return UHID;
    }


    /**
     * Sets the UHID value for this MovePatientImg.
     * 
     * @param UHID
     */
    public void setUHID(java.lang.String UHID) {
        this.UHID = UHID;
    }


    /**
     * Gets the imgClsName value for this MovePatientImg.
     * 
     * @return imgClsName
     */
    public java.lang.String getImgClsName() {
        return imgClsName;
    }


    /**
     * Sets the imgClsName value for this MovePatientImg.
     * 
     * @param imgClsName
     */
    public void setImgClsName(java.lang.String imgClsName) {
        this.imgClsName = imgClsName;
    }


    /**
     * Gets the imgName value for this MovePatientImg.
     * 
     * @return imgName
     */
    public java.lang.String getImgName() {
        return imgName;
    }


    /**
     * Sets the imgName value for this MovePatientImg.
     * 
     * @param imgName
     */
    public void setImgName(java.lang.String imgName) {
        this.imgName = imgName;
    }


    /**
     * Gets the destImgClsName value for this MovePatientImg.
     * 
     * @return destImgClsName
     */
    public java.lang.String getDestImgClsName() {
        return destImgClsName;
    }


    /**
     * Sets the destImgClsName value for this MovePatientImg.
     * 
     * @param destImgClsName
     */
    public void setDestImgClsName(java.lang.String destImgClsName) {
        this.destImgClsName = destImgClsName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MovePatientImg)) return false;
        MovePatientImg other = (MovePatientImg) obj;
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
            ((this.imgClsName==null && other.getImgClsName()==null) || 
             (this.imgClsName!=null &&
              this.imgClsName.equals(other.getImgClsName()))) &&
            ((this.imgName==null && other.getImgName()==null) || 
             (this.imgName!=null &&
              this.imgName.equals(other.getImgName()))) &&
            ((this.destImgClsName==null && other.getDestImgClsName()==null) || 
             (this.destImgClsName!=null &&
              this.destImgClsName.equals(other.getDestImgClsName())));
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
        if (getImgClsName() != null) {
            _hashCode += getImgClsName().hashCode();
        }
        if (getImgName() != null) {
            _hashCode += getImgName().hashCode();
        }
        if (getDestImgClsName() != null) {
            _hashCode += getDestImgClsName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MovePatientImg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">MovePatientImg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UHID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UHID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgClsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "imgClsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "imgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destImgClsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "destImgClsName"));
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
