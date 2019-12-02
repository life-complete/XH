/**
 * GetSubmissionHistory_UHIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetSubmissionHistory_UHIDResponse  implements java.io.Serializable {
    private java.lang.String getSubmissionHistory_UHIDResult;

    private java.lang.String[] history;

    private java.lang.String msg;

    public GetSubmissionHistory_UHIDResponse() {
    }

    public GetSubmissionHistory_UHIDResponse(
           java.lang.String getSubmissionHistory_UHIDResult,
           java.lang.String[] history,
           java.lang.String msg) {
           this.getSubmissionHistory_UHIDResult = getSubmissionHistory_UHIDResult;
           this.history = history;
           this.msg = msg;
    }


    /**
     * Gets the getSubmissionHistory_UHIDResult value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @return getSubmissionHistory_UHIDResult
     */
    public java.lang.String getGetSubmissionHistory_UHIDResult() {
        return getSubmissionHistory_UHIDResult;
    }


    /**
     * Sets the getSubmissionHistory_UHIDResult value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @param getSubmissionHistory_UHIDResult
     */
    public void setGetSubmissionHistory_UHIDResult(java.lang.String getSubmissionHistory_UHIDResult) {
        this.getSubmissionHistory_UHIDResult = getSubmissionHistory_UHIDResult;
    }


    /**
     * Gets the history value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @return history
     */
    public java.lang.String[] getHistory() {
        return history;
    }


    /**
     * Sets the history value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @param history
     */
    public void setHistory(java.lang.String[] history) {
        this.history = history;
    }


    /**
     * Gets the msg value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this GetSubmissionHistory_UHIDResponse.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubmissionHistory_UHIDResponse)) return false;
        GetSubmissionHistory_UHIDResponse other = (GetSubmissionHistory_UHIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubmissionHistory_UHIDResult==null && other.getGetSubmissionHistory_UHIDResult()==null) || 
             (this.getSubmissionHistory_UHIDResult!=null &&
              this.getSubmissionHistory_UHIDResult.equals(other.getGetSubmissionHistory_UHIDResult()))) &&
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
        if (getGetSubmissionHistory_UHIDResult() != null) {
            _hashCode += getGetSubmissionHistory_UHIDResult().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetSubmissionHistory_UHIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSubmissionHistory_UHIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubmissionHistory_UHIDResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSubmissionHistory_UHIDResult"));
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
