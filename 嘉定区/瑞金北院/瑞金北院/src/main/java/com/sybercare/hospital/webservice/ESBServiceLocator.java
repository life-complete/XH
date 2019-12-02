/**
 * ESBServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sybercare.hospital.webservice;

public class ESBServiceLocator extends org.apache.axis.client.Service implements com.sybercare.hospital.webservice.ESBService {

    public ESBServiceLocator() {
    }


    public ESBServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ESBServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ESBServiceSoap12
    private java.lang.String ESBServiceSoap12_address = "http://172.21.11.59/ESBService/ESBService.asmx";

    public java.lang.String getESBServiceSoap12Address() {
        return ESBServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ESBServiceSoap12WSDDServiceName = "ESBServiceSoap12";

    public java.lang.String getESBServiceSoap12WSDDServiceName() {
        return ESBServiceSoap12WSDDServiceName;
    }

    public void setESBServiceSoap12WSDDServiceName(java.lang.String name) {
        ESBServiceSoap12WSDDServiceName = name;
    }

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ESBServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getESBServiceSoap12(endpoint);
    }

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sybercare.hospital.webservice.ESBServiceSoap12Stub _stub = new com.sybercare.hospital.webservice.ESBServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getESBServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setESBServiceSoap12EndpointAddress(java.lang.String address) {
        ESBServiceSoap12_address = address;
    }


    // Use to get a proxy class for ESBServiceSoap
    private java.lang.String ESBServiceSoap_address = "http://172.21.11.59/ESBService/ESBService.asmx";

    public java.lang.String getESBServiceSoapAddress() {
        return ESBServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ESBServiceSoapWSDDServiceName = "ESBServiceSoap";

    public java.lang.String getESBServiceSoapWSDDServiceName() {
        return ESBServiceSoapWSDDServiceName;
    }

    public void setESBServiceSoapWSDDServiceName(java.lang.String name) {
        ESBServiceSoapWSDDServiceName = name;
    }

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ESBServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getESBServiceSoap(endpoint);
    }

    public com.sybercare.hospital.webservice.ESBServiceSoap_PortType getESBServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sybercare.hospital.webservice.ESBServiceSoap_BindingStub _stub = new com.sybercare.hospital.webservice.ESBServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getESBServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setESBServiceSoapEndpointAddress(java.lang.String address) {
        ESBServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sybercare.hospital.webservice.ESBServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sybercare.hospital.webservice.ESBServiceSoap12Stub _stub = new com.sybercare.hospital.webservice.ESBServiceSoap12Stub(new java.net.URL(ESBServiceSoap12_address), this);
                _stub.setPortName(getESBServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (com.sybercare.hospital.webservice.ESBServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sybercare.hospital.webservice.ESBServiceSoap_BindingStub _stub = new com.sybercare.hospital.webservice.ESBServiceSoap_BindingStub(new java.net.URL(ESBServiceSoap_address), this);
                _stub.setPortName(getESBServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ESBServiceSoap12".equals(inputPortName)) {
            return getESBServiceSoap12();
        }
        else if ("ESBServiceSoap".equals(inputPortName)) {
            return getESBServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ESB.Service/", "ESBService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ESB.Service/", "ESBServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://ESB.Service/", "ESBServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ESBServiceSoap12".equals(portName)) {
            setESBServiceSoap12EndpointAddress(address);
        }
        else 
if ("ESBServiceSoap".equals(portName)) {
            setESBServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
