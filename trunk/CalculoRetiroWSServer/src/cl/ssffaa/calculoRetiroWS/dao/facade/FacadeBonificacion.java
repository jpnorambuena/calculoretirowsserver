package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.Date;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.BonificacionDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IBonificacion;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTiposDePersonal;

public class FacadeBonificacion {

	private Connection conn;
	
	public FacadeBonificacion(Connection c){
		this.conn = c;
	}
	
	public int obtenerPorcentajeBonifMandoAdministracion(int gradoJerarquico, int tipoDePersonal, Date fechaDeBaja){
		
		IBonificacion bonificacionDB = new BonificacionDB(this.conn);
		
		int porcentajeBonifMandoAdministracion = -1;
		try {
			porcentajeBonifMandoAdministracion = bonificacionDB.obtenerPorcentajeBonifMandoyAdm(gradoJerarquico, tipoDePersonal, fechaDeBaja);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		if(porcentajeBonifMandoAdministracion >= 0){
			return porcentajeBonifMandoAdministracion;
		}	
		else{
			return 0;
		}
	}
	
	public int obtenerPorcentajeBonifAltoMando(int gradoJerarquico, int tipoDePersonal, Date fechaDeBaja, boolean esDeLinea){
		
		if(esDeLinea){
			IBonificacion bonificacionDB = new BonificacionDB(this.conn);
			
			int porcentajeBonifAltoMando = -1;
			try {
				porcentajeBonifAltoMando = bonificacionDB.obtenerPorcentajeBonifAltoMando(gradoJerarquico, tipoDePersonal, fechaDeBaja);
			} catch (Exception e) {
				UtilLog.registrar(e);
			}
			
			if(porcentajeBonifAltoMando >= 0){
				return porcentajeBonifAltoMando;
			}	
			else{
				return 0;
			}
	
		}
		else{
			return 0;
		}
	}
	
	public String obtenerTipoBonificacionRiesgoEspecial(String tipoDePersonal){
		
		if(tipoDePersonal.equalsIgnoreCase(EnumTiposDePersonal.OFICIALES) || 
				tipoDePersonal.equalsIgnoreCase(EnumTiposDePersonal.CUADRO_PERMANENTE) ||
				tipoDePersonal.equalsIgnoreCase(EnumTiposDePersonal.TROPA_PROFESIONAL)){
			return "RIESGO";
		}
		else{
			return "ESPECIAL";
		}
	}
	
	public int obtenerPorcentajeBonificacionRiesgo(int idReajusteAaplicar, int idEspecificacionGrado){
		
		IBonificacion bonificacionDB = new BonificacionDB(this.conn);
		
		int porcentajeBonificacionRiesgo = -1;
		
		try {
			porcentajeBonificacionRiesgo = bonificacionDB.obtenerPorcentajeBonificacionRiesgo(idReajusteAaplicar, idEspecificacionGrado);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		if(porcentajeBonificacionRiesgo >= 0){
			return porcentajeBonificacionRiesgo;
		}	
		else{
			return 0;
		}
	}
	
	public int obtenerBonificacionRiesgo(int idReajusteAaplicar, int idEspecificacionGrado){
		
		IBonificacion bonificacionDB = new BonificacionDB(this.conn);
		
		int bonificacionRiesgo = -1;
		
		try {
			bonificacionRiesgo = bonificacionDB.obtenerBonificacionRiesgo(idReajusteAaplicar, idEspecificacionGrado);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		if(bonificacionRiesgo >= 0){
			return bonificacionRiesgo;
		}	
		else{
			return 0;
		}
	}
}
