/**
 * CalculoRetiroWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ssffaa.calculoRetiroWS.webServices.calculo;

public interface CalculoRetiroWS_PortType extends java.rmi.Remote {
    public void calcular(java.lang.String run, java.lang.String institucion, java.lang.String subInstitucion, java.lang.String categoria, java.lang.String escalafonCivil, java.lang.String grado, int gradoJerarquico, int gradoEconomico, java.lang.String esDeLinea, java.util.Date fechaDeBaja, int cantidadDeAcciones, java.lang.String tipoDeAcciones, java.lang.String porcentajeDeSobresueldo, java.lang.String porcentajeDeSegundoSobresueldo, java.lang.String porcentajeDeAsignacionSOFSOM, java.lang.String poseeAsigMinistroDeCorte, int sueldoIntegroMinistroDeCorte, java.lang.String planillaSuplementariaLey19699, java.lang.String planillaSuplementariaDFL1_68, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc, int aniosDesahucio, int mesesDesahucio, int diasDesahucio, java.lang.String otrasInstituciones, java.lang.String abonos, java.lang.String concurrencias, javax.xml.rpc.holders.StringHolder grados, javax.xml.rpc.holders.IntHolder sueldoEnActividad, javax.xml.rpc.holders.IntHolder sueldo1981, javax.xml.rpc.holders.IntHolder cantidadTrienios, javax.xml.rpc.holders.StringHolder porcentajeTrienios, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18263, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18694, javax.xml.rpc.holders.StringHolder porcentajeSobresueldo, javax.xml.rpc.holders.IntHolder sobresueldoLey18263, javax.xml.rpc.holders.IntHolder sobresueldoLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifMandoAdministracion, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18263, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifAltoMando, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18263, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18694, javax.xml.rpc.holders.StringHolder aplicaPlanillaSuplementaria, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Actual, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Anio1981, javax.xml.rpc.holders.StringHolder porcentajeAsignacionSOM, javax.xml.rpc.holders.IntHolder asignacionSOMLey18263, javax.xml.rpc.holders.IntHolder asignacionSOMLey18694, javax.xml.rpc.holders.StringHolder porcentajeAsigMinistroDeCorte, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18263, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18694, javax.xml.rpc.holders.StringHolder poseeTituloProf, javax.xml.rpc.holders.IntHolder aegeLey18263, javax.xml.rpc.holders.IntHolder aegeLey18694, javax.xml.rpc.holders.IntHolder totalLey18263, javax.xml.rpc.holders.IntHolder totalParaDesahucio, javax.xml.rpc.holders.StringHolder cantidadAVOS, javax.xml.rpc.holders.IntHolder montoAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS, javax.xml.rpc.holders.IntHolder reajusteHasta8_8, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS376_1987, javax.xml.rpc.holders.IntHolder montoReajusteDS376_1987, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS321_1988, javax.xml.rpc.holders.IntHolder montoReajusteDS321_1988, javax.xml.rpc.holders.StringHolder tipoDocUltimoReajuste, javax.xml.rpc.holders.StringHolder numeroDocUltimoReajuste, javax.xml.rpc.holders.StringHolder porcentajeUltimoReajuste, javax.xml.rpc.holders.IntHolder montoUltimoReajuste, javax.xml.rpc.holders.IntHolder totalImponibleParcial, javax.xml.rpc.holders.IntHolder totalDesahucioSegunAvos, javax.xml.rpc.holders.IntHolder totalImponible, javax.xml.rpc.holders.IntHolder aegeNoImponible, javax.xml.rpc.holders.StringHolder recibePlanillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder planillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder bonificacionCompensatoria, javax.xml.rpc.holders.StringHolder tipoDeBonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeBonifRiesgoEspecial, javax.xml.rpc.holders.IntHolder bonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeAsigMinDeCorteNoImp, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteNoImp, javax.xml.rpc.holders.StringHolder porcentajeAsigSOMnoImp, javax.xml.rpc.holders.IntHolder asignacionSOMnoImp, javax.xml.rpc.holders.StringHolder porcentajeSegundoSobresueldo, javax.xml.rpc.holders.IntHolder segundoSobresueldo, javax.xml.rpc.holders.IntHolder totalRemuneracion, javax.xml.rpc.holders.IntHolder totalRemuneracionSegunAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS2, javax.xml.rpc.holders.IntHolder pensionAotorgar, javax.xml.rpc.holders.StringHolder conTopeSinTope, javax.xml.rpc.holders.IntHolder distribucionCapredena, javax.xml.rpc.holders.IntHolder distribucionFisco, javax.xml.rpc.holders.IntHolder distribucionTotal, javax.xml.rpc.holders.IntHolder mensualidadesDesahucio, javax.xml.rpc.holders.IntHolder montoMensualidadDesahucio, javax.xml.rpc.holders.IntHolder subtotalDesahucio, javax.xml.rpc.holders.IntHolder cantidadAcciones, javax.xml.rpc.holders.IntHolder montoUnitarioAcciones, javax.xml.rpc.holders.IntHolder subtotalAcciones, javax.xml.rpc.holders.IntHolder desahucioApagar, javax.xml.rpc.holders.IntHolder mesesSgteTrienio, javax.xml.rpc.holders.IntHolder diasSgteTrienio, javax.xml.rpc.holders.IntHolder siguienteTrienio, javax.xml.rpc.holders.StringHolder detalleDeServicios, javax.xml.rpc.holders.IntHolder aniosServiciosTotales, javax.xml.rpc.holders.IntHolder mesesServiciosTotales, javax.xml.rpc.holders.IntHolder diasServiciosTotales, javax.xml.rpc.holders.IntHolder enDiasServiciosTotales, javax.xml.rpc.holders.DoubleHolder proporcionServiciosTotales, javax.xml.rpc.holders.StringHolder detalleConcurrencias, javax.xml.rpc.holders.IntHolder totalConcurrencias) throws java.rmi.RemoteException;
}
