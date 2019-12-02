/**
 * RenameFileOrFolderName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class RenameFileOrFolderName  implements java.io.Serializable {
    private java.lang.String UHID;

    private java.lang.String imgClsName;

    private java.lang.String imgName;

    private java.lang.String modifyName;

    public RenameFileOrFolderName() {
    }

    public RenameFileOrFolderName(
           java.lang.String UHID,
           java.lang.String imgClsName,
           java.lang.String imgName,
           java.lang.String modifyName) {
           this.UHID = UHID;
           this.imgClsName = imgClsName;
           this.imgName = imgName;
           this.modifyName = modifyName;
    }


    /**
     * Gets the UHID value for this RenameFileOrFolderName.
     * 
     * @return UHID
     */
    public java.lang.String getUHID() {
        return UHID;
    }


    /**
     * Sets the UHID value for this RenameFileOrFolderName.
     * 
     * @param UHID
     */
    public void setUHID(java.lang.String UHID) {
        this.UHID = UHID;
    }


    /**
     * Gets the imgClsName value for this RenameFileOrFolderName.
     * 
     * @return imgClsName
     */
    public java.lang.String getImgClsName() {
        return imgClsName;
    }


    /**
     * Sets the imgClsName value for this RenameFileOrFolderName.
     * 
     * @param imgClsName
     */
    public void setImgClsName(java.lang.String imgClsName) {
        this.imgClsName = imgClsName;
    }


    /**
     * Gets the imgName value for this RenameFileOrFolderName.
     * 
     * @return imgName
     */
    public java.lang.String getImgName() {
        return imgName;
    }


    /**
     * Sets the imgName value for this RenameFileOrFolderName.
     * 
     * @param imgName
     */
    public void setImgName(java.lang.String imgName) {
        this.imgName = imgName;
    }


    /**
     * Gets the modifyName value for this RenameFileOrFolderName.
     * 
     * @return modifyName
     */
    public java.lang.String getModifyName() {
        return modifyName;
    }


    /**
     * Sets the modifyName value for this RenameFileOrFolderName.
     * 
     * @param modifyName
     */
    public void setModifyName(java.lang.String modifyName) {
        this.modifyName = modifyName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenameFileOrFolderName)) return false;
        RenameFileOrFolderName other = (RenameFileOrFolderName) obj;
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
            ((this.modifyName==null && other.getModifyName()==null) || 
             (this.modifyName!=null &&
              this.modifyName.equals(other.getModifyName())));
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
        if (getModifyName() != null) {
            _hashCode += getModifyName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RenameFileOrFolderName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">RenameFileOrFolderName"));
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
        elemField.setFieldName("modifyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "modifyName"));
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
