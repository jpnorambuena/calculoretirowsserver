/**
 * CalculoRetiroWSSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ssffaa.calculoRetiroWS.webServices.calculo;

public class CalculoRetiroWSSOAPStub extends org.apache.axis.client.Stub implements cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("calcular");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "run"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "institucion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subInstitucion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "categoria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "escalafonCivil"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "grado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gradoJerarquico"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gradoEconomico"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "esDeLinea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fechaDeBaja"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cantidadDeAcciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipoDeAcciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeDeSobresueldo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeDeSegundoSobresueldo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeDeAsignacionSOFSOM"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "poseeAsigMinistroDeCorte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sueldoIntegroMinistroDeCorte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "planillaSuplementariaDFL1_68"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aniosCPDNyConsc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mesesCPDNyConsc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "diasCPDNyConsc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aniosDesahucio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mesesDesahucio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "diasDesahucio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "otrasInstituciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "abonos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "concurrencias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "grados"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sueldoEnActividad"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sueldo1981"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cantidadTrienios"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeTrienios"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asignacionTrieniosLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asignacionTrieniosLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeSobresueldo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sobresueldoLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sobresueldoLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeBonifMandoAdministracion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeBonifAltoMando"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonifAltoMandoLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonifAltoMandoLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aplicaPlanillaSuplementaria"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699Actual"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699anio1981"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAsignacionSOM"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asignacionSOMLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asignacionSOMLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAsigMinistroDeCorte"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "poseeTituloProf"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aegeLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aegeLey18694"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalLey18263"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalParaDesahucio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cantidadAVOS"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoAVOS"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAVOS"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "reajusteHasta8_8"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeReajusteDS376_1987"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoReajusteDS376_1987"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeReajusteDS321_1988"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoReajusteDS321_1988"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipoDocUltimoReajuste"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "numeroDocUltimoReajuste"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeUltimoReajuste"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoUltimoReajuste"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalImponibleParcial"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalDesahucioSegunAvos"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalImponible"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aegeNoImponible"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recibePlanillaSuplementariaDfl_1_68"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "planillaSuplementariaDfl_1_68"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonificacionCompensatoria"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipoDeBonifRiesgoEspecial"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeBonifRiesgoEspecial"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bonifRiesgoEspecial"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAsigMinDeCorteNoImp"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asigMinistroDeCorteNoImp"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAsigSOMnoImp"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "asignacionSOMnoImp"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeSegundoSobresueldo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "segundoSobresueldo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalRemuneracion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalRemuneracionSegunAVOS"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "porcentajeAVOS2"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pensionAotorgar"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "conTopeSinTope"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "distribucionCapredena"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "distribucionFisco"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "distribucionTotal"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mensualidadesDesahucio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoMensualidadDesahucio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subtotalDesahucio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cantidadAcciones"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "montoUnitarioAcciones"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subtotalAcciones"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "desahucioApagar"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mesesSgteTrienio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "diasSgteTrienio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "siguienteTrienio"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "detalleDeServicios"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://to.dao.calculoRetiroWS.ssffaa.cl", "ItemGrillaWSTO"), cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aniosServiciosTotales"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mesesServiciosTotales"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "diasServiciosTotales"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "enDiasServiciosTotales"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "proporcionServiciosTotales"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "detalleConcurrencias"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://to.dao.calculoRetiroWS.ssffaa.cl", "ItemGrillaWSTO"), cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalConcurrencias"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

    }

    public CalculoRetiroWSSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CalculoRetiroWSSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CalculoRetiroWSSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://to.dao.calculoRetiroWS.ssffaa.cl", "ItemColumnaWSTO");
            cachedSerQNames.add(qName);
            cls = cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://to.dao.calculoRetiroWS.ssffaa.cl", "ItemGrillaWSTO");
            cachedSerQNames.add(qName);
            cls = cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void calcular(java.lang.String run, java.lang.String institucion, java.lang.String subInstitucion, java.lang.String categoria, java.lang.String escalafonCivil, java.lang.String grado, int gradoJerarquico, int gradoEconomico, java.lang.String esDeLinea, java.util.Date fechaDeBaja, int cantidadDeAcciones, java.lang.String tipoDeAcciones, java.lang.String porcentajeDeSobresueldo, java.lang.String porcentajeDeSegundoSobresueldo, java.lang.String porcentajeDeAsignacionSOFSOM, java.lang.String poseeAsigMinistroDeCorte, int sueldoIntegroMinistroDeCorte, java.lang.String planillaSuplementariaLey19699, java.lang.String planillaSuplementariaDFL1_68, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc, int aniosDesahucio, int mesesDesahucio, int diasDesahucio, java.lang.String otrasInstituciones, java.lang.String abonos, java.lang.String concurrencias, javax.xml.rpc.holders.StringHolder grados, javax.xml.rpc.holders.IntHolder sueldoEnActividad, javax.xml.rpc.holders.IntHolder sueldo1981, javax.xml.rpc.holders.IntHolder cantidadTrienios, javax.xml.rpc.holders.StringHolder porcentajeTrienios, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18263, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18694, javax.xml.rpc.holders.StringHolder porcentajeSobresueldo, javax.xml.rpc.holders.IntHolder sobresueldoLey18263, javax.xml.rpc.holders.IntHolder sobresueldoLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifMandoAdministracion, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18263, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifAltoMando, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18263, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18694, javax.xml.rpc.holders.StringHolder aplicaPlanillaSuplementaria, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Actual, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Anio1981, javax.xml.rpc.holders.StringHolder porcentajeAsignacionSOM, javax.xml.rpc.holders.IntHolder asignacionSOMLey18263, javax.xml.rpc.holders.IntHolder asignacionSOMLey18694, javax.xml.rpc.holders.StringHolder porcentajeAsigMinistroDeCorte, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18263, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18694, javax.xml.rpc.holders.StringHolder poseeTituloProf, javax.xml.rpc.holders.IntHolder aegeLey18263, javax.xml.rpc.holders.IntHolder aegeLey18694, javax.xml.rpc.holders.IntHolder totalLey18263, javax.xml.rpc.holders.IntHolder totalParaDesahucio, javax.xml.rpc.holders.StringHolder cantidadAVOS, javax.xml.rpc.holders.IntHolder montoAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS, javax.xml.rpc.holders.IntHolder reajusteHasta8_8, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS376_1987, javax.xml.rpc.holders.IntHolder montoReajusteDS376_1987, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS321_1988, javax.xml.rpc.holders.IntHolder montoReajusteDS321_1988, javax.xml.rpc.holders.StringHolder tipoDocUltimoReajuste, javax.xml.rpc.holders.StringHolder numeroDocUltimoReajuste, javax.xml.rpc.holders.StringHolder porcentajeUltimoReajuste, javax.xml.rpc.holders.IntHolder montoUltimoReajuste, javax.xml.rpc.holders.IntHolder totalImponibleParcial, javax.xml.rpc.holders.IntHolder totalDesahucioSegunAvos, javax.xml.rpc.holders.IntHolder totalImponible, javax.xml.rpc.holders.IntHolder aegeNoImponible, javax.xml.rpc.holders.StringHolder recibePlanillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder planillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder bonificacionCompensatoria, javax.xml.rpc.holders.StringHolder tipoDeBonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeBonifRiesgoEspecial, javax.xml.rpc.holders.IntHolder bonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeAsigMinDeCorteNoImp, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteNoImp, javax.xml.rpc.holders.StringHolder porcentajeAsigSOMnoImp, javax.xml.rpc.holders.IntHolder asignacionSOMnoImp, javax.xml.rpc.holders.StringHolder porcentajeSegundoSobresueldo, javax.xml.rpc.holders.IntHolder segundoSobresueldo, javax.xml.rpc.holders.IntHolder totalRemuneracion, javax.xml.rpc.holders.IntHolder totalRemuneracionSegunAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS2, javax.xml.rpc.holders.IntHolder pensionAotorgar, javax.xml.rpc.holders.StringHolder conTopeSinTope, javax.xml.rpc.holders.IntHolder distribucionCapredena, javax.xml.rpc.holders.IntHolder distribucionFisco, javax.xml.rpc.holders.IntHolder distribucionTotal, javax.xml.rpc.holders.IntHolder mensualidadesDesahucio, javax.xml.rpc.holders.IntHolder montoMensualidadDesahucio, javax.xml.rpc.holders.IntHolder subtotalDesahucio, javax.xml.rpc.holders.IntHolder cantidadAcciones, javax.xml.rpc.holders.IntHolder montoUnitarioAcciones, javax.xml.rpc.holders.IntHolder subtotalAcciones, javax.xml.rpc.holders.IntHolder desahucioApagar, javax.xml.rpc.holders.IntHolder mesesSgteTrienio, javax.xml.rpc.holders.IntHolder diasSgteTrienio, javax.xml.rpc.holders.IntHolder siguienteTrienio, cl.ssffaa.calculoRetiroWS.dao.to.holders.ItemGrillaWSTOArrayHolder detalleDeServicios, javax.xml.rpc.holders.IntHolder aniosServiciosTotales, javax.xml.rpc.holders.IntHolder mesesServiciosTotales, javax.xml.rpc.holders.IntHolder diasServiciosTotales, javax.xml.rpc.holders.IntHolder enDiasServiciosTotales, javax.xml.rpc.holders.DoubleHolder proporcionServiciosTotales, cl.ssffaa.calculoRetiroWS.dao.to.holders.ItemGrillaWSTOArrayHolder detalleConcurrencias, javax.xml.rpc.holders.IntHolder totalConcurrencias) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://calculo.webServices.calculoRetiroWS.ssffaa.cl/calcular");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://calculo.webServices.calculoRetiroWS.ssffaa.cl", "calcular"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {run, institucion, subInstitucion, categoria, escalafonCivil, grado, new java.lang.Integer(gradoJerarquico), new java.lang.Integer(gradoEconomico), esDeLinea, fechaDeBaja, new java.lang.Integer(cantidadDeAcciones), tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, new java.lang.Integer(sueldoIntegroMinistroDeCorte), planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, new java.lang.Integer(aniosCPDNyConsc), new java.lang.Integer(mesesCPDNyConsc), new java.lang.Integer(diasCPDNyConsc), new java.lang.Integer(aniosDesahucio), new java.lang.Integer(mesesDesahucio), new java.lang.Integer(diasDesahucio), otrasInstituciones, abonos, concurrencias});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                grados.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "grados"));
            } catch (java.lang.Exception _exception) {
                grados.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "grados")), java.lang.String.class);
            }
            try {
                sueldoEnActividad.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "sueldoEnActividad"))).intValue();
            } catch (java.lang.Exception _exception) {
                sueldoEnActividad.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sueldoEnActividad")), int.class)).intValue();
            }
            try {
                sueldo1981.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "sueldo1981"))).intValue();
            } catch (java.lang.Exception _exception) {
                sueldo1981.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sueldo1981")), int.class)).intValue();
            }
            try {
                cantidadTrienios.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "cantidadTrienios"))).intValue();
            } catch (java.lang.Exception _exception) {
                cantidadTrienios.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "cantidadTrienios")), int.class)).intValue();
            }
            try {
                porcentajeTrienios.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeTrienios"));
            } catch (java.lang.Exception _exception) {
                porcentajeTrienios.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeTrienios")), java.lang.String.class);
            }
            try {
                asignacionTrieniosLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asignacionTrieniosLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                asignacionTrieniosLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asignacionTrieniosLey18263")), int.class)).intValue();
            }
            try {
                asignacionTrieniosLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asignacionTrieniosLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                asignacionTrieniosLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asignacionTrieniosLey18694")), int.class)).intValue();
            }
            try {
                porcentajeSobresueldo.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeSobresueldo"));
            } catch (java.lang.Exception _exception) {
                porcentajeSobresueldo.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeSobresueldo")), java.lang.String.class);
            }
            try {
                sobresueldoLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "sobresueldoLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                sobresueldoLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sobresueldoLey18263")), int.class)).intValue();
            }
            try {
                sobresueldoLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "sobresueldoLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                sobresueldoLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sobresueldoLey18694")), int.class)).intValue();
            }
            try {
                porcentajeBonifMandoAdministracion.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeBonifMandoAdministracion"));
            } catch (java.lang.Exception _exception) {
                porcentajeBonifMandoAdministracion.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeBonifMandoAdministracion")), java.lang.String.class);
            }
            try {
                bonifMandoAdministracionLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonifMandoAdministracionLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18263")), int.class)).intValue();
            }
            try {
                bonifMandoAdministracionLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonifMandoAdministracionLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonifMandoAdministracionLey18694")), int.class)).intValue();
            }
            try {
                porcentajeBonifAltoMando.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeBonifAltoMando"));
            } catch (java.lang.Exception _exception) {
                porcentajeBonifAltoMando.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeBonifAltoMando")), java.lang.String.class);
            }
            try {
                bonifAltoMandoLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonifAltoMandoLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonifAltoMandoLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonifAltoMandoLey18263")), int.class)).intValue();
            }
            try {
                bonifAltoMandoLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonifAltoMandoLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonifAltoMandoLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonifAltoMandoLey18694")), int.class)).intValue();
            }
            try {
                aplicaPlanillaSuplementaria.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "aplicaPlanillaSuplementaria"));
            } catch (java.lang.Exception _exception) {
                aplicaPlanillaSuplementaria.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "aplicaPlanillaSuplementaria")), java.lang.String.class);
            }
            try {
                planillaSuplementariaLey19699Actual.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699Actual"))).intValue();
            } catch (java.lang.Exception _exception) {
                planillaSuplementariaLey19699Actual.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699Actual")), int.class)).intValue();
            }
            try {
                planillaSuplementariaLey19699Anio1981.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699anio1981"))).intValue();
            } catch (java.lang.Exception _exception) {
                planillaSuplementariaLey19699Anio1981.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "planillaSuplementariaLey19699anio1981")), int.class)).intValue();
            }
            try {
                porcentajeAsignacionSOM.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAsignacionSOM"));
            } catch (java.lang.Exception _exception) {
                porcentajeAsignacionSOM.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAsignacionSOM")), java.lang.String.class);
            }
            try {
                asignacionSOMLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asignacionSOMLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                asignacionSOMLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asignacionSOMLey18263")), int.class)).intValue();
            }
            try {
                asignacionSOMLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asignacionSOMLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                asignacionSOMLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asignacionSOMLey18694")), int.class)).intValue();
            }
            try {
                porcentajeAsigMinistroDeCorte.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAsigMinistroDeCorte"));
            } catch (java.lang.Exception _exception) {
                porcentajeAsigMinistroDeCorte.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAsigMinistroDeCorte")), java.lang.String.class);
            }
            try {
                asigMinistroDeCorteLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                asigMinistroDeCorteLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18263")), int.class)).intValue();
            }
            try {
                asigMinistroDeCorteLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                asigMinistroDeCorteLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteLey18694")), int.class)).intValue();
            }
            try {
                poseeTituloProf.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "poseeTituloProf"));
            } catch (java.lang.Exception _exception) {
                poseeTituloProf.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "poseeTituloProf")), java.lang.String.class);
            }
            try {
                aegeLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "aegeLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                aegeLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "aegeLey18263")), int.class)).intValue();
            }
            try {
                aegeLey18694.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "aegeLey18694"))).intValue();
            } catch (java.lang.Exception _exception) {
                aegeLey18694.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "aegeLey18694")), int.class)).intValue();
            }
            try {
                totalLey18263.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalLey18263"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalLey18263.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalLey18263")), int.class)).intValue();
            }
            try {
                totalParaDesahucio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalParaDesahucio"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalParaDesahucio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalParaDesahucio")), int.class)).intValue();
            }
            try {
                cantidadAVOS.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "cantidadAVOS"));
            } catch (java.lang.Exception _exception) {
                cantidadAVOS.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "cantidadAVOS")), java.lang.String.class);
            }
            try {
                montoAVOS.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoAVOS"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoAVOS.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoAVOS")), int.class)).intValue();
            }
            try {
                porcentajeAVOS.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAVOS"));
            } catch (java.lang.Exception _exception) {
                porcentajeAVOS.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAVOS")), java.lang.String.class);
            }
            try {
                reajusteHasta8_8.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "reajusteHasta8_8"))).intValue();
            } catch (java.lang.Exception _exception) {
                reajusteHasta8_8.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "reajusteHasta8_8")), int.class)).intValue();
            }
            try {
                porcentajeReajusteDS376_1987.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeReajusteDS376_1987"));
            } catch (java.lang.Exception _exception) {
                porcentajeReajusteDS376_1987.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeReajusteDS376_1987")), java.lang.String.class);
            }
            try {
                montoReajusteDS376_1987.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoReajusteDS376_1987"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoReajusteDS376_1987.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoReajusteDS376_1987")), int.class)).intValue();
            }
            try {
                porcentajeReajusteDS321_1988.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeReajusteDS321_1988"));
            } catch (java.lang.Exception _exception) {
                porcentajeReajusteDS321_1988.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeReajusteDS321_1988")), java.lang.String.class);
            }
            try {
                montoReajusteDS321_1988.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoReajusteDS321_1988"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoReajusteDS321_1988.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoReajusteDS321_1988")), int.class)).intValue();
            }
            try {
                tipoDocUltimoReajuste.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "tipoDocUltimoReajuste"));
            } catch (java.lang.Exception _exception) {
                tipoDocUltimoReajuste.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "tipoDocUltimoReajuste")), java.lang.String.class);
            }
            try {
                numeroDocUltimoReajuste.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "numeroDocUltimoReajuste"));
            } catch (java.lang.Exception _exception) {
                numeroDocUltimoReajuste.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "numeroDocUltimoReajuste")), java.lang.String.class);
            }
            try {
                porcentajeUltimoReajuste.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeUltimoReajuste"));
            } catch (java.lang.Exception _exception) {
                porcentajeUltimoReajuste.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeUltimoReajuste")), java.lang.String.class);
            }
            try {
                montoUltimoReajuste.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoUltimoReajuste"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoUltimoReajuste.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoUltimoReajuste")), int.class)).intValue();
            }
            try {
                totalImponibleParcial.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalImponibleParcial"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalImponibleParcial.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalImponibleParcial")), int.class)).intValue();
            }
            try {
                totalDesahucioSegunAvos.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalDesahucioSegunAvos"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalDesahucioSegunAvos.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalDesahucioSegunAvos")), int.class)).intValue();
            }
            try {
                totalImponible.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalImponible"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalImponible.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalImponible")), int.class)).intValue();
            }
            try {
                aegeNoImponible.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "aegeNoImponible"))).intValue();
            } catch (java.lang.Exception _exception) {
                aegeNoImponible.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "aegeNoImponible")), int.class)).intValue();
            }
            try {
                recibePlanillaSuplementariaDfl_1_68.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "recibePlanillaSuplementariaDfl_1_68"));
            } catch (java.lang.Exception _exception) {
                recibePlanillaSuplementariaDfl_1_68.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "recibePlanillaSuplementariaDfl_1_68")), java.lang.String.class);
            }
            try {
                planillaSuplementariaDfl_1_68.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "planillaSuplementariaDfl_1_68"))).intValue();
            } catch (java.lang.Exception _exception) {
                planillaSuplementariaDfl_1_68.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "planillaSuplementariaDfl_1_68")), int.class)).intValue();
            }
            try {
                bonificacionCompensatoria.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonificacionCompensatoria"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonificacionCompensatoria.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonificacionCompensatoria")), int.class)).intValue();
            }
            try {
                tipoDeBonifRiesgoEspecial.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "tipoDeBonifRiesgoEspecial"));
            } catch (java.lang.Exception _exception) {
                tipoDeBonifRiesgoEspecial.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "tipoDeBonifRiesgoEspecial")), java.lang.String.class);
            }
            try {
                porcentajeBonifRiesgoEspecial.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeBonifRiesgoEspecial"));
            } catch (java.lang.Exception _exception) {
                porcentajeBonifRiesgoEspecial.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeBonifRiesgoEspecial")), java.lang.String.class);
            }
            try {
                bonifRiesgoEspecial.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "bonifRiesgoEspecial"))).intValue();
            } catch (java.lang.Exception _exception) {
                bonifRiesgoEspecial.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "bonifRiesgoEspecial")), int.class)).intValue();
            }
            try {
                porcentajeAsigMinDeCorteNoImp.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAsigMinDeCorteNoImp"));
            } catch (java.lang.Exception _exception) {
                porcentajeAsigMinDeCorteNoImp.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAsigMinDeCorteNoImp")), java.lang.String.class);
            }
            try {
                asigMinistroDeCorteNoImp.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteNoImp"))).intValue();
            } catch (java.lang.Exception _exception) {
                asigMinistroDeCorteNoImp.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asigMinistroDeCorteNoImp")), int.class)).intValue();
            }
            try {
                porcentajeAsigSOMnoImp.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAsigSOMnoImp"));
            } catch (java.lang.Exception _exception) {
                porcentajeAsigSOMnoImp.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAsigSOMnoImp")), java.lang.String.class);
            }
            try {
                asignacionSOMnoImp.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "asignacionSOMnoImp"))).intValue();
            } catch (java.lang.Exception _exception) {
                asignacionSOMnoImp.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "asignacionSOMnoImp")), int.class)).intValue();
            }
            try {
                porcentajeSegundoSobresueldo.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeSegundoSobresueldo"));
            } catch (java.lang.Exception _exception) {
                porcentajeSegundoSobresueldo.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeSegundoSobresueldo")), java.lang.String.class);
            }
            try {
                segundoSobresueldo.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "segundoSobresueldo"))).intValue();
            } catch (java.lang.Exception _exception) {
                segundoSobresueldo.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "segundoSobresueldo")), int.class)).intValue();
            }
            try {
                totalRemuneracion.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalRemuneracion"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalRemuneracion.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalRemuneracion")), int.class)).intValue();
            }
            try {
                totalRemuneracionSegunAVOS.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalRemuneracionSegunAVOS"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalRemuneracionSegunAVOS.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalRemuneracionSegunAVOS")), int.class)).intValue();
            }
            try {
                porcentajeAVOS2.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "porcentajeAVOS2"));
            } catch (java.lang.Exception _exception) {
                porcentajeAVOS2.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "porcentajeAVOS2")), java.lang.String.class);
            }
            try {
                pensionAotorgar.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "pensionAotorgar"))).intValue();
            } catch (java.lang.Exception _exception) {
                pensionAotorgar.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "pensionAotorgar")), int.class)).intValue();
            }
            try {
                conTopeSinTope.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "conTopeSinTope"));
            } catch (java.lang.Exception _exception) {
                conTopeSinTope.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "conTopeSinTope")), java.lang.String.class);
            }
            try {
                distribucionCapredena.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "distribucionCapredena"))).intValue();
            } catch (java.lang.Exception _exception) {
                distribucionCapredena.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "distribucionCapredena")), int.class)).intValue();
            }
            try {
                distribucionFisco.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "distribucionFisco"))).intValue();
            } catch (java.lang.Exception _exception) {
                distribucionFisco.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "distribucionFisco")), int.class)).intValue();
            }
            try {
                distribucionTotal.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "distribucionTotal"))).intValue();
            } catch (java.lang.Exception _exception) {
                distribucionTotal.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "distribucionTotal")), int.class)).intValue();
            }
            try {
                mensualidadesDesahucio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "mensualidadesDesahucio"))).intValue();
            } catch (java.lang.Exception _exception) {
                mensualidadesDesahucio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "mensualidadesDesahucio")), int.class)).intValue();
            }
            try {
                montoMensualidadDesahucio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoMensualidadDesahucio"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoMensualidadDesahucio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoMensualidadDesahucio")), int.class)).intValue();
            }
            try {
                subtotalDesahucio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "subtotalDesahucio"))).intValue();
            } catch (java.lang.Exception _exception) {
                subtotalDesahucio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "subtotalDesahucio")), int.class)).intValue();
            }
            try {
                cantidadAcciones.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "cantidadAcciones"))).intValue();
            } catch (java.lang.Exception _exception) {
                cantidadAcciones.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "cantidadAcciones")), int.class)).intValue();
            }
            try {
                montoUnitarioAcciones.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "montoUnitarioAcciones"))).intValue();
            } catch (java.lang.Exception _exception) {
                montoUnitarioAcciones.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "montoUnitarioAcciones")), int.class)).intValue();
            }
            try {
                subtotalAcciones.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "subtotalAcciones"))).intValue();
            } catch (java.lang.Exception _exception) {
                subtotalAcciones.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "subtotalAcciones")), int.class)).intValue();
            }
            try {
                desahucioApagar.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "desahucioApagar"))).intValue();
            } catch (java.lang.Exception _exception) {
                desahucioApagar.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "desahucioApagar")), int.class)).intValue();
            }
            try {
                mesesSgteTrienio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "mesesSgteTrienio"))).intValue();
            } catch (java.lang.Exception _exception) {
                mesesSgteTrienio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "mesesSgteTrienio")), int.class)).intValue();
            }
            try {
                diasSgteTrienio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "diasSgteTrienio"))).intValue();
            } catch (java.lang.Exception _exception) {
                diasSgteTrienio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "diasSgteTrienio")), int.class)).intValue();
            }
            try {
                siguienteTrienio.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "siguienteTrienio"))).intValue();
            } catch (java.lang.Exception _exception) {
                siguienteTrienio.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "siguienteTrienio")), int.class)).intValue();
            }
            try {
                detalleDeServicios.value = (cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[]) _output.get(new javax.xml.namespace.QName("", "detalleDeServicios"));
            } catch (java.lang.Exception _exception) {
                detalleDeServicios.value = (cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "detalleDeServicios")), cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[].class);
            }
            try {
                aniosServiciosTotales.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "aniosServiciosTotales"))).intValue();
            } catch (java.lang.Exception _exception) {
                aniosServiciosTotales.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "aniosServiciosTotales")), int.class)).intValue();
            }
            try {
                mesesServiciosTotales.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "mesesServiciosTotales"))).intValue();
            } catch (java.lang.Exception _exception) {
                mesesServiciosTotales.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "mesesServiciosTotales")), int.class)).intValue();
            }
            try {
                diasServiciosTotales.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "diasServiciosTotales"))).intValue();
            } catch (java.lang.Exception _exception) {
                diasServiciosTotales.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "diasServiciosTotales")), int.class)).intValue();
            }
            try {
                enDiasServiciosTotales.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "enDiasServiciosTotales"))).intValue();
            } catch (java.lang.Exception _exception) {
                enDiasServiciosTotales.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "enDiasServiciosTotales")), int.class)).intValue();
            }
            try {
                proporcionServiciosTotales.value = ((java.lang.Double) _output.get(new javax.xml.namespace.QName("", "proporcionServiciosTotales"))).doubleValue();
            } catch (java.lang.Exception _exception) {
                proporcionServiciosTotales.value = ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "proporcionServiciosTotales")), double.class)).doubleValue();
            }
            try {
                detalleConcurrencias.value = (cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[]) _output.get(new javax.xml.namespace.QName("", "detalleConcurrencias"));
            } catch (java.lang.Exception _exception) {
                detalleConcurrencias.value = (cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "detalleConcurrencias")), cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO[].class);
            }
            try {
                totalConcurrencias.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "totalConcurrencias"))).intValue();
            } catch (java.lang.Exception _exception) {
                totalConcurrencias.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "totalConcurrencias")), int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
