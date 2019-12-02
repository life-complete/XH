/**
 * GetSubmissionHistory_HisIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetSubmissionHistory_HisIdResponse  implements java.io.Serializable {
    private java.lang.String getSubmissionHistory_HisIdResult;

    private java.lang.String[] history;

    private java.lang.String msg;

    public GetSubmissionHistory_HisIdResponse() {
    }

    public GetSubmissionHistory_HisIdResponse(
           java.lang.String getSubmissionHistory_HisIdResult,
           java.lang.String[] history,
           java.lang.String msg) {
           this.getSubmissionHistory_HisIdResult = getSubmissionHistory_HisIdResult;
           this.history = history;
           this.msg = msg;
    }


    /**
     * Gets the getSubmissionHistory_HisIdResult value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @return getSubmissionHistory_HisIdResult
     */
    public java.lang.String getGetSubmissionHistory_HisIdResult() {
        return getSubmissionHistory_HisIdResult;
    }


    /**
     * Sets the getSubmissionHistory_HisIdResult value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @param getSubmissionHistory_HisIdResult
     */
    public void setGetSubmissionHistory_HisIdResult(java.lang.String getSubmissionHistory_HisIdResult) {
        this.getSubmissionHistory_HisIdResult = getSubmissionHistory_HisIdResult;
    }


    /**
     * Gets the history value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @return history
     */
    public java.lang.String[] getHistory() {
        return history;
    }


    /**
     * Sets the history value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @param history
     */
    public void setHistory(java.lang.String[] history) {
        this.history = history;
    }


    /**
     * Gets the msg value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this GetSubmissionHistory_HisIdResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubmissionHistory_HisIdResponse)) return false;
        GetSubmissionHistory_HisIdResponse other = (GetSubmissionHistory_HisIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubmissionHistory_HisIdResult==null && other.getGetSubmissionHistory_HisIdResult()==null) || 
             (this.getSubmissionHistory_HisIdResult!=null &&
              this.getSubmissionHistory_HisIdResult.equals(other.getGetSubmissionHistory_HisIdResult()))) &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              java.util.Arrays.equals(this.history, other.getHistory()))) &&
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
        if (getGetSubmissionHistory_HisIdResult() != null) {
            _hashCode += getGetSubmissionHistory_HisIdResult().hashCode();
        }
        if (getHistory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHistory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHistory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubmissionHistory_HisIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSubmissionHistory_HisIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubmissionHistory_HisIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSubmissionHistory_HisIdResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "History"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
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
