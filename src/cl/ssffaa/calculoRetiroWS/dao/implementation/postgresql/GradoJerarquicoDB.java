package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IGradoJerarquico;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class GradoJerarquicoDB extends DBBase implements IGradoJerarquico {

	public GradoJerarquicoDB(Connection c){
		this.conn = c;
	}
	
	@Override
	public int obtenerIdGradoJerarquicoUniformado(String institucion, String grado) {
		
		int gradoJerarquico = -1;
		String query = "";
		
		if(institucion.equalsIgnoreCase("EJÉRCITO")){
			query = " SELECT id_grado_jerarquico"+
					   " FROM especificacion_grado_jerarquico" +
					   " WHERE nombre_ejercito = ?";
		}
		else if(institucion.equalsIgnoreCase("ARMADA")){
			query = " SELECT id_grado_jerarquico"+
					   " FROM especificacion_grado_jerarquico" +
					   " WHERE nombre_armada = ?";
		}
		else if(institucion.equalsIgnoreCase("FUERZA AÉREA")){
			query = " SELECT id_grado_jerarquico"+
					   " FROM especificacion_grado_jerarquico" +
					   " WHERE nombre_fuerza_aerea = ?";
		}
		else{
			return 0;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, grado);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				gradoJerarquico = rs.getInt("id_grado_jerarquico");
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return gradoJerarquico;
	}

	@Override
	public int obtenerIdEspecificacionDeGrado(int gradoJerarquico,
			int tipoDePersonal) {

		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT id_especificacion_grado" +
						" FROM especificacion_grado_jerarquico" + 
						" WHERE id_grado_jerarquico = ?" +
						" AND id_tipo_personal = ?;";
		
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoJerarquico);
			pstmt.setInt(2,tipoDePersonal);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("id_especificacion_grado");
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}

		return resp;
	}

	@Override
	public int obtenerIdGradoJerarquicoCivil(String institucion, String grado) {
		
		return 0;
	}	
	

}
