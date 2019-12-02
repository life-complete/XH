/**
 * GetRecruitInfoByPages.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruitInfoByPages  implements java.io.Serializable {
    private java.lang.String hisid;

    private java.lang.String templateName;

    private int startPage;

    private int endPage;

    private java.lang.String currentHospital;

    public GetRecruitInfoByPages() {
    }

    public GetRecruitInfoByPages(
           java.lang.String hisid,
           java.lang.String templateName,
           int startPage,
           int endPage,
           java.lang.String currentHospital) {
           this.hisid = hisid;
           this.templateName = templateName;
           this.startPage = startPage;
           this.endPage = endPage;
           this.currentHospital = currentHospital;
    }


    /**
     * Gets the hisid value for this GetRecruitInfoByPages.
     * 
     * @return hisid
     */
    public java.lang.String getHisid() {
        return hisid;
    }


    /**
     * Sets the hisid value for this GetRecruitInfoByPages.
     * 
     * @param hisid
     */
    public void setHisid(java.lang.String hisid) {
        this.hisid = hisid;
    }


    /**
     * Gets the templateName value for this GetRecruitInfoByPages.
     * 
     * @return templateName
     */
    public java.lang.String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this GetRecruitInfoByPages.
     * 
     * @param templateName
     */
    public void setTemplateName(java.lang.String templateName) {
        this.templateName = templateName;
    }


    /**
     * Gets the startPage value for this GetRecruitInfoByPages.
     * 
     * @return startPage
     */
    public int getStartPage() {
        return startPage;
    }


    /**
     * Sets the startPage value for this GetRecruitInfoByPages.
     * 
     * @param startPage
     */
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }


    /**
     * Gets the endPage value for this GetRecruitInfoByPages.
     * 
     * @return endPage
     */
    public int getEndPage() {
        return endPage;
    }


    /**
     * Sets the endPage value for this GetRecruitInfoByPages.
     * 
     * @param endPage
     */
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }


    /**
     * Gets the currentHospital value for this GetRecruitInfoByPages.
     * 
     * @return currentHospital
     */
    public java.lang.String getCurrentHospital() {
        return currentHospital;
    }


    /**
     * Sets the currentHospital value for this GetRecruitInfoByPages.
     * 
     * @param currentHospital
     */
    public void setCurrentHospital(java.lang.String currentHospital) {
        this.currentHospital = currentHospital;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitInfoByPages)) return false;
        GetRecruitInfoByPages other = (GetRecruitInfoByPages) obj;
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
              this.hisid.equals(other.getHisid()))) &&
            ((this.templateName==null && other.getTemplateName()==null) || 
             (this.templateName!=null &&
              this.templateName.equals(other.getTemplateName()))) &&
            this.startPage == other.getStartPage() &&
            this.endPage == other.getEndPage() &&
            ((this.currentHospital==null && other.getCurrentHospital()==null) || 
             (this.currentHospital!=null &&
              this.currentHospital.equals(other.getCurrentHospital())));
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
            _hashCode += getHisid().hashCode();
        }
        if (getTemplateName() != null) {
            _hashCode += getTemplateName().hashCode();
        }
        _hashCode += getStartPage();
        _hashCode += getEndPage();
        if (getCurrentHospital() != null) {
            _hashCode += getCurrentHospital().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitInfoByPages.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruitInfoByPages"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Hisid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TemplateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "startPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "endPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentHospital");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CurrentHospital"));
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
