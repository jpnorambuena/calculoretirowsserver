package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IBonificacion;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class BonificacionDB extends DBBase implements IBonificacion {

	public BonificacionDB(Connection c){
		this.conn = c;
	}
	
	@Override
	public int obtenerPorcentajeBonifMandoyAdm(int gradoJerarquico,
			int tipoDePersonal, Date fechaDeBaja) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT porcentaje_bonif" + 
						" FROM bonificacion_mando_admin" +
						" WHERE id_grado_jerarquico = ?" +
							" AND id_tipo_personal = ?" +
							" AND fecha_de_vigencia < ?" +
						" ORDER BY fecha_de_vigencia DESC limit 1;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoJerarquico);
			pstmt.setInt(2, tipoDePersonal);
			pstmt.setTimestamp(3, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("porcentaje_bonif");
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
	public int obtenerPorcentajeBonifAltoMando(int gradoJerarquico,
			int tipoDePersonal, Date fechaDeBaja) {

		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT porcentaje_bonif" + 
						" FROM bonificacion_alto_mando" +
						" WHERE id_grado_jerarquico = ?" +
							" AND id_tipo_personal = ?" +
							" AND fecha_de_vigencia < ?" +
						" ORDER BY fecha_de_vigencia DESC limit 1;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoJerarquico);
			pstmt.setInt(2, tipoDePersonal);
			pstmt.setTimestamp(3, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("porcentaje_bonif");
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
	public int obtenerPorcentajeBonificacionRiesgo(int idReajusteAaplicar,
			int idEspecificacionGrado) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT porcentaje_riesgo" + 
						" FROM reajuste_sector_activo" +
						" WHERE id_reajuste = ?" +
							" AND id_especificacion_grado = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idReajusteAaplicar);
			pstmt.setInt(2, idEspecificacionGrado);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("porcentaje_riesgo");
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
	public int obtenerBonificacionRiesgo(int idReajusteAaplicar,
			int idEspecificacionGrado) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT bonif_riesgo" + 
						" FROM reajuste_sector_activo" +
						" WHERE id_reajuste = ?" +
							" AND id_especificacion_grado = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idReajusteAaplicar);
			pstmt.setInt(2, idEspecificacionGrado);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("bonif_riesgo");
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
