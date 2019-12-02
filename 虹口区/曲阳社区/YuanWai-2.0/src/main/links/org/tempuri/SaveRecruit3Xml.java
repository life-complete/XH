/**
 * SaveRecruit3Xml.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SaveRecruit3Xml  implements java.io.Serializable {
    private java.lang.String userId;

    private java.lang.String formType;

    private java.lang.String pageCount;

    private java.lang.String hisId;

    private java.lang.String formName;

    private java.lang.String returnXml;

    private java.lang.String dateUpdate;

    private java.lang.String errorMsg;

    public SaveRecruit3Xml() {
    }

    public SaveRecruit3Xml(
           java.lang.String userId,
           java.lang.String formType,
           java.lang.String pageCount,
           java.lang.String hisId,
           java.lang.String formName,
           java.lang.String returnXml,
           java.lang.String dateUpdate,
           java.lang.String errorMsg) {
           this.userId = userId;
           this.formType = formType;
           this.pageCount = pageCount;
           this.hisId = hisId;
           this.formName = formName;
           this.returnXml = returnXml;
           this.dateUpdate = dateUpdate;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the userId value for this SaveRecruit3Xml.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this SaveRecruit3Xml.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the formType value for this SaveRecruit3Xml.
     * 
     * @return formType
     */
    public java.lang.String getFormType() {
        return formType;
    }


    /**
     * Sets the formType value for this SaveRecruit3Xml.
     * 
     * @param formType
     */
    public void setFormType(java.lang.String formType) {
        this.formType = formType;
    }


    /**
     * Gets the pageCount value for this SaveRecruit3Xml.
     * 
     * @return pageCount
     */
    public java.lang.String getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this SaveRecruit3Xml.
     * 
     * @param pageCount
     */
    public void setPageCount(java.lang.String pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the hisId value for this SaveRecruit3Xml.
     * 
     * @return hisId
     */
    public java.lang.String getHisId() {
        return hisId;
    }


    /**
     * Sets the hisId value for this SaveRecruit3Xml.
     * 
     * @param hisId
     */
    public void setHisId(java.lang.String hisId) {
        this.hisId = hisId;
    }


    /**
     * Gets the formName value for this SaveRecruit3Xml.
     * 
     * @return formName
     */
    public java.lang.String getFormName() {
        return formName;
    }


    /**
     * Sets the formName value for this SaveRecruit3Xml.
     * 
     * @param formName
     */
    public void setFormName(java.lang.String formName) {
        this.formName = formName;
    }


    /**
     * Gets the returnXml value for this SaveRecruit3Xml.
     * 
     * @return returnXml
     */
    public java.lang.String getReturnXml() {
        return returnXml;
    }


    /**
     * Sets the returnXml value for this SaveRecruit3Xml.
     * 
     * @param returnXml
     */
    public void setReturnXml(java.lang.String returnXml) {
        this.returnXml = returnXml;
    }


    /**
     * Gets the dateUpdate value for this SaveRecruit3Xml.
     * 
     * @return dateUpdate
     */
    public java.lang.String getDateUpdate() {
        return dateUpdate;
    }


    /**
     * Sets the dateUpdate value for this SaveRecruit3Xml.
     * 
     * @param dateUpdate
     */
    public void setDateUpdate(java.lang.String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    /**
     * Gets the errorMsg value for this SaveRecruit3Xml.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this SaveRecruit3Xml.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveRecruit3Xml)) return false;
        SaveRecruit3Xml other = (SaveRecruit3Xml) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.formType==null && other.getFormType()==null) || 
             (this.formType!=null &&
              this.formType.equals(other.getFormType()))) &&
            ((this.pageCount==null && other.getPageCount()==null) || 
             (this.pageCount!=null &&
              this.pageCount.equals(other.getPageCount()))) &&
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
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getFormType() != null) {
            _hashCode += getFormType().hashCode();
        }
        if (getPageCount() != null) {
            _hashCode += getPageCount().hashCode();
        }
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
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveRecruit3Xml.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SaveRecruit3Xml"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FormType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PageCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
