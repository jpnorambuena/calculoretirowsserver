/**
 * CalculoRetiroWSSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ssffaa.calculoRetiroWS.webServices.calculo;

import java.sql.Connection;
import java.util.Date;

import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeAbono;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeAsignacion;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeAvo;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeBonificacion;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeCompensacion;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeConcurrencia;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeDetalleServicio;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeGradoJerarquico;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadePension;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeReajuste;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeSueldoBase;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeTipoDePersonal;
import cl.ssffaa.calculoRetiroWS.dao.facade.FacadeTrienio;
import cl.ssffaa.calculoRetiroWS.dao.implementation.DBMannager;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleAbonoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleDeServiciosTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DistribucionConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.UltimoReajustePasivoTO;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumPalabrasLogicas;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeAcciones;
import cl.ssffaa.calculoRetiroWS.util.Grilla;
import cl.ssffaa.calculoRetiroWS.util.OperacionDeNegocio;
import cl.ssffaa.calculoRetiroWS.util.Util;

public class CalculoRetiroWSSOAPImpl implements cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType{
    
	int _gradoEconomico = -1;
    int _gradoJerarquico= -1;
    int _idTipoDePersonal = -1;
    String _tipoDePersonal = "";
    int _idEspecificacionGrado = -1;
    int _aniosCPDNyConsc = 0;
    int _mesesCPDNyConsc = 0;
	int _diasCPDNyConsc = 0;
	int _aniosDesahucio = 0;
	int _mesesDesahucio = 0;
	int _diasDesahucio = 0;

	int _aniosEfectivosAbonosConcurrencias = 0;
    int _mesesEfectivosAbonosConcurrencias = 0;
    int _diasEfectivosAbonosConcurrencias = 0;
    
    Date _fechaDeBaja = new Date();
    int _idReajusteAaplicar = -1;
    
    int _sueldoBaseLey18263 = 0;
    int _sueldoBaseLey18694 = 0;
    int _cantidadTrienios = 0;
    int _porcentajeTrienios = 0;
    int _porcentajeSobresueldo = 0;
    int _porcentajeSegundoSobresueldo = 0;
    int _porcentajeBonifMandoAdministracion = 0;
    int _porcentajeBonifAltoMando = 0;
    boolean _esDeLinea = false;
    boolean _esMinistroDeCorte = false;
    int _sueldoMinistroDeCorte = 0;
    int _porcentajeMinistroDeCorte = 0;
    int _gradoPlanillaSuplLey19699 = -1;
    int _planillaSuplementariaLey19699Actual = 0;
    int _planillaSuplementariaLey19699Anio1981 = 0;
    int _porcentajeAsignacionSOM = 0;
    int _porcentajeAsignacionSOMimponible = 0;
    int _porcentajeAsignacionSOMnoImp = 0; 
    int _aegeLey18263 = 0;
    int _aegeLey18694 = 0;
    int _asignacionTrieniosLey18263 = 0;
    int _asignacionTrieniosLey18694 = 0;
    int _sobresueldoLey18263 = 0;
	int _sobresueldoLey18694 = 0;
	int _sobresueldoNoImp = 0;
	int _bonifMandoAdministracionLey18263 = 0;
	int _bonifMandoAdministracionLey18694 = 0;
	int _bonifAltoMandoLey18263 = 0;
	int _bonifAltoMandoLey18694 = 0;
	int _asignacionSOMLey18263 = 0;
	int _asignacionSOMLey18694 = 0;
	int _asignacionSOMnoImp = 0;
	int _asigMinistroDeCorteLey18263 = 0;
	int _asigMinistroDeCorteLey18694 = 0;
    int _totalLey18263 = 0;
    int _totalParaDesahucio = 0;
    int _montoAvos = 0;
    double _porcentajeAvos = 0.0;
    int _montoComponenteBase = 0;
    int _montoIncrementoInstitucional = 0;
    int _montoIncrementoColectivo = 0;
    int _totalImponibleParcial = 0;
    int _totalDesahucioSegunAvos = 0;
    int _totalImponible = 0;
    int _aegeNoImponible = 0;
    int _gradoPlanillaSuplDfl_1_68 = -1;
    int _planillaSuplementariaDfl_1_68 = 0;
    int _porcentajeMinistroDeCorteNoImp = 0;
    int _asigMinistroDeCorteNoImp = 0;
    int _totalRemuneracion = 0;
    int _bonificacionRiesgoEspecial = 0;
    int _bonificacionCompensatoria = 0;
    int _totalRemuneracionSegunAVOS = 0;
    int _montoFinalOtrosReajustes = 0;
    int _pensionAotorgar = 0;
    String _mensajeTope = "";
    String _tipoBonificacion = "";
    int _porcentajeBonifRiesgoEspecial = 0;
    int _reajusteHasta8_8 = 0;
    double _porcentajeReajusteDS376_1987 = 0.0;
	int _montoReajusteDS376_1987 = 0;
	double _porcentajeReajusteDS321_1988 = 0.0;
	int _montoReajusteDS321_1988 = 0;
	int _distribucionCapredena = 0;
	int _distribucionFisco = 0;
	int _distribucionTotal = 0;
	int _mensualidadesDesahucio = 0;
	int _montoMensualidadDesahucio = 0;
	int _subtotalDesahucio = 0;
	int _cantidadAcciones = 0;
	int _montoUnitarioAcciones = 0;
	int _subtotalAcciones = 0;
	int _desahucioApagar = 0;
	int _mesesSgteTrienio = 0;
	int _diasSgteTrienio = 0;
	int _siguienteTrienio = 0;
	String _instituciones = "";
	
	String _detalleDeServicios = "";
	String _detalleDeConcurrencias = "";
	
	
	DetalleDeServiciosTO _detallesDeServicio = new DetalleDeServiciosTO();
	ItemGrillaWSTO[] _itemGrillaDetallesDeServicio = null;
	
	
	
	DistribucionConcurrenciaTO _distribucionConcurrencia = new DistribucionConcurrenciaTO();
	ItemGrillaWSTO[] _itemGrillaDistribucionConcurrencia = null; 
	
	
	DetalleAbonoTO _detalleAbono = new DetalleAbonoTO();
	DetalleConcurrenciaTO _detalleConcurrencia = new DetalleConcurrenciaTO();
	
	String mensaje = "";

	public void calcular(java.lang.String run, java.lang.String institucion, java.lang.String subInstitucion, java.lang.String categoria, java.lang.String escalafonCivil, java.lang.String grado, int gradoJerarquico, int gradoEconomico, java.lang.String esDeLinea, java.util.Date fechaDeBaja, int cantidadDeAcciones, java.lang.String tipoDeAcciones, java.lang.String porcentajeDeSobresueldo, java.lang.String porcentajeDeSegundoSobresueldo, java.lang.String porcentajeDeAsignacionSOFSOM, java.lang.String poseeAsigMinistroDeCorte, int sueldoIntegroMinistroDeCorte, java.lang.String planillaSuplementariaLey19699, java.lang.String planillaSuplementariaDFL1_68, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc, int aniosDesahucio, int mesesDesahucio, int diasDesahucio, java.lang.String otrasInstituciones, java.lang.String abonos, java.lang.String concurrencias, javax.xml.rpc.holders.StringHolder grados, javax.xml.rpc.holders.IntHolder sueldoEnActividad, javax.xml.rpc.holders.IntHolder sueldo1981, javax.xml.rpc.holders.IntHolder cantidadTrienios, javax.xml.rpc.holders.StringHolder porcentajeTrienios, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18263, javax.xml.rpc.holders.IntHolder asignacionTrieniosLey18694, javax.xml.rpc.holders.StringHolder porcentajeSobresueldo, javax.xml.rpc.holders.IntHolder sobresueldoLey18263, javax.xml.rpc.holders.IntHolder sobresueldoLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifMandoAdministracion, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18263, javax.xml.rpc.holders.IntHolder bonifMandoAdministracionLey18694, javax.xml.rpc.holders.StringHolder porcentajeBonifAltoMando, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18263, javax.xml.rpc.holders.IntHolder bonifAltoMandoLey18694, javax.xml.rpc.holders.StringHolder aplicaPlanillaSuplementaria, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Actual, javax.xml.rpc.holders.IntHolder planillaSuplementariaLey19699Anio1981, javax.xml.rpc.holders.StringHolder porcentajeAsignacionSOM, javax.xml.rpc.holders.IntHolder asignacionSOMLey18263, javax.xml.rpc.holders.IntHolder asignacionSOMLey18694, javax.xml.rpc.holders.StringHolder porcentajeAsigMinistroDeCorte, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18263, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteLey18694, javax.xml.rpc.holders.StringHolder poseeTituloProf, javax.xml.rpc.holders.IntHolder aegeLey18263, javax.xml.rpc.holders.IntHolder aegeLey18694, javax.xml.rpc.holders.IntHolder totalLey18263, javax.xml.rpc.holders.IntHolder totalParaDesahucio, javax.xml.rpc.holders.StringHolder cantidadAVOS, javax.xml.rpc.holders.IntHolder montoAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS, javax.xml.rpc.holders.IntHolder reajusteHasta8_8, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS376_1987, javax.xml.rpc.holders.IntHolder montoReajusteDS376_1987, javax.xml.rpc.holders.StringHolder porcentajeReajusteDS321_1988, javax.xml.rpc.holders.IntHolder montoReajusteDS321_1988, javax.xml.rpc.holders.StringHolder tipoDocUltimoReajuste, javax.xml.rpc.holders.StringHolder numeroDocUltimoReajuste, javax.xml.rpc.holders.StringHolder porcentajeUltimoReajuste, javax.xml.rpc.holders.IntHolder montoUltimoReajuste, javax.xml.rpc.holders.IntHolder totalImponibleParcial, javax.xml.rpc.holders.IntHolder totalDesahucioSegunAvos, javax.xml.rpc.holders.IntHolder totalImponible, javax.xml.rpc.holders.IntHolder aegeNoImponible, javax.xml.rpc.holders.StringHolder recibePlanillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder planillaSuplementariaDfl_1_68, javax.xml.rpc.holders.IntHolder bonificacionCompensatoria, javax.xml.rpc.holders.StringHolder tipoDeBonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeBonifRiesgoEspecial, javax.xml.rpc.holders.IntHolder bonifRiesgoEspecial, javax.xml.rpc.holders.StringHolder porcentajeAsigMinDeCorteNoImp, javax.xml.rpc.holders.IntHolder asigMinistroDeCorteNoImp, javax.xml.rpc.holders.StringHolder porcentajeAsigSOMnoImp, javax.xml.rpc.holders.IntHolder asignacionSOMnoImp, javax.xml.rpc.holders.StringHolder porcentajeSegundoSobresueldo, javax.xml.rpc.holders.IntHolder segundoSobresueldo, javax.xml.rpc.holders.IntHolder totalRemuneracion, javax.xml.rpc.holders.IntHolder totalRemuneracionSegunAVOS, javax.xml.rpc.holders.StringHolder porcentajeAVOS2, javax.xml.rpc.holders.IntHolder pensionAotorgar, javax.xml.rpc.holders.StringHolder conTopeSinTope, javax.xml.rpc.holders.IntHolder distribucionCapredena, javax.xml.rpc.holders.IntHolder distribucionFisco, javax.xml.rpc.holders.IntHolder distribucionTotal, javax.xml.rpc.holders.IntHolder mensualidadesDesahucio, javax.xml.rpc.holders.IntHolder montoMensualidadDesahucio, javax.xml.rpc.holders.IntHolder subtotalDesahucio, javax.xml.rpc.holders.IntHolder cantidadAcciones, javax.xml.rpc.holders.IntHolder montoUnitarioAcciones, javax.xml.rpc.holders.IntHolder subtotalAcciones, javax.xml.rpc.holders.IntHolder desahucioApagar, javax.xml.rpc.holders.IntHolder mesesSgteTrienio, javax.xml.rpc.holders.IntHolder diasSgteTrienio, javax.xml.rpc.holders.IntHolder siguienteTrienio, javax.xml.rpc.holders.StringHolder detalleDeServicios, javax.xml.rpc.holders.IntHolder aniosServiciosTotales, javax.xml.rpc.holders.IntHolder mesesServiciosTotales, javax.xml.rpc.holders.IntHolder diasServiciosTotales, javax.xml.rpc.holders.IntHolder enDiasServiciosTotales, javax.xml.rpc.holders.DoubleHolder proporcionServiciosTotales, javax.xml.rpc.holders.StringHolder detalleConcurrencias, javax.xml.rpc.holders.IntHolder totalConcurrencias) throws java.rmi.RemoteException {
        
		Connection c = DBMannager.getConnection();

        FacadeTipoDePersonal facadeTipoDePersonal = new FacadeTipoDePersonal(c);
        FacadeGradoJerarquico facadeGradoJerarquico = new FacadeGradoJerarquico(c);
        FacadeReajuste facadeReajuste = new FacadeReajuste(c);
        FacadeSueldoBase facadeSueldoBase = new FacadeSueldoBase(c);
        FacadeTrienio facadeTrienio = new FacadeTrienio(c);
        FacadeAsignacion facadeAsignacion = new FacadeAsignacion(c);
        FacadeBonificacion facadeBonificacion = new FacadeBonificacion(c);
        FacadeCompensacion facadeCompensacion = new FacadeCompensacion(c);
        OperacionDeNegocio operacionDeNegocio = new OperacionDeNegocio();
        FacadeAbono facadeAbono = new FacadeAbono();
        FacadeConcurrencia facadeConcurrencia = new FacadeConcurrencia();
        FacadeDetalleServicio facadeDetalleServicio = new FacadeDetalleServicio();
        FacadeAvo facadeAvo = new FacadeAvo(c);
        FacadePension facadePension = new FacadePension();
        
        this._gradoEconomico = gradoEconomico;
        this._idTipoDePersonal = facadeTipoDePersonal.obtenerIdTipoDePersonal(categoria, grado, escalafonCivil);
        this._tipoDePersonal = facadeTipoDePersonal.obtenerTipoDePersonal(categoria, grado, escalafonCivil);
        
        
        System.out.println("RUN PENSIONADO : "+ run);
        
        //this._gradoJerarquico = grado;
        this._gradoJerarquico = facadeGradoJerarquico.obtenerIdGradoJerarquico(this._idTipoDePersonal, subInstitucion, categoria, grado, escalafonCivil);
        if(this._gradoJerarquico < 0)
                this._gradoJerarquico = gradoJerarquico;
        
        this._idEspecificacionGrado = facadeGradoJerarquico.obtenerIdEspecificacionDeGrado(this._gradoJerarquico, this._idTipoDePersonal);
        this._fechaDeBaja = fechaDeBaja;
        this._idReajusteAaplicar = facadeReajuste.obtenerReajusteAaplicar(this._fechaDeBaja);
        
        if(esDeLinea.equalsIgnoreCase(EnumPalabrasLogicas.SI) || esDeLinea.equalsIgnoreCase(EnumPalabrasLogicas.SIacento)){
                this._esDeLinea = true;
        }
        else{
                this._esDeLinea = false;
        }
        
        if(Util.isNumber("" + diasCPDNyConsc)){
                this._diasCPDNyConsc = Util.obtenerDiasNormalizados(diasCPDNyConsc);
        }
        else{
                this._diasCPDNyConsc = 0;
        }
        
        if(Util.isNumber("" + mesesCPDNyConsc)){
                this._mesesCPDNyConsc = Util.obtenerMesesNormalizados(diasCPDNyConsc, mesesCPDNyConsc);
        }
        else{
                this._mesesCPDNyConsc = 0;
        }
        
        if(Util.isNumber("" + aniosCPDNyConsc)){
                this._aniosCPDNyConsc = Util.obtenerAniosNormalizados(diasCPDNyConsc, mesesCPDNyConsc, aniosCPDNyConsc);
        }
        else{
                this._aniosCPDNyConsc = 0;
        }
        
        if(Util.isNumber("" + diasDesahucio)){
                this._diasDesahucio = Util.obtenerDiasNormalizados(diasDesahucio);
        }
        else{
                this._diasDesahucio = 0;
        }
        
        if(Util.isNumber("" + mesesDesahucio)){
                this._mesesDesahucio = Util.obtenerMesesNormalizados(diasDesahucio, mesesDesahucio);
        }
        else{
                this._mesesDesahucio = 0;
        }
        
        if(Util.isNumber("" + aniosDesahucio)){
                this._aniosDesahucio = Util.obtenerAniosNormalizados(diasDesahucio, mesesDesahucio, aniosDesahucio);
        }
        else{
                this._aniosDesahucio = 0;
        }
        
        this._detalleAbono = facadeAbono.obtenerDetalleDeAbonos(abonos);
        
        this._detalleConcurrencia = facadeConcurrencia.obtenerDetalleDeConcurrencias(concurrencias);
        
        int totalAnios = this._aniosCPDNyConsc + this._detalleAbono.getTotalAnios() + this._detalleConcurrencia.getTotalAnios();
        int totalMeses = this._mesesCPDNyConsc + this._detalleAbono.getTotalMeses() + this._detalleConcurrencia.getTotalMeses();
        int totalDias = this._diasCPDNyConsc + this._detalleAbono.getTotalDias() + this._detalleConcurrencia.getTotalDias();
        
        this._diasEfectivosAbonosConcurrencias = Util.obtenerDiasNormalizados(totalDias);
        this._mesesEfectivosAbonosConcurrencias = Util.obtenerMesesNormalizados(totalDias, totalMeses);
        this._aniosEfectivosAbonosConcurrencias = Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios);
                
        //S008
        grados.value = this._gradoJerarquico + "/" + this._gradoEconomico;
        System.out.println("GRADOS : "+ grados.value);
                
        //S009a
        this._sueldoBaseLey18263 = facadeSueldoBase.obtenerSueldo1981(this._gradoEconomico);
        sueldo1981.value = this._sueldoBaseLey18263;
        System.out.println("SUELDO 1981 : "+ sueldo1981.value);
        
        //S009b
        this._sueldoBaseLey18694 = facadeSueldoBase.obtenerSueldoEnActividad(this._gradoEconomico, this._idReajusteAaplicar);
        sueldoEnActividad.value = this._sueldoBaseLey18694;
        System.out.println("SUELDO EN ACTIVIDAD : "+ sueldoEnActividad.value);
        
        this._cantidadTrienios = facadeTrienio.obtenerCantidadDeTrienios(this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
        //S010
        cantidadTrienios.value = this._cantidadTrienios;
        System.out.println("CANTIDAD TRIENIOS : "+ cantidadTrienios.value);
        
        //S011
        this._porcentajeTrienios = facadeTrienio.obtenerPorcentajeTrienios(this._cantidadTrienios, this._fechaDeBaja);
        porcentajeTrienios.value = this._porcentajeTrienios + "%";
        System.out.println("PORCENTAJE TRIENIOS : "+ porcentajeTrienios.value);
        
        this._asignacionTrieniosLey18263 = facadeTrienio.obtenerAsignacionTrieniosLey18263(this._sueldoBaseLey18263, this._porcentajeTrienios);
        this._asignacionTrieniosLey18694 = facadeTrienio.obtenerAsignacionTrieniosLey18694(this._sueldoBaseLey18694, this._porcentajeTrienios);
        
        //S012
        asignacionTrieniosLey18263.value = this._asignacionTrieniosLey18263;
        System.out.println("TRIENIOS LEY 18263 : "+ asignacionTrieniosLey18263.value);
        
        //S013
        asignacionTrieniosLey18694.value = this._asignacionTrieniosLey18694;
        System.out.println("TRIENIOS LEY 18694 : "+ asignacionTrieniosLey18694.value);
        
        
        this._porcentajeSobresueldo = Util.obtenerValorPorcentual(porcentajeDeSobresueldo);
        this._porcentajeSegundoSobresueldo = Util.obtenerValorPorcentual(porcentajeDeSegundoSobresueldo);
        
        if(this._porcentajeSegundoSobresueldo > this._porcentajeSobresueldo){
                int constante = this._porcentajeSegundoSobresueldo;
                
                this._porcentajeSegundoSobresueldo = this._porcentajeSobresueldo;
                this._porcentajeSobresueldo = constante;
        }
                
        
        //S020
        porcentajeSobresueldo.value = this._porcentajeSobresueldo + "%";
        System.out.println("PORCENTAJE DE SOBRESUELDO : "+ porcentajeSobresueldo.value);
        
        this._sobresueldoLey18263 = (int) Math.round((this._sueldoBaseLey18263 * this._porcentajeSobresueldo)/100.0);
        this._sobresueldoLey18694 = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeSobresueldo)/100.0);
        
        //S021
        sobresueldoLey18263.value = this._sobresueldoLey18263;
        System.out.println("SOBRESUELDO LEY 18263 : "+ sobresueldoLey18263.value);
        
        //S022
        sobresueldoLey18694.value = this._sobresueldoLey18694;
        System.out.println("SOBRESUELDO LEY 18694 : "+ sobresueldoLey18694.value);
        
        //S023
        this._porcentajeBonifMandoAdministracion = facadeBonificacion.obtenerPorcentajeBonifMandoAdministracion(this._gradoJerarquico, this._idTipoDePersonal, this._fechaDeBaja);
        porcentajeBonifMandoAdministracion.value = this._porcentajeBonifMandoAdministracion + "%";
        System.out.println("PORCENTAJE BONIF MANDO Y ADM : "+ porcentajeBonifMandoAdministracion.value);
        
        this._bonifMandoAdministracionLey18263 = (int) Math.round((this._sueldoBaseLey18263 * this._porcentajeBonifMandoAdministracion)/100.0);
        this._bonifMandoAdministracionLey18694 = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeBonifMandoAdministracion)/100.0);
        //S024
        bonifMandoAdministracionLey18263.value = this._bonifMandoAdministracionLey18263;
        System.out.println("BONIF MANDO Y ADM LEY 18263 : "+ bonifMandoAdministracionLey18263.value);
        
        //S025
        bonifMandoAdministracionLey18694.value = this._bonifMandoAdministracionLey18694;
        System.out.println("BONIF MANDO Y ADM LEY 18694 : "+ bonifMandoAdministracionLey18694.value);
        
        //S026
        this._porcentajeBonifAltoMando = facadeBonificacion.obtenerPorcentajeBonifAltoMando(this._gradoJerarquico, this._idTipoDePersonal, this._fechaDeBaja, this._esDeLinea);
        porcentajeBonifAltoMando.value = this._porcentajeBonifAltoMando + "%";
        System.out.println("PORCENTAJE BONIF ALTO MANDO : "+ porcentajeBonifAltoMando.value);
        
        this._bonifAltoMandoLey18263 = (int) Math.round((this._sueldoBaseLey18263 * this._porcentajeBonifAltoMando)/100.0);
        this._bonifAltoMandoLey18694 = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeBonifAltoMando)/100.0);
        
        //S027
        bonifAltoMandoLey18263.value = this._bonifAltoMandoLey18263;
        System.out.println("BONIF ALTO MANDO LEY 18263 : "+ bonifAltoMandoLey18263.value);
        
        //S028
        bonifAltoMandoLey18694.value = this._bonifAltoMandoLey18694;
        System.out.println("BONIF ALTO MANDO LEY 18694 : "+ bonifAltoMandoLey18694.value);
        
        //S035
        
        if(Util.isNumber(planillaSuplementariaLey19699))
                this._gradoPlanillaSuplLey19699 = Integer.parseInt(planillaSuplementariaLey19699);
        
        if(this._gradoPlanillaSuplLey19699 > 0 && this._gradoPlanillaSuplLey19699 <= 14){        
                aplicaPlanillaSuplementaria.value = EnumPalabrasLogicas.SI.toString();
                this._planillaSuplementariaLey19699Actual = facadeCompensacion.obtenerPlanillaSuplementariaLey19699Actual(this._gradoPlanillaSuplLey19699, this._idReajusteAaplicar);
                this._planillaSuplementariaLey19699Anio1981 = facadeCompensacion.obtenerPlanillaSuplementariaLey19699anio1981(this._planillaSuplementariaLey19699Actual, this._fechaDeBaja);
        }
        else{
                aplicaPlanillaSuplementaria.value = EnumPalabrasLogicas.NO.toString();
                this._planillaSuplementariaLey19699Actual = 0;
                this._planillaSuplementariaLey19699Anio1981 = 0;
        }
        System.out.println("APLICA PLANILLA SUPL : "+ aplicaPlanillaSuplementaria.value);
        
        //S036
        planillaSuplementariaLey19699Actual.value = this._planillaSuplementariaLey19699Actual;
        System.out.println("PLANILLA SUPL LEY 19699 AÑO ACTUAL : "+ planillaSuplementariaLey19699Actual.value);
        
        //S037
        planillaSuplementariaLey19699Anio1981.value = this._planillaSuplementariaLey19699Anio1981;
        System.out.println("PLANILLA SUPL LEY 19699 AÑO 1981 : "+ planillaSuplementariaLey19699Anio1981.value);
        
        
        this._porcentajeAsignacionSOM = Util.obtenerValorPorcentual(porcentajeDeAsignacionSOFSOM);
        
        if(this._porcentajeAsignacionSOM == 35){
                this._porcentajeAsignacionSOMimponible = this._porcentajeAsignacionSOM;
                this._asignacionSOMLey18263 = (int) Math.round((this._sueldoBaseLey18263 * this._porcentajeAsignacionSOM)/100.0);
            this._asignacionSOMLey18694 = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeAsignacionSOM)/100.0); 
        }
        else{
                this._porcentajeAsignacionSOMimponible = 0;
                this._asignacionSOMLey18263 = 0;
            this._asignacionSOMLey18694 = 0;
        }
        
        //S038
        porcentajeAsignacionSOM.value = this._porcentajeAsignacionSOMimponible + "%";
        System.out.println("PORCENTAJE ASIG SOM : "+ porcentajeAsignacionSOM.value);
        
        //S039
        asignacionSOMLey18263.value = this._asignacionSOMLey18263;
        System.out.println("ASIG SOM LEY 18263 : "+ asignacionSOMLey18263.value);
        
        //S040
        asignacionSOMLey18694.value = this._asignacionSOMLey18694; 
        System.out.println("ASIG SOM LEY 18694 : "+ asignacionSOMLey18694.value);
        
        
        
        
        if(poseeAsigMinistroDeCorte.equalsIgnoreCase(EnumPalabrasLogicas.SI) || poseeAsigMinistroDeCorte.equalsIgnoreCase(EnumPalabrasLogicas.SIacento)){
                this._esMinistroDeCorte = true;
                this._porcentajeMinistroDeCorte = 15;
                this._sueldoMinistroDeCorte = sueldoIntegroMinistroDeCorte;
        }
        else{
                this._esMinistroDeCorte = false;
                this._porcentajeMinistroDeCorte = 0;
                this._sueldoMinistroDeCorte = 0;
        }
        
        //S041
        porcentajeAsigMinistroDeCorte.value = this._porcentajeMinistroDeCorte + "%";
        System.out.println("PORCENTAJE MINISTRO DE CORTE : "+ porcentajeAsigMinistroDeCorte.value);
        
        if(this._esMinistroDeCorte){
                this._asigMinistroDeCorteLey18694 = facadeAsignacion.obtenerAsignacionMinistroDeCorteLey18694(this._sueldoMinistroDeCorte,  this._porcentajeMinistroDeCorte);
                this._asigMinistroDeCorteLey18263 = facadeAsignacion.obtenerAsignacionMinistroDeCorteLey18263(this._asigMinistroDeCorteLey18694, this._fechaDeBaja);            
        }
        else{
                this._asigMinistroDeCorteLey18263 = 0;
                this._asigMinistroDeCorteLey18694 = 0;
        }
                
        //S042
        asigMinistroDeCorteLey18263.value = this._asigMinistroDeCorteLey18263;
        System.out.println("MINISTRO DE CORTE LEY 18263 : "+ asigMinistroDeCorteLey18263.value);
        
        //S043
        asigMinistroDeCorteLey18694.value = this._asigMinistroDeCorteLey18694;
        System.out.println("MINISTRO DE CORTE LEY 18694 : "+ asigMinistroDeCorteLey18694.value);
        
        
        //S044
        poseeTituloProf.value = operacionDeNegocio.obtenerTipoDeTituloProf(escalafonCivil);
        System.out.println("POSEE TITULO PROF : "+ poseeTituloProf.value);
        
        this._aegeLey18263 = facadeAsignacion.obtenerAEGELey18263(this._gradoJerarquico, this._aniosDesahucio, this._idTipoDePersonal);
        this._aegeLey18694 = facadeAsignacion.obtenerAEGELey18694(this._idReajusteAaplicar, this._aniosDesahucio, this._idEspecificacionGrado);
       
        //S045
        aegeLey18263.value = this._aegeLey18263;
        System.out.println("AEGE Ley 18263 : "+ aegeLey18263.value);
        
        //S046
        aegeLey18694.value = this._aegeLey18694;
        System.out.println("AEGE Ley 18694 : "+ aegeLey18694.value);
        
        
        this._totalLey18263 = this._sueldoBaseLey18263 + this._asignacionTrieniosLey18263 + this._sobresueldoLey18263 + this._bonifMandoAdministracionLey18263 + this._bonifAltoMandoLey18263 + this._planillaSuplementariaLey19699Anio1981 + this._asignacionSOMLey18263 + this._asigMinistroDeCorteLey18263 + this._aegeLey18263;
        
        this._totalParaDesahucio = this._sueldoBaseLey18694 + this._asignacionTrieniosLey18694 + this._sobresueldoLey18694 + this._bonifMandoAdministracionLey18694 + this._bonifAltoMandoLey18694 + this._planillaSuplementariaLey19699Actual + this._asignacionSOMLey18694 + this._asigMinistroDeCorteLey18694 + this._aegeLey18694;
        
        //S047
        totalLey18263.value = this._totalLey18263;
        System.out.println("TOTAL LEY 18263 : "+ totalLey18263.value);
        
        //S048
        totalParaDesahucio.value = this._totalParaDesahucio;
        System.out.println("TOTAL PARA DESAHUCIO : "+ totalParaDesahucio.value);
        
        
        //S049
        cantidadAVOS.value = facadeAvo.obtenerCantidadAvos(this._aniosEfectivosAbonosConcurrencias, this._mesesEfectivosAbonosConcurrencias);
        System.out.println("CANTIDAD AVOS : "+ cantidadAVOS.value);
        
        
        this._porcentajeAvos = facadeAvo.obtenerPorcentajeAvos(this._aniosEfectivosAbonosConcurrencias, this._mesesEfectivosAbonosConcurrencias);
        this._montoAvos = facadeAvo.obtenerMontoAvos(this._totalLey18263, this._porcentajeAvos);

        //S050
        montoAVOS.value = this._montoAvos;
        System.out.println("MONTO AVOS : "+ montoAVOS.value);
        
        
        //S051
        porcentajeAVOS.value = this._porcentajeAvos + "%";
        System.out.println("PORCENTAJE AVOS : "+ porcentajeAVOS.value);
        
        
        this._reajusteHasta8_8 = facadeReajuste.obtenerMontoReajusteHasta8_8(this._montoAvos);
        
        //S052
        reajusteHasta8_8.value = this._reajusteHasta8_8;
        System.out.println("REAJUSTE HASTA 8.8 : "+ reajusteHasta8_8.value);
        
        
        
        this._porcentajeReajusteDS376_1987 = facadeReajuste.obtenerPorcentajeReajusteDS376_1987(this._reajusteHasta8_8, 20);
        
        //S053
        porcentajeReajusteDS376_1987.value = this._porcentajeReajusteDS376_1987 + "%";
        System.out.println("PORCENTAJE REAJUSTE 376/987 : "+ porcentajeReajusteDS376_1987.value);
        
        this._montoReajusteDS376_1987 = facadeReajuste.obtenerMontoReajusteDS376_1987(this._reajusteHasta8_8, this._porcentajeReajusteDS376_1987);
        
        //S054
        montoReajusteDS376_1987.value = this._montoReajusteDS376_1987;
        System.out.println("MONTO REAJUSTE 376/987 : "+ montoReajusteDS376_1987.value);
        
        this._porcentajeReajusteDS321_1988 = facadeReajuste.obtenerPorcentajeReajusteDS321_1988(this._montoReajusteDS376_1987, 25);
        
        //S055
        porcentajeReajusteDS321_1988.value = this._porcentajeReajusteDS321_1988 + "%";
        System.out.println("PORCENTAJE REAJUSTE 321/988 : "+ porcentajeReajusteDS321_1988.value);
        
        this._montoReajusteDS321_1988 = facadeReajuste.obtenerMontoReajusteDS321_1988(this._montoReajusteDS376_1987, this._porcentajeReajusteDS321_1988);
        
        //S056
        montoReajusteDS321_1988.value = this._montoReajusteDS321_1988;
        System.out.println("MONTO REAJUSTE 321/988 : "+ montoReajusteDS321_1988.value);
        
      
        
        this._totalImponibleParcial = this._totalParaDesahucio + this._montoComponenteBase + this._montoIncrementoInstitucional + this._montoIncrementoColectivo;
        
        //S067
        totalImponibleParcial.value = this._totalImponibleParcial;
        System.out.println("TOTAL IMPONIBLE PARCIAL : "+ totalImponibleParcial.value);
        
        
        this._totalDesahucioSegunAvos = (int) Math.round((this._totalImponibleParcial * this._porcentajeAvos)/100.0);
        
        //S068
        totalDesahucioSegunAvos.value = this._totalDesahucioSegunAvos;
        System.out.println("TOTAL DESAHUCIO SEGUN AVOS : "+ totalDesahucioSegunAvos.value);
        
        
        this._totalImponible = this._totalImponibleParcial;
        
        //S069        
        totalImponible.value = this._totalImponible;
        System.out.println("TOTAL IMPONIBLE : "+ totalImponible.value);
        
        
        this._aegeNoImponible = facadeAsignacion.obtenerAEGEnoImponible(this._idReajusteAaplicar, this._aniosDesahucio, this._idEspecificacionGrado);
        
        //S070
        aegeNoImponible.value = this._aegeNoImponible;
        System.out.println("AEGE NO IMPONIBLE : "+ aegeNoImponible.value);

        
        //S071
        if(Util.isNumber(planillaSuplementariaDFL1_68))
                this._gradoPlanillaSuplDfl_1_68 = Integer.parseInt(planillaSuplementariaDFL1_68);
                
                
        if(this._gradoPlanillaSuplDfl_1_68 > 0 && this._gradoPlanillaSuplDfl_1_68 <= 20){
                recibePlanillaSuplementariaDfl_1_68.value = EnumPalabrasLogicas.SI.toString();
                this._planillaSuplementariaDfl_1_68 = facadeCompensacion.obtenerPlanillaSuplementariaDFL_1_68(this._gradoPlanillaSuplDfl_1_68);
        }
        else{
                recibePlanillaSuplementariaDfl_1_68.value = EnumPalabrasLogicas.NO.toString();
                this._planillaSuplementariaDfl_1_68 = 0;
        }
        System.out.println("APLICA PLANILLA SUPL DFL1/68: "+ recibePlanillaSuplementariaDfl_1_68.value);

        
        //S072
        planillaSuplementariaDfl_1_68.value = this._planillaSuplementariaDfl_1_68;
        System.out.println("PLANILLA SUPL DFL1/68: "+ planillaSuplementariaDfl_1_68.value);
        
        
        this._bonificacionCompensatoria = facadeCompensacion.obtenerBonificacionCompensatoria(this._porcentajeSobresueldo, this._idReajusteAaplicar, this._idEspecificacionGrado);
        
        //S073
        bonificacionCompensatoria.value = 0;
        System.out.println("BONIFICACION COMPENSATORIA: "+ bonificacionCompensatoria.value);
        
        
        this._tipoBonificacion = facadeBonificacion.obtenerTipoBonificacionRiesgoEspecial(this._tipoDePersonal);
        
        //S076
        tipoDeBonifRiesgoEspecial.value = this._tipoBonificacion;
        System.out.println("TIPO DE BONIFICACION RIESGO-ESPECIAL: "+ tipoDeBonifRiesgoEspecial.value);
        
        
        this._porcentajeBonifRiesgoEspecial = facadeBonificacion.obtenerPorcentajeBonificacionRiesgo(this._idReajusteAaplicar, this._idEspecificacionGrado);
        
        //S074
        porcentajeBonifRiesgoEspecial.value = this._porcentajeBonifRiesgoEspecial + "%";
        System.out.println("PORCENTAJE BONIFICACION RIESGO-ESPECIAL: "+ porcentajeBonifRiesgoEspecial.value);
        
        this._bonificacionRiesgoEspecial = facadeBonificacion.obtenerBonificacionRiesgo(this._idReajusteAaplicar, this._idEspecificacionGrado);
        
        //S075
        bonifRiesgoEspecial.value = this._bonificacionRiesgoEspecial;
        System.out.println("BONIFICACION RIESGO-ESPECIAL: "+ bonifRiesgoEspecial.value);
               
        
        if(this._esMinistroDeCorte){
                this._porcentajeMinistroDeCorteNoImp = 25;
        }
        else{
                this._porcentajeMinistroDeCorteNoImp = 0;
        }
                
        //S077
        porcentajeAsigMinDeCorteNoImp.value = this._porcentajeMinistroDeCorteNoImp + "%";
        System.out.println("PORCENTAJE MINISTRO DE CORTE NO IMPONIBLE: "+ porcentajeAsigMinDeCorteNoImp.value);
        
        
        this._asigMinistroDeCorteNoImp = facadeAsignacion.obtenerAsignacionMinistroDeCorteNoImponible(this._sueldoMinistroDeCorte);
        
        //S078
        asigMinistroDeCorteNoImp.value = this._asigMinistroDeCorteNoImp;
        System.out.println("ASIGNACION MINISTRO DE CORTE NO IMPONIBLE: "+ asigMinistroDeCorteNoImp.value);
        
              
        if(this._porcentajeAsignacionSOM == 35 || this._porcentajeAsignacionSOM == 0){
                this._porcentajeAsignacionSOMnoImp = 0;
                this._asignacionSOMnoImp = 0;
        }
        else{
                this._porcentajeAsignacionSOMnoImp = this._porcentajeAsignacionSOM;
                this._asignacionSOMnoImp = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeAsignacionSOMnoImp)/100.0);
        }
        
        //S079
        asignacionSOMnoImp.value = this._asignacionSOMnoImp;
        System.out.println("ASIGNACION SUFOFICIAL MAYOR NO IMPONIBLE: "+ asignacionSOMnoImp.value);
        
        //S080
        porcentajeAsigSOMnoImp.value = this._porcentajeAsignacionSOMnoImp + "%";
        System.out.println("PORCENTAJE SUFOFICIAL MAYOR NO IMPONIBLE: "+ porcentajeAsigSOMnoImp.value);
        
        
        //S084        
        porcentajeSegundoSobresueldo.value = this._porcentajeSegundoSobresueldo + "%";
        System.out.println("PORCENTAJE SEGUNDO SOBRESUELDO: "+ porcentajeSegundoSobresueldo.value);
        
        
        this._sobresueldoNoImp = (int) Math.round((this._sueldoBaseLey18694 * this._porcentajeSegundoSobresueldo)/100.0);
        
        //S083
        segundoSobresueldo.value = this._sobresueldoNoImp;
        System.out.println("SEGUNDO SOBRESUELDO: "+ segundoSobresueldo.value);
        
        this._totalRemuneracion = this._totalImponible + this._aegeNoImponible + this._planillaSuplementariaDfl_1_68 + 
                        this._bonificacionCompensatoria + this._bonificacionRiesgoEspecial + this._asigMinistroDeCorteNoImp + 
                        this._asignacionSOMnoImp + this._sobresueldoNoImp;
        
        //S085
        totalRemuneracion.value = this._totalRemuneracion;
        System.out.println("TOTAL REMUNERACION: "+ totalRemuneracion.value);
        
        
        this._totalRemuneracionSegunAVOS = (int) Math.round((this._totalRemuneracion * this._porcentajeAvos)/100.0);
                        
        //S086
        totalRemuneracionSegunAVOS.value = this._totalRemuneracionSegunAVOS;
        System.out.println("TOTAL REMUNERACION SEGUN AVOS: "+ totalRemuneracionSegunAVOS.value);
        
        UltimoReajustePasivoTO ultimoReajustePasivo = facadeReajuste.obtenerUltimoReajustePasivo(this._totalRemuneracionSegunAVOS, this._montoReajusteDS321_1988, this._fechaDeBaja);
        
        //S057
        tipoDocUltimoReajuste.value = ultimoReajustePasivo.getTipoDocumento();
        System.out.println("TIPO DE DOCUMENTO ULTIMO REAJUSTE: "+ tipoDocUltimoReajuste.value);
        
        //S058
        numeroDocUltimoReajuste.value = ultimoReajustePasivo.getNumeroDocumento();
        System.out.println("NUMERO DE DOCUMENTO ULTIMO REAJUSTE: "+ numeroDocUltimoReajuste.value);
        
        //S059
        porcentajeUltimoReajuste.value = ultimoReajustePasivo.getPorcentaje() + "%";
        System.out.println("PORCENTAJE ULTIMO REAJUSTE: "+ porcentajeUltimoReajuste.value);
        
        this._montoFinalOtrosReajustes = ultimoReajustePasivo.getMontoReajustado();
        
        //S060
        montoUltimoReajuste.value = this._montoFinalOtrosReajustes;
        System.out.println("MONTO ULTIMO REAJUSTE: "+ montoUltimoReajuste.value);
        
        
        this._pensionAotorgar = facadePension.obtenerPensionAotorgar(this._totalDesahucioSegunAvos, this._totalRemuneracionSegunAVOS, this._montoFinalOtrosReajustes);
        
        //S088
        pensionAotorgar.value = this._pensionAotorgar;
        System.out.println("PENSION A OTORGAR: "+ pensionAotorgar.value);
        
        //S0XX
        porcentajeAVOS2.value = this._porcentajeAvos + "%";
        System.out.println("PORCENTAJE AVOS 2 : "+ porcentajeAVOS2.value);
        
        this._mensajeTope = facadePension.obtenerMensajeTope(this._totalDesahucioSegunAvos, this._totalRemuneracionSegunAVOS, this._montoFinalOtrosReajustes);
        
        //S089
        conTopeSinTope.value = this._mensajeTope;
        System.out.println("MENSAJE TOPE: "+ conTopeSinTope.value);
            
        
        this._distribucionCapredena = this._totalDesahucioSegunAvos;
        this._distribucionTotal = this._pensionAotorgar;
        this._distribucionFisco = this._distribucionTotal - this._distribucionCapredena;
         
        //S090
        distribucionCapredena.value = this._distribucionCapredena;
        System.out.println("DISTRIBUCION CAPREDENA: "+ distribucionCapredena.value);
        
        
        //S091
        distribucionFisco.value = this._distribucionFisco;
        System.out.println("DISTRIBUCION  FISCO: "+ distribucionFisco.value);
        
        
        //S092
        distribucionTotal.value = this._distribucionTotal;
        System.out.println("DISTRIBUCION TOTAL: "+ distribucionTotal.value);
        
        
        this._mensualidadesDesahucio = operacionDeNegocio.obtenerMensualidadesDesahucio(this._aniosDesahucio, this._mesesDesahucio);
        
        //S093
        mensualidadesDesahucio.value = this._mensualidadesDesahucio;
        System.out.println("CANTIDAD MENSUALIDADES DESAHUCIO: "+ mensualidadesDesahucio.value);
        
      
        this._montoMensualidadDesahucio = this._totalParaDesahucio;
        
        //S094
        montoMensualidadDesahucio.value = this._montoMensualidadDesahucio;
        System.out.println("MONTO MENSUALIDADES DESAHUCIO: "+ montoMensualidadDesahucio.value);
        
        this._subtotalDesahucio = this._montoMensualidadDesahucio * this._mensualidadesDesahucio;
                        
        //S095
        subtotalDesahucio.value = this._subtotalDesahucio;
        System.out.println("SUBTOTAL DESAHUCIO: "+ subtotalDesahucio.value);
        
        
        if(Util.isNumber("" + cantidadDeAcciones)){
                this._cantidadAcciones = cantidadDeAcciones;
        }
        else{
                this._cantidadAcciones = 0;
        }
        
        //S096
        cantidadAcciones.value = this._cantidadAcciones;
        System.out.println("CANTIDAD DE ACCIONES: "+ cantidadAcciones.value);
        
        if(this._cantidadAcciones > 0){
                if(tipoDeAcciones.replaceAll(" ,.-_", "").equalsIgnoreCase(EnumTipoDeAcciones.CON_AEGE.replaceAll(" ,.-_", ""))){
                        this._montoUnitarioAcciones = this._montoMensualidadDesahucio;
                }
                else{
                        this._montoUnitarioAcciones = this._montoMensualidadDesahucio - this._aegeLey18694;
                }
        }
        else{
                this._montoUnitarioAcciones = 0;
        }
                
        //S097
        montoUnitarioAcciones.value = this._montoUnitarioAcciones;
        System.out.println("MONTO ACCIONES: "+ montoUnitarioAcciones.value);
        
        
        this._subtotalAcciones = this._montoUnitarioAcciones * this._cantidadAcciones;
        
        //S098
        subtotalAcciones.value = this._subtotalAcciones;
        System.out.println("SUBTOTAL ACCIONES: "+ subtotalAcciones.value);
        
        
        this._desahucioApagar = this._subtotalDesahucio - this._subtotalAcciones;
        
        //S099
        desahucioApagar.value = this._desahucioApagar;
        System.out.println("DESAHUCIO A PAGAR: "+ desahucioApagar.value);
        
        boolean aplicaTrienioAdicional = facadeTrienio.aplicaTrienioAdicional(this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
        
        if(aplicaTrienioAdicional){
                this._mesesSgteTrienio = facadeTrienio.obtenerMesesSiguienteTrienio(this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
                this._diasSgteTrienio = facadeTrienio.obtenerDiasSiguienteTrienio(this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
                this._siguienteTrienio = (this._aniosCPDNyConsc+1)%3;
        }
        else{
                this._mesesSgteTrienio = 0;
                this._diasSgteTrienio = 0;
                this._siguienteTrienio = 0;
        }
        //S100
        mesesSgteTrienio.value = this._mesesSgteTrienio;
        System.out.println("MESES SIGUIENTE TRIENIO: "+ mesesSgteTrienio.value);
        
        
        //S101
        diasSgteTrienio.value = this._diasSgteTrienio;
        System.out.println("DIAS SIGUIENTE TRIENIO: "+ diasSgteTrienio.value);
        
        
        //S102
        siguienteTrienio.value = this._siguienteTrienio;
        System.out.println("SIGUIENTE TRIENIO: "+ siguienteTrienio.value);
        
        
        
        
        this._instituciones = Grilla.concatenarValoresGrilla(otrasInstituciones, "Institución", ", ");
        
        if(this._instituciones.length() > 0){
                this._instituciones = this._instituciones + " y ";
        }
        this._instituciones = this._instituciones + institucion; 
                
        
        this._detallesDeServicio = facadeDetalleServicio.obtenerDetalleDeServicios(this._instituciones, this._detalleAbono, this._detalleConcurrencia, this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
        
        this._itemGrillaDetallesDeServicio = this._detallesDeServicio.getItemGrillaDetalleDeServicios();
        
        //detalleDeServicios.value = this._itemGrillaDetallesDeServicio;
        
        this._detalleDeServicios = facadeDetalleServicio.obtenerXmlDetalleDeServicios(this._instituciones, this._detalleAbono, this._detalleConcurrencia, this._aniosCPDNyConsc, this._mesesCPDNyConsc, this._diasCPDNyConsc);
	    detalleDeServicios.value = this._detalleDeServicios;
        
        aniosServiciosTotales.value = this._detallesDeServicio.getTotalAnios();
        mesesServiciosTotales.value = this._detallesDeServicio.getTotalMeses();
        diasServiciosTotales.value = this._detallesDeServicio.getTotalDias();
        enDiasServiciosTotales.value = this._detallesDeServicio.getTotalEnDias();
        proporcionServiciosTotales.value = this._detallesDeServicio.getTotalPorcentaje();
       
        
        for(int i = 0; i < this._itemGrillaDetallesDeServicio.length; i++)
                {
                        ItemGrillaWSTO itemGrilla = new ItemGrillaWSTO();
                        ItemColumnaWSTO listaItemColumna[] = new ItemColumnaWSTO[6];
                        
                        itemGrilla = this._itemGrillaDetallesDeServicio[i];
                        listaItemColumna = itemGrilla.getListaColumnas();
                        
                        String linea = "| \t";
                        
                        for(int j = 0; j < listaItemColumna.length; j++)
                        {
                                ItemColumnaWSTO itemColumna = new ItemColumnaWSTO();
                                itemColumna = listaItemColumna[j];
                                linea = linea + itemColumna.getValor();
                                linea = linea + "\t |";
                        }
                        System.out.println(linea);
                }       
        
        System.out.println("AÑOS SERVICIOS TOTALES: "+ aniosServiciosTotales.value);
        System.out.println("MESES SERVICIOS TOTALES: "+ mesesServiciosTotales.value);
        System.out.println("DIAS SERVICIOS TOTALES: "+ diasServiciosTotales.value);
        System.out.println("EN DIAS SERVICIOS TOTALES: "+ enDiasServiciosTotales.value);
        System.out.println("PROPORCION SERVICIOS TOTALES: "+ proporcionServiciosTotales.value);
        
        
        this._distribucionConcurrencia = facadeConcurrencia.obtenerDistribucionConcurrencia(this._detallesDeServicio.getServicios(), this._distribucionCapredena, this._detalleConcurrencia.getConcurrencias().size());
        
        this._itemGrillaDistribucionConcurrencia = this._distribucionConcurrencia.getItemGrillaDistribucionConcurrencia();
        
        for(int i = 0; i < this._itemGrillaDistribucionConcurrencia.length; i++)
                {
                        ItemGrillaWSTO itemGrilla = new ItemGrillaWSTO();
                        ItemColumnaWSTO listaItemColumna[] = new ItemColumnaWSTO[2];
                        
                        itemGrilla = this._itemGrillaDistribucionConcurrencia[i];
                        listaItemColumna = itemGrilla.getListaColumnas();
                        
                        String linea = "| \t";
                        
                        for(int j = 0; j < listaItemColumna.length; j++)
                        {
                                ItemColumnaWSTO itemColumna = new ItemColumnaWSTO();
                                itemColumna = listaItemColumna[j];
                                linea = linea + itemColumna.getValor();
                                linea = linea + "\t |";
                        }
                        System.out.println(linea);
                }       
        
        //detalleConcurrencias.value = this._itemGrillaDistribucionConcurrencia;
        
        this._detalleDeConcurrencias = facadeConcurrencia.obtenerXmlDistribucionConcurrencia(this._detallesDeServicio.getServicios(), this._distribucionCapredena, this._detalleConcurrencia.getConcurrencias().size());
        
        detalleConcurrencias.value = this._detalleDeConcurrencias;
        
        
        totalConcurrencias.value = this._distribucionConcurrencia.getTotal();
        
        DBMannager.close(c, true);   
        
    }

}
