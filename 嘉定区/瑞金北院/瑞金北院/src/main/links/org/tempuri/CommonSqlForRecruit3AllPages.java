/**
 * CommonSqlForRecruit3AllPages.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CommonSqlForRecruit3AllPages  implements java.io.Serializable {
    private java.lang.String conn;

    private java.lang.String uhid;

    private java.lang.String date_Validated;

    private java.lang.String formName;

    private org.tempuri.CommonSqlForRecruit3AllPagesDsResult dsResult;

    private java.lang.String msg;

    public CommonSqlForRecruit3AllPages() {
    }

    public CommonSqlForRecruit3AllPages(
           java.lang.String conn,
           java.lang.String uhid,
           java.lang.String date_Validated,
           java.lang.String formName,
           org.tempuri.CommonSqlForRecruit3AllPagesDsResult dsResult,
           java.lang.String msg) {
           this.conn = conn;
           this.uhid = uhid;
           this.date_Validated = date_Validated;
           this.formName = formName;
           this.dsResult = dsResult;
           this.msg = msg;
    }


    /**
     * Gets the conn value for this CommonSqlForRecruit3AllPages.
     * 
     * @return conn
     */
    public java.lang.String getConn() {
        return conn;
    }


    /**
     * Sets the conn value for this CommonSqlForRecruit3AllPages.
     * 
     * @param conn
     */
    public void setConn(java.lang.String conn) {
        this.conn = conn;
    }


    /**
     * Gets the uhid value for this CommonSqlForRecruit3AllPages.
     * 
     * @return uhid
     */
    public java.lang.String getUhid() {
        return uhid;
    }


    /**
     * Sets the uhid value for this CommonSqlForRecruit3AllPages.
     * 
     * @param uhid
     */
    public void setUhid(java.lang.String uhid) {
        this.uhid = uhid;
    }


    /**
     * Gets the date_Validated value for this CommonSqlForRecruit3AllPages.
     * 
     * @return date_Validated
     */
    public java.lang.String getDate_Validated() {
        return date_Validated;
    }


    /**
     * Sets the date_Validated value for this CommonSqlForRecruit3AllPages.
     * 
     * @param date_Validated
     */
    public void setDate_Validated(java.lang.String date_Validated) {
        this.date_Validated = date_Validated;
    }


    /**
     * Gets the formName value for this CommonSqlForRecruit3AllPages.
     * 
     * @return formName
     */
    public java.lang.String getFormName() {
        return formName;
    }


    /**
     * Sets the formName value for this CommonSqlForRecruit3AllPages.
     * 
     * @param formName
     */
    public void setFormName(java.lang.String formName) {
        this.formName = formName;
    }


    /**
     * Gets the dsResult value for this CommonSqlForRecruit3AllPages.
     * 
     * @return dsResult
     */
    public org.tempuri.CommonSqlForRecruit3AllPagesDsResult getDsResult() {
        return dsResult;
    }


    /**
     * Sets the dsResult value for this CommonSqlForRecruit3AllPages.
     * 
     * @param dsResult
     */
    public void setDsResult(org.tempuri.CommonSqlForRecruit3AllPagesDsResult dsResult) {
        this.dsResult = dsResult;
    }


    /**
     * Gets the msg value for this CommonSqlForRecruit3AllPages.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this CommonSqlForRecruit3AllPages.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonSqlForRecruit3AllPages)) return false;
        CommonSqlForRecruit3AllPages other = (CommonSqlForRecruit3AllPages) obj;
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
              this.formName.equals(other.getFormName()))) &&
            ((this.dsResult==null && other.getDsResult()==null) || 
             (this.dsResult!=null &&
              this.dsResult.equals(other.getDsResult()))) &&
            ((this.msg==null && other.getMsg()==null) || 
             (this.msg!=null &&
              this.msg.equals(other.getMsg())));
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
        if (getDsResult() != null) {
            _hashCode += getDsResult().hashCode();
        }
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonSqlForRecruit3AllPages.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CommonSqlForRecruit3AllPages"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>CommonSqlForRecruit3AllPages>DsResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "msg"));
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
