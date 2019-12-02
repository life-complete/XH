/**
 * EmrToExternalServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class EmrToExternalServiceLocator extends org.apache.axis.client.Service implements org.tempuri.EmrToExternalService {

    public EmrToExternalServiceLocator() {
    }


    public EmrToExternalServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmrToExternalServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmrToExternalServiceSoap
    private java.lang.String EmrToExternalServiceSoap_address = "http://192.168.2.132/EmrToExternalService/EmrToExternalService.asmx";

    public java.lang.String getEmrToExternalServiceSoapAddress() {
        return EmrToExternalServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmrToExternalServiceSoapWSDDServiceName = "EmrToExternalServiceSoap";

    public java.lang.String getEmrToExternalServiceSoapWSDDServiceName() {
        return EmrToExternalServiceSoapWSDDServiceName;
    }

    public void setEmrToExternalServiceSoapWSDDServiceName(java.lang.String name) {
        EmrToExternalServiceSoapWSDDServiceName = name;
    }

    public org.tempuri.EmrToExternalServiceSoap getEmrToExternalServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmrToExternalServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmrToExternalServiceSoap(endpoint);
    }

    public org.tempuri.EmrToExternalServiceSoap getEmrToExternalServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.EmrToExternalServiceSoapStub _stub = new org.tempuri.EmrToExternalServiceSoapStub(portAddress, this);
            _stub.setPortName(getEmrToExternalServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmrToExternalServiceSoapEndpointAddress(java.lang.String address) {
        EmrToExternalServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.EmrToExternalServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.EmrToExternalServiceSoapStub _stub = new org.tempuri.EmrToExternalServiceSoapStub(new java.net.URL(EmrToExternalServiceSoap_address), this);
                _stub.setPortName(getEmrToExternalServiceSoapWSDDServiceName());
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
        if ("EmrToExternalServiceSoap".equals(inputPortName)) {
            return getEmrToExternalServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "EmrToExternalService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "EmrToExternalServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmrToExternalServiceSoap".equals(portName)) {
            setEmrToExternalServiceSoapEndpointAddress(address);
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
