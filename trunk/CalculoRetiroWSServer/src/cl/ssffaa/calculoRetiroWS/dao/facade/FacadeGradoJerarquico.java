package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.GradoJerarquicoDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IGradoJerarquico;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumCategoriasUnibox;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTiposDeAlerta;

public class FacadeGradoJerarquico {

	private Connection conn;
	
	public FacadeGradoJerarquico(Connection c){
		this.conn = c;
	}
	
	public int obtenerIdGradoJerarquico(int idTipoDePersonal, String institucion, String categoria, String grado, String escalafonCivil){
		
		int gradoJerarquico = -1;
		
		if(categoria.isEmpty() || categoria.equals("") || categoria == null){
			return gradoJerarquico;
		}
				
		if(categoria.contains(EnumCategoriasUnibox.CUADRO_PERMANENTE) || 
				categoria.contains(EnumCategoriasUnibox.GENTE_DE_MAR) || 
				categoria.contains(EnumCategoriasUnibox.OFICIAL) ){
			
			gradoJerarquico = this.obtenerIdGradoJerarquicoUniformado(institucion, grado);	 
		}
		else if(categoria.contains(EnumCategoriasUnibox.EMPLEADO_CIVIL)){
			return gradoJerarquico;
			
//			if(grado.contains(EnumGradosUnibox.CONTRATA) || 
//					grado.contains(EnumGradosUnibox.JORNAL) ||
//					grado.contains(EnumGradosUnibox.PLANTA) ){
//				
//				gradoJerarquico = 1;
//				
//				if(escalafonCivil.equalsIgnoreCase(EnumCiviles.DIREC) || 
//						escalafonCivil.equalsIgnoreCase(EnumCiviles.PROF)){
//					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_PROF_UNIV);	
//				}
//				else if(escalafonCivil.equalsIgnoreCase(EnumCiviles.TEC) || 
//						escalafonCivil.equalsIgnoreCase(EnumCiviles.ADM) ||
//						escalafonCivil.equalsIgnoreCase(EnumCiviles.AUX) ){
//					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_TEC_ADM_PLANTA_Y_CONTRATA);
//				}
//				else{
//					idTipoDePersonal = this.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVIL_GENERAL);
//				}
//			}
//			else{
//				UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "Empleado civil con un GRADO no soportado");
//			}
		}
		else{
			UtilLog.registrarAlerta(EnumTiposDeAlerta.ALERT, "X.XXX.XXX-X", "CATEGORIA diferente a las soportadas");
		}
		
		return gradoJerarquico;
	}


	int obtenerIdGradoJerarquicoUniformado(String institucion, String grado){
		
		int gradoJerarquico = -1;
		
		IGradoJerarquico gradoJerarquicoDB = new GradoJerarquicoDB(this.conn);
		
		try {
			gradoJerarquico = gradoJerarquicoDB.obtenerIdGradoJerarquicoUniformado(institucion, grado);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return gradoJerarquico;
	}
	
	int obtenerIdGradoJerarquicoCivil(String institucion, String grado){
		
		int gradoJerarquico = -1;
		
		IGradoJerarquico gradoJerarquicoDB = new GradoJerarquicoDB(this.conn);
		
		try {
			gradoJerarquico = gradoJerarquicoDB.obtenerIdGradoJerarquicoUniformado(institucion, grado);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return gradoJerarquico;
	}

	public int obtenerIdEspecificacionDeGrado(int gradoJerarquico, int idTipoDePersonal) {

		int idEspecificacionDeGrado = -1;
		
		IGradoJerarquico gradoJerarquicoDB = new GradoJerarquicoDB(this.conn);
		
		try {
			idEspecificacionDeGrado = gradoJerarquicoDB.obtenerIdEspecificacionDeGrado(gradoJerarquico, idTipoDePersonal);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return idEspecificacionDeGrado;
	}
	
}
