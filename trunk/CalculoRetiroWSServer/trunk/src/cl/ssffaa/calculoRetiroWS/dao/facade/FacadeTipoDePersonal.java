package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.TipoDePersonalDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ITipoDePersonal;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumCategoriasUnibox;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumCiviles;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumGradosUnibox;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTiposDeAlerta;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTiposDePersonal;

public class FacadeTipoDePersonal {

	private Connection conn;
	
	public FacadeTipoDePersonal(Connection c){
		this.conn = c;
	}
	
	
	public int obtenerIdTipoDePersonal(String categoria, String grado, String escalafonCivil){
		
		int idTipoDePersonal = -1;
		
		if(categoria.isEmpty() || categoria.equals("") || categoria == null){
			UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "CATEGORIA vacía o nula");
			return idTipoDePersonal;
		}
				
		if(categoria.contains(EnumCategoriasUnibox.CUADRO_PERMANENTE) || categoria.contains(EnumCategoriasUnibox.GENTE_DE_MAR)){
			idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CUADRO_PERMANENTE);	 
		}
		else if(categoria.contains(EnumCategoriasUnibox.OFICIAL)){
			idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.OFICIALES);	 
		}
		else if(categoria.contains(EnumCategoriasUnibox.EMPLEADO_CIVIL)){
			if(grado.contains(EnumGradosUnibox.CONTRATA) || 
					grado.contains(EnumGradosUnibox.JORNAL) ||
					grado.contains(EnumGradosUnibox.PLANTA) ){
				
				if(escalafonCivil.equalsIgnoreCase(EnumCiviles.DIREC) || 
						escalafonCivil.equalsIgnoreCase(EnumCiviles.PROF)){
					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_PROF_UNIV);	
				}
				else if(escalafonCivil.equalsIgnoreCase(EnumCiviles.TEC) || 
						escalafonCivil.equalsIgnoreCase(EnumCiviles.ADM) ||
						escalafonCivil.equalsIgnoreCase(EnumCiviles.AUX) ){
					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_TEC_ADM_PLANTA_Y_CONTRATA);
				}
				else{
					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVIL_GENERAL);
				}
			}
			else{
				UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "Empleado civil con un GRADO no soportado");
			}
		}
		else{
			UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "CATEGORIA diferente a las soportadas");
		}
		
		return idTipoDePersonal;
	}
	
	
	public int obtenerIdTipoDePersonal(String tipoDePersonal){
		
		int idTipoDePersonal = -1;
			
		ITipoDePersonal tipoDePersonalDB = new TipoDePersonalDB(this.conn);
		
		try {
			idTipoDePersonal = tipoDePersonalDB.obtenerIdTipoDePersonal(tipoDePersonal);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}	 
		
		return idTipoDePersonal;
	}
	
	public String obtenerTipoDePersonal(String categoria, String grado, String escalafonCivil){
		
		String tipoDePersonal = "";
		
		if(categoria.isEmpty() || categoria.equals("") || categoria == null){
			tipoDePersonal = "";
		}
				
		if(categoria.contains(EnumCategoriasUnibox.CUADRO_PERMANENTE) || categoria.contains(EnumCategoriasUnibox.GENTE_DE_MAR)){
			tipoDePersonal = EnumTiposDePersonal.CUADRO_PERMANENTE;	 
		}
		else if(categoria.contains(EnumCategoriasUnibox.OFICIAL)){
			tipoDePersonal = EnumTiposDePersonal.OFICIALES;	 
		}
		else if(categoria.contains(EnumCategoriasUnibox.EMPLEADO_CIVIL)){
			if(grado.contains(EnumGradosUnibox.CONTRATA) || 
					grado.contains(EnumGradosUnibox.JORNAL) ||
					grado.contains(EnumGradosUnibox.PLANTA) ){
				
				if(escalafonCivil.equalsIgnoreCase(EnumCiviles.DIREC) || 
						escalafonCivil.equalsIgnoreCase(EnumCiviles.PROF)){
					tipoDePersonal = EnumTiposDePersonal.CIVILES_PROF_UNIV;	
				}
				else if(escalafonCivil.equalsIgnoreCase(EnumCiviles.TEC) || 
						escalafonCivil.equalsIgnoreCase(EnumCiviles.ADM) ||
						escalafonCivil.equalsIgnoreCase(EnumCiviles.AUX) ){
					tipoDePersonal = EnumTiposDePersonal.CIVILES_TEC_ADM_PLANTA_Y_CONTRATA;
				}
				else{
					tipoDePersonal = EnumTiposDePersonal.CIVIL_GENERAL;
				}
			}
			else{
				UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "Empleado civil con un GRADO no soportado");
			}
		}
		else{
			UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "CATEGORIA diferente a las soportadas");
		}
		
		return tipoDePersonal;
	}
	
	
}
