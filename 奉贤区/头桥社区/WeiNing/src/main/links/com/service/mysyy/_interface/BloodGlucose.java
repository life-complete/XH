/**
 * BloodGlucose.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service.mysyy._interface;

public class BloodGlucose  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String value;

    private java.lang.String status;

    private java.lang.String measuretime;

    private java.lang.String patientid;

    private java.lang.String opratorid;

    private java.lang.String operatestate;

    private java.lang.String operatetype;

    private java.lang.String remark;

    public BloodGlucose() {
    }

    public BloodGlucose(
           java.lang.String id,
           java.lang.String value,
           java.lang.String status,
           java.lang.String measuretime,
           java.lang.String patientid,
           java.lang.String opratorid,
           java.lang.String operatestate,
           java.lang.String operatetype,
           java.lang.String remark) {
           this.id = id;
           this.value = value;
           this.status = status;
           this.measuretime = measuretime;
           this.patientid = patientid;
           this.opratorid = opratorid;
           this.operatestate = operatestate;
           this.operatetype = operatetype;
           this.remark = remark;
    }


    /**
     * Gets the id value for this BloodGlucose.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this BloodGlucose.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the value value for this BloodGlucose.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this BloodGlucose.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the status value for this BloodGlucose.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this BloodGlucose.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the measuretime value for this BloodGlucose.
     * 
     * @return measuretime
     */
    public java.lang.String getMeasuretime() {
        return measuretime;
    }


    /**
     * Sets the measuretime value for this BloodGlucose.
     * 
     * @param measuretime
     */
    public void setMeasuretime(java.lang.String measuretime) {
        this.measuretime = measuretime;
    }


    /**
     * Gets the patientid value for this BloodGlucose.
     * 
     * @return patientid
     */
    public java.lang.String getPatientid() {
        return patientid;
    }


    /**
     * Sets the patientid value for this BloodGlucose.
     * 
     * @param patientid
     */
    public void setPatientid(java.lang.String patientid) {
        this.patientid = patientid;
    }


    /**
     * Gets the opratorid value for this BloodGlucose.
     * 
     * @return opratorid
     */
    public java.lang.String getOpratorid() {
        return opratorid;
    }


    /**
     * Sets the opratorid value for this BloodGlucose.
     * 
     * @param opratorid
     */
    public void setOpratorid(java.lang.String opratorid) {
        this.opratorid = opratorid;
    }


    /**
     * Gets the operatestate value for this BloodGlucose.
     * 
     * @return operatestate
     */
    public java.lang.String getOperatestate() {
        return operatestate;
    }


    /**
     * Sets the operatestate value for this BloodGlucose.
     * 
     * @param operatestate
     */
    public void setOperatestate(java.lang.String operatestate) {
        this.operatestate = operatestate;
    }


    /**
     * Gets the operatetype value for this BloodGlucose.
     * 
     * @return operatetype
     */
    public java.lang.String getOperatetype() {
        return operatetype;
    }


    /**
     * Sets the operatetype value for this BloodGlucose.
     * 
     * @param operatetype
     */
    public void setOperatetype(java.lang.String operatetype) {
        this.operatetype = operatetype;
    }


    /**
     * Gets the remark value for this BloodGlucose.
     * 
     * @return remark
     */
    public java.lang.String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this BloodGlucose.
     * 
     * @param remark
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BloodGlucose)) return false;
        BloodGlucose other = (BloodGlucose) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.measuretime==null && other.getMeasuretime()==null) || 
             (this.measuretime!=null &&
              this.measuretime.equals(other.getMeasuretime()))) &&
            ((this.patientid==null && other.getPatientid()==null) || 
             (this.patientid!=null &&
              this.patientid.equals(other.getPatientid()))) &&
            ((this.opratorid==null && other.getOpratorid()==null) || 
             (this.opratorid!=null &&
              this.opratorid.equals(other.getOpratorid()))) &&
            ((this.operatestate==null && other.getOperatestate()==null) || 
             (this.operatestate!=null &&
              this.operatestate.equals(other.getOperatestate()))) &&
            ((this.operatetype==null && other.getOperatetype()==null) || 
             (this.operatetype!=null &&
              this.operatetype.equals(other.getOperatetype()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getMeasuretime() != null) {
            _hashCode += getMeasuretime().hashCode();
        }
        if (getPatientid() != null) {
            _hashCode += getPatientid().hashCode();
        }
        if (getOpratorid() != null) {
            _hashCode += getOpratorid().hashCode();
        }
        if (getOperatestate() != null) {
            _hashCode += getOperatestate().hashCode();
        }
        if (getOperatetype() != null) {
            _hashCode += getOperatetype().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BloodGlucose.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "BloodGlucose"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measuretime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "measuretime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "patientid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opratorid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "opratorid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatestate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "operatestate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatetype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "operatetype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "remark"));
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
