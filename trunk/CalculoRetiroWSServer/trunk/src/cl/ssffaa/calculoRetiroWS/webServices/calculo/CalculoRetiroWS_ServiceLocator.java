/**
 * CalculoRetiroWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ssffaa.calculoRetiroWS.webServices.calculo;

public class CalculoRetiroWS_ServiceLocator extends org.apache.axis.client.Service implements cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_Service {

    public CalculoRetiroWS_ServiceLocator() {
    }


    public CalculoRetiroWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculoRetiroWS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalculoRetiroWSSOAP
    private java.lang.String CalculoRetiroWSSOAP_address = "http://www.example.org/";

    public java.lang.String getCalculoRetiroWSSOAPAddress() {
        return CalculoRetiroWSSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculoRetiroWSSOAPWSDDServiceName = "CalculoRetiroWSSOAP";

    public java.lang.String getCalculoRetiroWSSOAPWSDDServiceName() {
        return CalculoRetiroWSSOAPWSDDServiceName;
    }

    public void setCalculoRetiroWSSOAPWSDDServiceName(java.lang.String name) {
        CalculoRetiroWSSOAPWSDDServiceName = name;
    }

    public cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType getCalculoRetiroWSSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalculoRetiroWSSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculoRetiroWSSOAP(endpoint);
    }

    public cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType getCalculoRetiroWSSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWSSOAPStub _stub = new cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWSSOAPStub(portAddress, this);
            _stub.setPortName(getCalculoRetiroWSSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculoRetiroWSSOAPEndpointAddress(java.lang.String address) {
        CalculoRetiroWSSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWSSOAPStub _stub = new cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWSSOAPStub(new java.net.URL(CalculoRetiroWSSOAP_address), this);
                _stub.setPortName(getCalculoRetiroWSSOAPWSDDServiceName());
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
        if ("CalculoRetiroWSSOAP".equals(inputPortName)) {
            return getCalculoRetiroWSSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://calculo.webServices.calculoRetiroWS.ssffaa.cl", "CalculoRetiroWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://calculo.webServices.calculoRetiroWS.ssffaa.cl", "CalculoRetiroWSSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalculoRetiroWSSOAP".equals(portName)) {
            setCalculoRetiroWSSOAPEndpointAddress(address);
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
