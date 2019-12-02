/**
 * CommonSqlForRecruit3AllPagesToXml.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CommonSqlForRecruit3AllPagesToXml  implements java.io.Serializable {
    private java.lang.String conn;

    private java.lang.String uhid;

    private java.lang.String date_Validated;

    private java.lang.String formName;

    public CommonSqlForRecruit3AllPagesToXml() {
    }

    public CommonSqlForRecruit3AllPagesToXml(
           java.lang.String conn,
           java.lang.String uhid,
           java.lang.String date_Validated,
           java.lang.String formName) {
           this.conn = conn;
           this.uhid = uhid;
           this.date_Validated = date_Validated;
           this.formName = formName;
    }


    /**
     * Gets the conn value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @return conn
     */
    public java.lang.String getConn() {
        return conn;
    }


    /**
     * Sets the conn value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @param conn
     */
    public void setConn(java.lang.String conn) {
        this.conn = conn;
    }


    /**
     * Gets the uhid value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @return uhid
     */
    public java.lang.String getUhid() {
        return uhid;
    }


    /**
     * Sets the uhid value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @param uhid
     */
    public void setUhid(java.lang.String uhid) {
        this.uhid = uhid;
    }


    /**
     * Gets the date_Validated value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @return date_Validated
     */
    public java.lang.String getDate_Validated() {
        return date_Validated;
    }


    /**
     * Sets the date_Validated value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @param date_Validated
     */
    public void setDate_Validated(java.lang.String date_Validated) {
        this.date_Validated = date_Validated;
    }


    /**
     * Gets the formName value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @return formName
     */
    public java.lang.String getFormName() {
        return formName;
    }


    /**
     * Sets the formName value for this CommonSqlForRecruit3AllPagesToXml.
     * 
     * @param formName
     */
    public void setFormName(java.lang.String formName) {
        this.formName = formName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonSqlForRecruit3AllPagesToXml)) return false;
        CommonSqlForRecruit3AllPagesToXml other = (CommonSqlForRecruit3AllPagesToXml) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conn==null && other.getConn()==null) || 
             (this.conn!=null &&
              this.conn.equals(other.getConn()))) &&
            ((this.uhid==null && other.getUhid()==null) || 
             (this.uhid!=null &&
              this.uhid.equals(other.getUhid()))) &&
            ((this.date_Validated==null && other.getDate_Validated()==null) || 
             (this.date_Validated!=null &&
              this.date_Validated.equals(other.getDate_Validated()))) &&
            ((this.formName==null && other.getFormName()==null) || 
             (this.formName!=null &&
              this.formName.equals(other.getFormName())));
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
        if (getConn() != null) {
            _hashCode += getConn().hashCode();
        }
        if (getUhid() != null) {
            _hashCode += getUhid().hashCode();
        }
        if (getDate_Validated() != null) {
            _hashCode += getDate_Validated().hashCode();
        }
        if (getFormName() != null) {
            _hashCode += getFormName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonSqlForRecruit3AllPagesToXml.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CommonSqlForRecruit3AllPagesToXml"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Conn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uhid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Uhid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_Validated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Date_Validated"));
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
