/**
 * WebInterfaceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.winning.www;

public interface WebInterfaceSoap extends java.rmi.Remote {
    public java.lang.String helloWorld() throws java.rmi.RemoteException;
    public java.lang.String sendEmr(java.lang.String msgCode, java.lang.String sendXml, java.lang.String userCode) throws java.rmi.RemoteException;
}
