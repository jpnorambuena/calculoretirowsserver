package cl.ssffaa.calculoRetiroWS.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.DoubleHolder;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.AxisFault;

import cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWSSOAPStub;
import cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_PortType;
import cl.ssffaa.calculoRetiroWS.webServices.calculo.CalculoRetiroWS_ServiceLocator;

public class TestWScalcularPorParametros {

	public static void main(String[] args) {
		
		StringHolder grados = new StringHolder();
		IntHolder sueldoEnActividad = new IntHolder();
		IntHolder sueldo1981 = new IntHolder();
		IntHolder cantidadTrienios = new IntHolder();
		StringHolder porcentajeTrienios = new StringHolder();
		IntHolder asignacionTrieniosLey18263 = new IntHolder();
		IntHolder asignacionTrieniosLey18694 = new IntHolder();
		StringHolder porcentajeSobresueldo = new StringHolder();
		IntHolder sobresueldoLey18263 = new IntHolder();
		IntHolder sobresueldoLey18694 = new IntHolder();
		StringHolder porcentajeBonifMandoAdministracion = new StringHolder();
		IntHolder bonifMandoAdministracionLey18263 = new IntHolder();
		IntHolder bonifMandoAdministracionLey18694 = new IntHolder();
		StringHolder porcentajeBonifAltoMando = new StringHolder();
		IntHolder bonifAltoMandoLey18263 = new IntHolder();
		IntHolder bonifAltoMandoLey18694 = new IntHolder();
		StringHolder aplicaPlanillaSuplementaria = new StringHolder();
		IntHolder planillaSuplementariaLey19699Actual = new IntHolder();
		IntHolder planillaSuplementariaLey19699Anio1981 = new IntHolder();
		StringHolder porcentajeAsignacionSOM = new StringHolder();
		IntHolder asignacionSOMLey18263 = new IntHolder();
		IntHolder asignacionSOMLey18694 = new IntHolder();
		StringHolder porcentajeAsigMinistroDeCorte = new StringHolder();
		IntHolder asigMinistroDeCorteLey18263 = new IntHolder();
		IntHolder asigMinistroDeCorteLey18694 = new IntHolder();
		StringHolder poseeTituloProf = new StringHolder();
		IntHolder aegeLey18263 = new IntHolder();
		IntHolder aegeLey18694 = new IntHolder();
		IntHolder totalLey18263 = new IntHolder();
		IntHolder totalParaDesahucio = new IntHolder();
		
		StringHolder cantidadAVOS = new StringHolder();
		IntHolder montoAVOS = new IntHolder();
		StringHolder porcentajeAVOS = new StringHolder();
		IntHolder reajusteHasta8_8 = new IntHolder();
		StringHolder porcentajeReajusteDS376_1987 = new StringHolder();
		IntHolder montoReajusteDS376_1987 = new IntHolder();
		StringHolder porcentajeReajusteDS321_1988 = new StringHolder();
		IntHolder montoReajusteDS321_1988 = new IntHolder();
		StringHolder tipoDocUltimoReajuste = new StringHolder();
		StringHolder numeroDocUltimoReajuste = new StringHolder();
		StringHolder porcentajeUltimoReajuste = new StringHolder();
		IntHolder montoUltimoReajuste = new IntHolder();
		IntHolder totalImponibleParcial = new IntHolder();
		IntHolder totalDesahucioSegunAvos = new IntHolder();
		IntHolder totalImponible = new IntHolder();
		IntHolder aegeNoImponible = new IntHolder();
		StringHolder recibePlanillaSuplementariaDfl_1_68 = new StringHolder();
		IntHolder planillaSuplementariaDfl_1_68 = new IntHolder();
		IntHolder bonificacionCompensatoria = new IntHolder();
		StringHolder tipoDeBonifRiesgoEspecial = new StringHolder();
		StringHolder porcentajeBonifRiesgoEspecial = new StringHolder();
		IntHolder bonifRiesgoEspecial = new IntHolder();
		
		StringHolder porcentajeAsigMinDeCorteNoImp = new StringHolder();
		IntHolder asigMinistroDeCorteNoImp = new IntHolder();
		StringHolder porcentajeAsigSOMnoImp = new StringHolder();
		IntHolder asignacionSOMnoImp = new IntHolder();
		StringHolder porcentajeSegundoSobresueldo = new StringHolder();
		IntHolder segundoSobresueldo = new IntHolder();
		IntHolder totalRemuneracion = new IntHolder();
		IntHolder totalRemuneracionSegunAVOS = new IntHolder();
		StringHolder porcentajeAVOS2 = new StringHolder();
		IntHolder pensionAotorgar = new IntHolder();
		StringHolder conTopeSinTope = new StringHolder();
				
		IntHolder distribucionCapredena = new IntHolder();
		IntHolder distribucionFisco = new IntHolder();
		IntHolder distribucionTotal = new IntHolder();
		IntHolder mensualidadesDesahucio = new IntHolder();
		IntHolder montoMensualidadDesahucio = new IntHolder();
		IntHolder subtotalDesahucio = new IntHolder();
		IntHolder cantidadAcciones = new IntHolder();
		IntHolder montoUnitarioAcciones = new IntHolder();
		IntHolder subtotalAcciones = new IntHolder();
		IntHolder desahucioApagar = new IntHolder();
		IntHolder mesesSgteTrienio = new IntHolder();
		IntHolder diasSgteTrienio = new IntHolder();
		IntHolder siguienteTrienio = new IntHolder();
		StringHolder detalleDeServicios = new StringHolder();
		IntHolder aniosServiciosTotales = new IntHolder();
		IntHolder mesesServiciosTotales = new IntHolder();
		IntHolder diasServiciosTotales = new IntHolder();
		IntHolder enDiasServiciosTotales = new IntHolder();
		DoubleHolder proporcionServiciosTotales = new DoubleHolder();
		StringHolder distribucionConcurrencias = new StringHolder();
		IntHolder totalConcurrencias = new IntHolder();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2014-09-10";
		Date fechaDeBaja = new Date();

		try {
			fechaDeBaja = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		
		
		String run = "16.023.917-4";
		String institucion = "FUERZA AÉREA";
		String subInstitucion = "FUERZA AÉREA";
		String categoria = "OFICIAL(FA)";
		String escalafonCivil = "";
		String grado = "CORONEL DE AVIACIÓN";
		int gradoJerarquico = 4;
		int gradoEconomico = 1;
		String esDeLinea = "NO";
		
		int cantidadDeAcciones = 10; 
		String tipoDeAcciones = "Con AEGE";
		String porcentajeDeSobresueldo = "21%";
		String porcentajeDeSegundoSobresueldo = "20 %"; 
		String porcentajeDeAsignacionSOFSOM = "25%";
		String poseeAsigMinistroDeCorte = "SI";
		int sueldoIntegroMinistroDeCorte = 100000;
		String planillaSuplementariaLey19699 = "3";
		String planillaSuplementariaDFL1_68 = "3";
		int aniosCPDNyConsc = 26;
		int mesesCPDNyConsc = 24;
		int diasCPDNyConsc = 33;
		int aniosDesahucio = 19;
		int mesesDesahucio = 15;
		int diasDesahucio = 32;
		
		
		//xml
		
		String otrasInstituciones = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> "+
									"<grilla> "+
									"	<columna id=\"_Institucion\" titulo=\"Institución\" orden=\"1\" tipoDato=\"ALF\"> "+
									"		<valor orden=\"0\" tipoDato=\"null\">Asmar</valor> "+
									"		<valor orden=\"1\" tipoDato=\"null\">Carabineros</valor> "+ 
									"		<valor orden=\"2\" tipoDato=\"null\">DGAC</valor> "+
									"	</columna> "+
									"</grilla>";
		
		String abonos = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> "+
									"<grilla>  "+
									"	<columna id=\"_Abono\" titulo=\"Abono\" orden=\"1\" tipoDato=\"ALF\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">Abono por hijos</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">Abono por viudez</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">Abono por lesiones</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\"> "+ 
									"		<valor orden=\"0\" tipoDato=\"null\">10</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">4</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">4</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">2</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">6</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">1</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">3</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">15</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">25</valor>  "+
									"	</columna> "+
									"</grilla>"; 
				
		String concurrencias = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  "+
								"<grilla>  "+
								"	<columna id=\"_Concurrencia\" titulo=\"Concurrencia\" orden=\"1\" tipoDato=\"ALF\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">Canaempu</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">Dipreca</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">Empart</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">10</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">2</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">5</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">2</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">3</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">6</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">3</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">4</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">4</valor>  "+
								"	</columna> "+
								"</grilla> ";
		
		
		
		try {
			CalculoRetiroWS_ServiceLocator sl = new CalculoRetiroWS_ServiceLocator();
			
			CalculoRetiroWS_PortType ws = new CalculoRetiroWSSOAPStub(new URL(sl.getCalculoRetiroWSSOAPAddress()),sl);
			
			ws.calcularPorParametros(run, institucion, subInstitucion, categoria, escalafonCivil, grado, gradoJerarquico, gradoEconomico, esDeLinea, fechaDeBaja, cantidadDeAcciones, tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, sueldoIntegroMinistroDeCorte, planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc, aniosDesahucio, mesesDesahucio, diasDesahucio, otrasInstituciones, abonos, concurrencias, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, porcentajeAVOS2, pensionAotorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio, detalleDeServicios, aniosServiciosTotales, mesesServiciosTotales, diasServiciosTotales, enDiasServiciosTotales, proporcionServiciosTotales, distribucionConcurrencias, totalConcurrencias);
			
			//ws.calcular(run, institucion, subInstitucion, categoria, escalafonCivil, grado, gradoJerarquico, gradoEconomico, esDeLinea, fechaDeBaja, cantidadDeAcciones, tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, sueldoIntegroMinistroDeCorte, planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc, aniosDesahucio, mesesDesahucio, diasDesahucio, otrasInstituciones, abonos, concurrencias, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, porcentajeAVOS2, pensionAotorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio, detalleDeServicios, aniosServiciosTotales, mesesServiciosTotales, diasServiciosTotales, enDiasServiciosTotales, proporcionServiciosTotales);
			//ws.calcular(run, institucion, subInstitucion, categoria, escalafonCivil, grado, gradoJerarquico, gradoEconomico, esDeLinea, fechaDeBaja, cantidadDeAcciones, tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, sueldoIntegroMinistroDeCorte, planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc, aniosDesahucio, mesesDesahucio, diasDesahucio, otrasInstituciones, abonos, concurrencias, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, porcentajeAVOS2, pensionAotorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio, detalleDeServicios);
			//ws.calcular(, , , , , "SI", 0, 1, fechaDeBaja, , , , , 3, 3, 26, 24, 33, 19, 15, 32, otrasInstituciones, abonos, concurrencias, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, pensionaOtorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio, detalleDeServicios);
			//ws.calcular("16.023.917-4", "FUERZA AÉREA", "FUERZA AÉREA", "OFICIAL(FA)", "COMANDANTE DE ESCUADRILLA", "SI", "", 1, fechaDeBaja, 10, "CORFO", "21%", "20 %", "25%", "SI", 100000, 3, 3, 26, 24, 33, 19, 15, 32, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, pensionaOtorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio);
			//ws.calcular("16.023.917-4", "FUERZA AÉREA", "FUERZA AÉREA", "OFICIAL(FA)", "COMANDANTE DE ESCUADRILLA", "SI", "", 1, fechaDeBaja, 10, "CORFO", "21%", "20 %", "25%", "SI", 100000, 3, 3, 26, 24, 33, 19, 15, 32, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajusteDS376_1987, montoReajusteDS376_1987, porcentajeReajusteDS321_1988, montoReajusteDS321_1988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponibleParcial, aegeNoImponible, recibePlanillaSuplementariaDfl_1_68, planillaSuplementariaDfl_1_68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeAsigMinDeCorteNoImp, asigMinistroDeCorteNoImp, porcentajeAsigSOMnoImp, asignacionSOMnoImp, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracionSegunAVOS, totalRemuneracionSegunAVOS, pensionaOtorgar, conTopeSinTope, distribucionCapredena, distribucionFisco, distribucionTotal, mensualidadesDesahucio, montoMensualidadDesahucio, subtotalDesahucio, cantidadAcciones, montoUnitarioAcciones, subtotalAcciones, desahucioApagar, mesesSgteTrienio, diasSgteTrienio, siguienteTrienio);
			//ws.calcular("16.023.917-4", "FUERZA AÉREA", "FUERZA AÉREA", "OFICIAL(FA)", "COMANDANTE DE ESCUADRILLA", "SI", "", 1, fechaDeBaja, 10, "CORFO", "21%", "20 %", "25%", "SI", 100000, 3, 3, 26, 24, 33, 19, 15, 32, grados, sueldoEnActividad, sueldo1981, cantidadTrienios, porcentajeTrienios, asignacionTrieniosLey18263, asignacionTrieniosLey18694, porcentajeSobresueldo, sobresueldoLey18263, sobresueldoLey18694, porcentajeBonifMandoAdministracion, bonifMandoAdministracionLey18263, bonifMandoAdministracionLey18694, porcentajeBonifAltoMando, bonifAltoMandoLey18263, bonifAltoMandoLey18694, aplicaPlanillaSuplementaria, planillaSuplementariaLey19699Actual, planillaSuplementariaLey19699Anio1981, porcentajeAsignacionSOM, asignacionSOMLey18263, asignacionSOMLey18694, porcentajeAsigMinistroDeCorte, asigMinistroDeCorteLey18263, asigMinistroDeCorteLey18694, poseeTituloProf, aegeLey18263, aegeLey18694, totalLey18263, totalParaDesahucio, cantidadAVOS, montoAVOS, porcentajeAVOS, reajusteHasta8_8, porcentajeReajuste376_987, montoReajuste376_987, porcentajeReajuste321_988, montoReajuste321_988, tipoDocUltimoReajuste, numeroDocUltimoReajuste, porcentajeUltimoReajuste, montoUltimoReajuste, totalImponibleParcial, totalDesahucioSegunAvos, totalImponible, aegeNoImponible, recibePlanillaSuplementariaDflG68, planillaSuplementariaDflG68, bonificacionCompensatoria, tipoDeBonifRiesgoEspecial, porcentajeBonifRiesgoEspecial, bonifRiesgoEspecial, porcentajeNoImpAsigMinDeCorte, asigNoImpMinistroDeCorte, porcentajeNoImpAsigSOM, asignacionNoImpSOM, porcentajeSegundoSobresueldo, segundoSobresueldo, totalRemuneracion, totalRemuneracionSegunAVOS, pensionaOtorgar, conTopeSinTope);
			
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	
}
