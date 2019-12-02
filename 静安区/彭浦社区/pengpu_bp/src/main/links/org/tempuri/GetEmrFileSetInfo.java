/**
 * GetEmrFileSetInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmrFileSetInfo  implements java.io.Serializable {
    private java.lang.String uhid;

    private java.lang.String dateValidated;

    private java.lang.String errorMsg;

    private java.lang.String[] primaryTypes;

    public GetEmrFileSetInfo() {
    }

    public GetEmrFileSetInfo(
           java.lang.String uhid,
           java.lang.String dateValidated,
           java.lang.String errorMsg,
           java.lang.String[] primaryTypes) {
           this.uhid = uhid;
           this.dateValidated = dateValidated;
           this.errorMsg = errorMsg;
           this.primaryTypes = primaryTypes;
    }


    /**
     * Gets the uhid value for this GetEmrFileSetInfo.
     * 
     * @return uhid
     */
    public java.lang.String getUhid() {
        return uhid;
    }


    /**
     * Sets the uhid value for this GetEmrFileSetInfo.
     * 
     * @param uhid
     */
    public void setUhid(java.lang.String uhid) {
        this.uhid = uhid;
    }


    /**
     * Gets the dateValidated value for this GetEmrFileSetInfo.
     * 
     * @return dateValidated
     */
    public java.lang.String getDateValidated() {
        return dateValidated;
    }


    /**
     * Sets the dateValidated value for this GetEmrFileSetInfo.
     * 
     * @param dateValidated
     */
    public void setDateValidated(java.lang.String dateValidated) {
        this.dateValidated = dateValidated;
    }


    /**
     * Gets the errorMsg value for this GetEmrFileSetInfo.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetEmrFileSetInfo.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * Gets the primaryTypes value for this GetEmrFileSetInfo.
     * 
     * @return primaryTypes
     */
    public java.lang.String[] getPrimaryTypes() {
        return primaryTypes;
    }


    /**
     * Sets the primaryTypes value for this GetEmrFileSetInfo.
     * 
     * @param primaryTypes
     */
    public void setPrimaryTypes(java.lang.String[] primaryTypes) {
        this.primaryTypes = primaryTypes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmrFileSetInfo)) return false;
        GetEmrFileSetInfo other = (GetEmrFileSetInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uhid==null && other.getUhid()==null) || 
             (this.uhid!=null &&
              this.uhid.equals(other.getUhid()))) &&
            ((this.dateValidated==null && other.getDateValidated()==null) || 
             (this.dateValidated!=null &&
              this.dateValidated.equals(other.getDateValidated()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg()))) &&
            ((this.primaryTypes==null && other.getPrimaryTypes()==null) || 
             (this.primaryTypes!=null &&
              java.util.Arrays.equals(this.primaryTypes, other.getPrimaryTypes())));
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
        if (getUhid() != null) {
            _hashCode += getUhid().hashCode();
        }
        if (getDateValidated() != null) {
            _hashCode += getDateValidated().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        if (getPrimaryTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrimaryTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrimaryTypes(), i);
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
        new org.apache.axis.description.TypeDesc(GetEmrFileSetInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmrFileSetInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uhid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "uhid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateValidated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dateValidated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "errorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "primaryTypes"));
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
