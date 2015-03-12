package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IAsignacion;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class AsignacionDB extends DBBase implements IAsignacion {

	public AsignacionDB(Connection c){
		this.conn = c;
	}
	
	@Override
	public int obtenerMontoAege(int idReajuste, int idEspecificacionGrado) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT aege" + 
						" FROM reajuste_sector_activo" +
						" WHERE id_reajuste = ?" +
							" AND id_especificacion_grado = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idReajuste);
			pstmt.setInt(2, idEspecificacionGrado);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("aege");
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
	public int obtenerMontoAege1981(int gradoJerarquico, int idTipoDePersonal) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT aege" + 
						" FROM valores_1981" +
						" WHERE id_grado_jerarquico = ?" +
						" AND id_tipo_personal = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoJerarquico);
			pstmt.setInt(2, idTipoDePersonal);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("aege");
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
	public int obtenerMontoAege1981(int gradoJerarquico, String tipoDePersonal) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT aege" + 
						" FROM valores_1981 v, tipo_personal tp" +
						" WHERE v.id_grado_jerarquico = ?" +
						" AND v.id_tipo_personal = tp.id_tipo_personal" +
						" AND tp.tipo = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoJerarquico);
			pstmt.setString(2, tipoDePersonal);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("aege");
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

}
