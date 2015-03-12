package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ICompensacion;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;


public class CompensacionDB extends DBBase implements ICompensacion {

	public CompensacionDB(Connection c){
		this.conn = c;
	}

	@Override
	public int obtenerPlanillaSuplementariaDFL_1_68(int gradoPlanillaSuplementaria) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT valor" +
						" FROM planilla_supl_dfl_1_68" +
						" WHERE id_grado_economico = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gradoPlanillaSuplementaria);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("valor");
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
	public int obtenerBonificacionCompensatoriaConSobresueldo(int idReajusteAaplicar,
			int idEspecificacionGrado) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT bonif_comp_con_sob" + 
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
				resp = rs.getInt("bonif_comp_con_sob");
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
	public int obtenerBonificacionCompensatoriaSinSobresueldo(int idReajusteAaplicar,
			int idEspecificacionGrado) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT bonif_comp_sin_sob" + 
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
				resp = rs.getInt("bonif_comp_sin_sob");
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
