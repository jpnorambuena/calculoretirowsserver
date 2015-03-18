package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IAvo;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class AvoDB extends DBBase implements IAvo {

	public AvoDB(Connection c) {
		this.conn = c;
	}
	
	@Override
	public double obtenerPorcentajeAvos(int anios, int meses) {
		double resp = 0.0;
		PreparedStatement pstmt = null;
		String query = " SELECT porcentaje" + 
						" FROM avo" +
						" WHERE anios = ?" +
						" AND meses = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, anios);
			pstmt.setInt(2, meses);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getDouble("porcentaje");
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
	public String obtenerCantidadAvos(int anios, int meses) {
		String resp = "";
		PreparedStatement pstmt = null;
		String query = " SELECT valor" + 
						" FROM avo" +
						" WHERE anios = ?" +
						" AND meses = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, anios);
			pstmt.setInt(2, meses);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getString("valor");
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
