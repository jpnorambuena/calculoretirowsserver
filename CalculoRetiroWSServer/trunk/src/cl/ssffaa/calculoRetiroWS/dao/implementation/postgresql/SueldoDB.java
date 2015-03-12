package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ISueldo;
import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class SueldoDB extends DBBase implements ISueldo {

	public SueldoDB(Connection c){
		this.conn = c;
	}
	
//	@Override
//	public int obtenerSueldoEnActividad(int grado_economico, Date fecha_de_baja) {
//		
//		int resp = -1;
//		PreparedStatement pstmt = null;
//		String query = " SELECT monto" +
//						" FROM sueldo_base" + 
//						" WHERE id_grado_economico = ?" +
//						" AND id_reajuste = 1;";
//		
//		ResultSet rs = null; 
//		
//		try{
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, grado_economico);
//			pstmt.setTimestamp(2, (java.sql.Timestamp) fecha_de_baja);
//			rs  = pstmt.executeQuery();
//			
//			if(rs.next()){				
//				resp = rs.getInt(0);
//			}
//			pstmt.close();
//			rs.close();
//		}
//		catch (SQLException sqle) {
//			UtilLog.registrar(sqle);
//		}
//		catch (Exception e) {
//			UtilLog.registrar(e);
//		}
//
//		return resp;
//	}

	@Override
	public int obtenerSueldo1981(int grado_economico) {
		
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT monto"+
					   " FROM sueldo_base_1981" +
					   " WHERE id_grado_economico = ?";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, grado_economico);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("monto");
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
	public int obtenerSueldoEnActividad(int grado_economico, int id_reajuste) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT monto" +
						" FROM sueldo_base" + 
						" WHERE id_grado_economico = ?" +
						" AND id_reajuste = ?;";
		
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, grado_economico);
			pstmt.setInt(2, id_reajuste);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("monto");
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
	public List<SueldoBaseTO> obtenerSueldosBase(int id_Reajuste) {
		
		List<SueldoBaseTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String query = "SELECT id_sueldo_base, id_reajuste, id_grado_economico, monto" +
		   " FROM sueldo_base" +
		   " WHERE id_reajuste = ?;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setInt(1, id_Reajuste);
			rs = pstmt.executeQuery();
			resp = new ArrayList<SueldoBaseTO>();

			while(rs.next()){
				SueldoBaseTO sueldoBase = new SueldoBaseTO();
				
				sueldoBase.setIdSueldoBase(rs.getInt("id_sueldo_base"));
				sueldoBase.setIdReajuste(rs.getInt("id_reajuste"));
				sueldoBase.setIdGrado(rs.getInt("id_grado_economico"));
				sueldoBase.setMonto(rs.getInt("monto"));
								
				resp.add(sueldoBase);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

}
