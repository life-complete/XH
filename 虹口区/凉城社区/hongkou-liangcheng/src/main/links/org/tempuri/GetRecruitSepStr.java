/**
 * GetRecruitSepStr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetRecruitSepStr  implements java.io.Serializable {
    private java.lang.String PATEINT_ID;

    private java.lang.String nurseGenre;

    private int index;

    private java.lang.String errorMsg;

    public GetRecruitSepStr() {
    }

    public GetRecruitSepStr(
           java.lang.String PATEINT_ID,
           java.lang.String nurseGenre,
           int index,
           java.lang.String errorMsg) {
           this.PATEINT_ID = PATEINT_ID;
           this.nurseGenre = nurseGenre;
           this.index = index;
           this.errorMsg = errorMsg;
    }


    /**
     * Gets the PATEINT_ID value for this GetRecruitSepStr.
     * 
     * @return PATEINT_ID
     */
    public java.lang.String getPATEINT_ID() {
        return PATEINT_ID;
    }


    /**
     * Sets the PATEINT_ID value for this GetRecruitSepStr.
     * 
     * @param PATEINT_ID
     */
    public void setPATEINT_ID(java.lang.String PATEINT_ID) {
        this.PATEINT_ID = PATEINT_ID;
    }


    /**
     * Gets the nurseGenre value for this GetRecruitSepStr.
     * 
     * @return nurseGenre
     */
    public java.lang.String getNurseGenre() {
        return nurseGenre;
    }


    /**
     * Sets the nurseGenre value for this GetRecruitSepStr.
     * 
     * @param nurseGenre
     */
    public void setNurseGenre(java.lang.String nurseGenre) {
        this.nurseGenre = nurseGenre;
    }


    /**
     * Gets the index value for this GetRecruitSepStr.
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }


    /**
     * Sets the index value for this GetRecruitSepStr.
     * 
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }


    /**
     * Gets the errorMsg value for this GetRecruitSepStr.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this GetRecruitSepStr.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitSepStr)) return false;
        GetRecruitSepStr other = (GetRecruitSepStr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PATEINT_ID==null && other.getPATEINT_ID()==null) || 
             (this.PATEINT_ID!=null &&
              this.PATEINT_ID.equals(other.getPATEINT_ID()))) &&
            ((this.nurseGenre==null && other.getNurseGenre()==null) || 
             (this.nurseGenre!=null &&
              this.nurseGenre.equals(other.getNurseGenre()))) &&
            this.index == other.getIndex() &&
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
        if (getPATEINT_ID() != null) {
            _hashCode += getPATEINT_ID().hashCode();
        }
        if (getNurseGenre() != null) {
            _hashCode += getNurseGenre().hashCode();
        }
        _hashCode += getIndex();
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitSepStr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getRecruitSepStr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PATEINT_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PATEINT_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nurseGenre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NurseGenre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
