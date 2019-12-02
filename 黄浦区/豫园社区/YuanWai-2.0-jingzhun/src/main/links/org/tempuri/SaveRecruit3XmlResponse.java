/**
 * SaveRecruit3XmlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SaveRecruit3XmlResponse  implements java.io.Serializable {
    private boolean saveRecruit3XmlResult;

    private java.lang.String dateUpdate;

    private java.lang.String errorMsg;

    public SaveRecruit3XmlResponse() {
    }

    public SaveRecruit3XmlResponse(
           boolean saveRecruit3XmlResult,
           java.lang.String dateUpdate,
           java.lang.String errorMsg) {
           this.saveRecruit3XmlResult = saveRecruit3XmlResult;
           this.dateUpdate = dateUpdate;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the saveRecruit3XmlResult value for this SaveRecruit3XmlResponse.
     * 
     * @return saveRecruit3XmlResult
     */
    public boolean isSaveRecruit3XmlResult() {
        return saveRecruit3XmlResult;
    }


    /**
     * Sets the saveRecruit3XmlResult value for this SaveRecruit3XmlResponse.
     * 
     * @param saveRecruit3XmlResult
     */
    public void setSaveRecruit3XmlResult(boolean saveRecruit3XmlResult) {
        this.saveRecruit3XmlResult = saveRecruit3XmlResult;
    }


    /**
     * Gets the dateUpdate value for this SaveRecruit3XmlResponse.
     * 
     * @return dateUpdate
     */
    public java.lang.String getDateUpdate() {
        return dateUpdate;
    }


    /**
     * Sets the dateUpdate value for this SaveRecruit3XmlResponse.
     * 
     * @param dateUpdate
     */
    public void setDateUpdate(java.lang.String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    /**
     * Gets the errorMsg value for this SaveRecruit3XmlResponse.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this SaveRecruit3XmlResponse.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveRecruit3XmlResponse)) return false;
        SaveRecruit3XmlResponse other = (SaveRecruit3XmlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.saveRecruit3XmlResult == other.isSaveRecruit3XmlResult() &&
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
        _hashCode += (isSaveRecruit3XmlResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        new org.apache.axis.description.TypeDesc(SaveRecruit3XmlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SaveRecruit3XmlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saveRecruit3XmlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SaveRecruit3XmlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
