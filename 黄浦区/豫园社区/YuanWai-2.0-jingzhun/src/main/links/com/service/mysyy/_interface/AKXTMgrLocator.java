/**
 * AKXTMgrLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service.mysyy._interface;

public class AKXTMgrLocator extends org.apache.axis.client.Service implements com.service.mysyy._interface.AKXTMgr {

    public AKXTMgrLocator() {
    }


    public AKXTMgrLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AKXTMgrLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AKXTMgrSoap
    private java.lang.String AKXTMgrSoap_address = "http://10.0.0.137:57772/csp/hsd/HSI.BS.AKXTMgr.cls";
//    private java.lang.String AKXTMgrSoap_address = "http://10.0.0.137:57772/csp/hsd/HSI.BS.AKXTMgr.CLS?WSDL=1";

    public java.lang.String getAKXTMgrSoapAddress() {
        return AKXTMgrSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AKXTMgrSoapWSDDServiceName = "AKXTMgrSoap";

    public java.lang.String getAKXTMgrSoapWSDDServiceName() {
        return AKXTMgrSoapWSDDServiceName;
    }

    public void setAKXTMgrSoapWSDDServiceName(java.lang.String name) {
        AKXTMgrSoapWSDDServiceName = name;
    }

    public com.service.mysyy._interface.AKXTMgrSoap getAKXTMgrSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AKXTMgrSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAKXTMgrSoap(endpoint);
    }

    public com.service.mysyy._interface.AKXTMgrSoap getAKXTMgrSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.service.mysyy._interface.AKXTMgrSoapStub _stub = new com.service.mysyy._interface.AKXTMgrSoapStub(portAddress, this);
            _stub.setPortName(getAKXTMgrSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAKXTMgrSoapEndpointAddress(java.lang.String address) {
        AKXTMgrSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.service.mysyy._interface.AKXTMgrSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.service.mysyy._interface.AKXTMgrSoapStub _stub = new com.service.mysyy._interface.AKXTMgrSoapStub(new java.net.URL(AKXTMgrSoap_address), this);
                _stub.setPortName(getAKXTMgrSoapWSDDServiceName());
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
        if ("AKXTMgrSoap".equals(inputPortName)) {
            return getAKXTMgrSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mysyy.service.com/interface", "AKXTMgr");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mysyy.service.com/interface", "AKXTMgrSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AKXTMgrSoap".equals(portName)) {
            setAKXTMgrSoapEndpointAddress(address);
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
