/**
 * ESBService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sybercare.hospital.webservice;

public interface ESBService extends javax.xml.rpc.Service {
    public java.lang.String getESBServiceSoap12Address();

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap12() throws javax.xml.rpc.ServiceException;

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getESBServiceSoapAddress();

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
