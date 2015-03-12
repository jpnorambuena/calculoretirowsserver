package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.AsignacionDB;
import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.ReajusteDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IAsignacion;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IReajuste;
import cl.ssffaa.calculoRetiroWS.util.Util;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeReajuste;

public class FacadeAsignacion {

	private Connection conn;
	
	public FacadeAsignacion(Connection c){
		this.conn = c;
	}
	
	
	public int obtenerAege(int idReajuste, int idEspecificacionGrado){
		
		int aege = -1;
		
		IAsignacion asignacionDB = new AsignacionDB(this.conn);
		
		try {
			aege = asignacionDB.obtenerMontoAege(idReajuste, idEspecificacionGrado);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return aege;

	}
	
	
	public int obtenerMontoAege1981(int gradoJerarquico, int idTipoDePersonal){
		
		int aege = -1;
		
		IAsignacion asignacionDB = new AsignacionDB(this.conn);
		
		try {
			aege = asignacionDB.obtenerMontoAege1981(gradoJerarquico, idTipoDePersonal);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		if(aege >= 0){
			return aege;
		}
		else{
			return 0;
		}
	}
	
//	public int obtenerMontoAege1981(int gradoJerarquico, String tipoDePersonal){
//		
//		int aege = -1;
//		
//		IAsignacion asignacionDB = new AsignacionDB(this.conn);
//		
//		try {
//			aege = asignacionDB.obtenerMontoAege1981(gradoJerarquico, tipoDePersonal);
//		} catch (Exception e) {
//			UtilLog.registrar(e);
//		}
//		
//		if(aege >= 0){
//			return aege;
//		}
//		else{
//			return 0;
//		}
//	}
	
	public int obtenerAsignacionMinistroDeCorteLey18694(int sueldoIntegro, int porcentajeMinistroDeCorte){
		
		int asignacionMinistroDeCorte = 0;
		int operacionTransitoria = 0;
		
		operacionTransitoria = (int) Math.round(sueldoIntegro * 0.4);
		asignacionMinistroDeCorte = (int) Math.round((operacionTransitoria * porcentajeMinistroDeCorte)/100.0);
		
		return asignacionMinistroDeCorte;
	}
	
	
	public int obtenerAsignacionMinistroDeCorteLey18263(int asigMinistroDeCorteLey18694, Date fechaDeBaja){
		
		List<Double> reajustes = new ArrayList<Double>();
		int asigMinistroDeCorteLey18263 = asigMinistroDeCorteLey18694;
		Double porcentaje = 0.0;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		
		reajustes = reajusteDB.obtenerPorcentajesDeReajustes(fechaDeBaja, EnumTipoDeReajuste.ACTIVO);
		
		for (Double reajuste : reajustes) {
			
			reajuste = Util.aproximacionNdecimales(reajuste,2);
			
			porcentaje = (reajuste + 100.0)/100.0;
			porcentaje = Util.aproximacionNdecimales(porcentaje, 3);
			
			asigMinistroDeCorteLey18263 = (int) Math.round(asigMinistroDeCorteLey18263/porcentaje);
		}
		
		if(asigMinistroDeCorteLey18263 >= 0 ){
			return asigMinistroDeCorteLey18263;
		}
		else{
			return 0;
		}
	}
	
	public int obtenerAsignacionMinistroDeCorteNoImponible(int sueldoIntegro){
		
		int asignacionMinistroDeCorte = 0;
		int operacionTransitoria = 0;
		        
		operacionTransitoria = (int) Math.round(sueldoIntegro * 0.4);
		asignacionMinistroDeCorte = (int) Math.round(operacionTransitoria * 0.85);
		
		return asignacionMinistroDeCorte;
	}

	public int obtenerAEGELey18263(int gradoJerarquico, int aniosDesahucio, int idTipoDePersonal){
		
		int aegeLey18263 = 0;
				
		if(aniosDesahucio >= 20 && idTipoDePersonal > 0){			
			aegeLey18263 = this.obtenerMontoAege1981(gradoJerarquico, idTipoDePersonal);
		}
		return aegeLey18263;
	}
	
	
	public int obtenerAEGELey18694(int idReajusteAaplicar, int aniosDesahucio, int idEspecificacionGrado){
		
		int aegeLey18694 = 0;
				
		if(aniosDesahucio >= 20 && idEspecificacionGrado > 0){
			aegeLey18694 = this.obtenerAege(idReajusteAaplicar, idEspecificacionGrado);
		}		
		return aegeLey18694;
	}
	
	
	public int obtenerAEGEnoImponible(int idReajuste, int aniosDesahucio, int idEspecificacionGrado){
		
		int aegeNoImponible = 0;
		
		if(aniosDesahucio < 20 && idEspecificacionGrado > 0){
			aegeNoImponible = this.obtenerAege(idReajuste, idEspecificacionGrado);
		}
		
		return aegeNoImponible;
	}
	
}
