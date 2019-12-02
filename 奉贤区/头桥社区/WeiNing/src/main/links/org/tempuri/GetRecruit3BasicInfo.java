/**
 * GetRecruit3BasicInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruit3BasicInfo  implements java.io.Serializable {
    private java.lang.String hisId;

    private java.lang.String formName;

    private java.lang.String returnXml;

    private java.lang.String dateUpdate;

    private java.lang.String uhid;

    private java.lang.String errorMsg;

    public GetRecruit3BasicInfo() {
    }

    public GetRecruit3BasicInfo(
           java.lang.String hisId,
           java.lang.String formName,
           java.lang.String returnXml,
           java.lang.String dateUpdate,
           java.lang.String uhid,
           java.lang.String errorMsg) {
           this.hisId = hisId;
           this.formName = formName;
           this.returnXml = returnXml;
           this.dateUpdate = dateUpdate;
           this.uhid = uhid;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the hisId value for this GetRecruit3BasicInfo.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this GetRecruit3BasicInfo.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the formName value for this GetRecruit3BasicInfo.
     * 
     * @return formName
     */
    public java.lang.String getFormName() {
        return formName;
    }


    /**
     * Sets the formName value for this GetRecruit3BasicInfo.
     * 
     * @param formName
     */
    public void setFormName(java.lang.String formName) {
        this.formName = formName;
    }


    /**
     * Gets the returnXml value for this GetRecruit3BasicInfo.
     * 
     * @return returnXml
     */
    public java.lang.String getReturnXml() {
        return returnXml;
    }


    /**
     * Sets the returnXml value for this GetRecruit3BasicInfo.
     * 
     * @param returnXml
     */
    public void setReturnXml(java.lang.String returnXml) {
        this.returnXml = returnXml;
    }


    /**
     * Gets the dateUpdate value for this GetRecruit3BasicInfo.
     * 
     * @return dateUpdate
     */
    public java.lang.String getDateUpdate() {
        return dateUpdate;
    }


    /**
     * Sets the dateUpdate value for this GetRecruit3BasicInfo.
     * 
     * @param dateUpdate
     */
    public void setDateUpdate(java.lang.String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    /**
     * Gets the uhid value for this GetRecruit3BasicInfo.
     * 
     * @return uhid
     */
    public java.lang.String getUhid() {
        return uhid;
    }


    /**
     * Sets the uhid value for this GetRecruit3BasicInfo.
     * 
     * @param uhid
     */
    public void setUhid(java.lang.String uhid) {
        this.uhid = uhid;
    }


    /**
     * Gets the errorMsg value for this GetRecruit3BasicInfo.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetRecruit3BasicInfo.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruit3BasicInfo)) return false;
        GetRecruit3BasicInfo other = (GetRecruit3BasicInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hisId==null && other.getHisId()==null) || 
             (this.hisId!=null &&
              this.hisId.equals(other.getHisId()))) &&
            ((this.formName==null && other.getFormName()==null) || 
             (this.formName!=null &&
              this.formName.equals(other.getFormName()))) &&
            ((this.returnXml==null && other.getReturnXml()==null) || 
             (this.returnXml!=null &&
              this.returnXml.equals(other.getReturnXml()))) &&
            ((this.dateUpdate==null && other.getDateUpdate()==null) || 
             (this.dateUpdate!=null &&
              this.dateUpdate.equals(other.getDateUpdate()))) &&
            ((this.uhid==null && other.getUhid()==null) || 
             (this.uhid!=null &&
              this.uhid.equals(other.getUhid()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg())));
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
        if (getHisId() != null) {
            _hashCode += getHisId().hashCode();
        }
        if (getFormName() != null) {
            _hashCode += getFormName().hashCode();
        }
        if (getReturnXml() != null) {
            _hashCode += getReturnXml().hashCode();
        }
        if (getDateUpdate() != null) {
            _hashCode += getDateUpdate().hashCode();
        }
        if (getUhid() != null) {
            _hashCode += getUhid().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruit3BasicInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruit3BasicInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HisId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FormName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReturnXml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DateUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uhid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "uhid"));
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
