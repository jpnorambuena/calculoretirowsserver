package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ITipoDePersonal;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class TipoDePersonalDB extends DBBase implements ITipoDePersonal {

	public TipoDePersonalDB(Connection c){
		this.conn = c;
	}
	
	@Override
	public int obtenerIdTipoDePersonal(String tipoDePersonal) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT id_tipo_personal" +
						" FROM tipo_personal" +
						" WHERE tipo = ?;";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tipoDePersonal);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("id_tipo_personal");
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
