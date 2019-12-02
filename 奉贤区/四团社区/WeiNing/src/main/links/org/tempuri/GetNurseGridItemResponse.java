/**
 * GetNurseGridItemResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetNurseGridItemResponse  implements java.io.Serializable {
    private int getNurseGridItemResult;

    private org.tempuri.GetNurseGridItemResponseNuserTable nuserTable;

    public GetNurseGridItemResponse() {
    }

    public GetNurseGridItemResponse(
           int getNurseGridItemResult,
           org.tempuri.GetNurseGridItemResponseNuserTable nuserTable) {
           this.getNurseGridItemResult = getNurseGridItemResult;
           this.nuserTable = nuserTable;
    }


    /**
     * Gets the getNurseGridItemResult value for this GetNurseGridItemResponse.
     * 
     * @return getNurseGridItemResult
     */
    public int getGetNurseGridItemResult() {
        return getNurseGridItemResult;
    }


    /**
     * Sets the getNurseGridItemResult value for this GetNurseGridItemResponse.
     * 
     * @param getNurseGridItemResult
     */
    public void setGetNurseGridItemResult(int getNurseGridItemResult) {
        this.getNurseGridItemResult = getNurseGridItemResult;
    }


    /**
     * Gets the nuserTable value for this GetNurseGridItemResponse.
     * 
     * @return nuserTable
     */
    public org.tempuri.GetNurseGridItemResponseNuserTable getNuserTable() {
        return nuserTable;
    }


    /**
     * Sets the nuserTable value for this GetNurseGridItemResponse.
     * 
     * @param nuserTable
     */
    public void setNuserTable(org.tempuri.GetNurseGridItemResponseNuserTable nuserTable) {
        this.nuserTable = nuserTable;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNurseGridItemResponse)) return false;
        GetNurseGridItemResponse other = (GetNurseGridItemResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getNurseGridItemResult == other.getGetNurseGridItemResult() &&
            ((this.nuserTable==null && other.getNuserTable()==null) || 
             (this.nuserTable!=null &&
              this.nuserTable.equals(other.getNuserTable())));
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
        _hashCode += getGetNurseGridItemResult();
        if (getNuserTable() != null) {
            _hashCode += getNuserTable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNurseGridItemResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetNurseGridItemResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getNurseGridItemResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetNurseGridItemResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuserTable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NuserTable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetNurseGridItemResponse>NuserTable"));
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
