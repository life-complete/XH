package cn.com.winning.www;

public class WebInterfaceSoapProxy implements cn.com.winning.www.WebInterfaceSoap {
  private String _endpoint = null;
  private cn.com.winning.www.WebInterfaceSoap webInterfaceSoap = null;
  
  public WebInterfaceSoapProxy() {
    _initWebInterfaceSoapProxy();
  }
  
  public WebInterfaceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebInterfaceSoapProxy();
  }
  
  private void _initWebInterfaceSoapProxy() {
    try {
      webInterfaceSoap = (new cn.com.winning.www.WebInterfaceLocator()).getWebInterfaceSoap();
      if (webInterfaceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webInterfaceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webInterfaceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webInterfaceSoap != null)
      ((javax.xml.rpc.Stub)webInterfaceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.winning.www.WebInterfaceSoap getWebInterfaceSoap() {
    if (webInterfaceSoap == null)
      _initWebInterfaceSoapProxy();
    return webInterfaceSoap;
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (webInterfaceSoap == null)
      _initWebInterfaceSoapProxy();
    return webInterfaceSoap.helloWorld();
  }
  
  public java.lang.String sendEmr(java.lang.String msgCode, java.lang.String sendXml, java.lang.String userCode) throws java.rmi.RemoteException{
    if (webInterfaceSoap == null)
      _initWebInterfaceSoapProxy();
    return webInterfaceSoap.sendEmr(msgCode, sendXml, userCode);
  }
  
  
}