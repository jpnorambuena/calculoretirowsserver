package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ITrienio;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class TrienioDB extends DBBase implements ITrienio {

	public TrienioDB(Connection c) {
		this.conn = c;
	}
	
	@Override
	public int obtenerPorcentajeTrienios(int trienios, Date fechaDeBaja) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT porcentaje" +
						" FROM trienio" +
						" WHERE fecha_de_vigencia < ?" +
							" AND cantidad = ?" +
						" ORDER BY fecha_de_vigencia DESC limit 1;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(fechaDeBaja.getTime()));
			pstmt.setInt(2, trienios);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("porcentaje");
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
