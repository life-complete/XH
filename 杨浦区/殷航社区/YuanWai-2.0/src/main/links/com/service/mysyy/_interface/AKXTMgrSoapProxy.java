package com.service.mysyy._interface;

public class AKXTMgrSoapProxy implements com.service.mysyy._interface.AKXTMgrSoap {
  private String _endpoint = null;
  private com.service.mysyy._interface.AKXTMgrSoap aKXTMgrSoap = null;
  
  public AKXTMgrSoapProxy() {
    _initAKXTMgrSoapProxy();
  }
  
  public AKXTMgrSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initAKXTMgrSoapProxy();
  }
  
  private void _initAKXTMgrSoapProxy() {
    try {
      aKXTMgrSoap = (new com.service.mysyy._interface.AKXTMgrLocator()).getAKXTMgrSoap();
      if (aKXTMgrSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aKXTMgrSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aKXTMgrSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aKXTMgrSoap != null)
      ((javax.xml.rpc.Stub)aKXTMgrSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.mysyy._interface.AKXTMgrSoap getAKXTMgrSoap() {
    if (aKXTMgrSoap == null)
      _initAKXTMgrSoapProxy();
    return aKXTMgrSoap;
  }
  
  public java.lang.String AKBloodGlucose(java.lang.String pInput) throws java.rmi.RemoteException{
    if (aKXTMgrSoap == null)
      _initAKXTMgrSoapProxy();
    return aKXTMgrSoap.AKBloodGlucose(pInput);
  }
  
  public java.lang.String AKBloodGlucose1(com.service.mysyy._interface.BloodGlucose pInput) throws java.rmi.RemoteException{
    if (aKXTMgrSoap == null)
      _initAKXTMgrSoapProxy();
    return aKXTMgrSoap.AKBloodGlucose1(pInput);
  }
  
  
}