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

public class TestWScalcularPorXml {

	public static void main(String[] args) {
		
String xmlInput = "";
		
		
		xmlInput = "<calcular>"+
	    "<run>16.023.917-4</run>"+
		"<institucion>FUERZA AÉREA</institucion>"+
		"<subInstitucion>FUERZA AÉREA</subInstitucion>"+
		"<categoria>OFICIAL (FA)</categoria>"+
		"<escalafonCivil></escalafonCivil>"+
		"<grado>CORONEL DE AVIACIÓN</grado>"+
		"<gradoJerarquico>4</gradoJerarquico>"+
		"<gradoEconomico>1</gradoEconomico>"+
		"<esDeLinea>NO</esDeLinea>"+
		"<fechaDeBaja>2015-01-31</fechaDeBaja>"+
		"<cantidadDeAcciones>10</cantidadDeAcciones>"+
		"<tipoDeAcciones>Con AEGE</tipoDeAcciones>"+
		"<porcentajeDeSobresueldo>21%</porcentajeDeSobresueldo>"+
		"<porcentajeDeSegundoSobresueldo>20%</porcentajeDeSegundoSobresueldo>"+
		"<porcentajeDeAsignacionSOFSOM>25%</porcentajeDeAsignacionSOFSOM>"+
		"<poseeAsigMinistroDeCorte>SI</poseeAsigMinistroDeCorte>"+
		"<sueldoIntegroMinistroDeCorte>100000</sueldoIntegroMinistroDeCorte>"+
		"<planillaSuplementariaLey19699>3</planillaSuplementariaLey19699>"+
		"<planillaSuplementariaDFL1_68>3</planillaSuplementariaDFL1_68>"+
		"<aniosCPDNyConsc>26</aniosCPDNyConsc>"+
		"<mesesCPDNyConsc>24</mesesCPDNyConsc>"+
		"<diasCPDNyConsc>33</diasCPDNyConsc>"+
		"<aniosDesahucio>19</aniosDesahucio>"+
		"<mesesDesahucio>15</mesesDesahucio>"+
		"<diasDesahucio>32</diasDesahucio>"+
		"<otrasInstituciones>"+
		"<institucion>Asmar</institucion>"+
		"<institucion>Carabineros</institucion>"+
		"<institucion>DGAC</institucion>"+
		"</otrasInstituciones>"+
		"<abonos>"+
		"<abono>"+
		"<tipo>Abono por hijos</tipo>"+
		"<anios>10</anios>"+
		"<meses>2</meses>"+
		"<dias>3</dias>"+
		"</abono>"+
		"<abono>"+
		"<tipo>Abono por viudez</tipo>"+
		"<anios>4</anios>"+
		"<meses>6</meses>"+
		"<dias>15</dias>"+
		"</abono>"+
		"<abono>"+
		"<tipo>Abono por lesiones</tipo>"+
		"<anios>4</anios>"+
		"<meses>1</meses>"+
		"<dias>25</dias>"+
		"</abono>"+
		"</abonos>"+
		"<concurrencias>"+
		"<concurrencia>"+
		"<tipo>Canaempu</tipo>"+
		"<anios>10</anios>"+
		"<meses>2</meses>"+
		"<dias>3</dias>"+
		"</concurrencia>"+
		"<concurrencia>"+
		"<tipo>Dipreca</tipo>"+
		"<anios>2</anios>"+
		"<meses>3</meses>"+
		"<dias>4</dias>"+
		"</concurrencia>"+
		"<concurrencia>"+
		"<tipo>Empart</tipo>"+
		"<anios>5</anios>"+
		"<meses>6</meses>"+
		"<dias>4</dias>"+
		"</concurrencia>"+
		"</concurrencias>"+
		"</calcular>";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2014-09-10";
		Date fechaDeBaja = new Date();

		try {
			fechaDeBaja = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		try {
			CalculoRetiroWS_ServiceLocator sl = new CalculoRetiroWS_ServiceLocator();
			
			CalculoRetiroWS_PortType ws = new CalculoRetiroWSSOAPStub(new URL(sl.getCalculoRetiroWSSOAPAddress()),sl);
			
			ws.calcularPorXml(xmlInput);
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		

	}

	
}
