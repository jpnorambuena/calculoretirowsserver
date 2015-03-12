package cl.ssffaa.calculoRetiroWS.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.ssffaa.calculoRetiroWS.util.UtilLog;


public class DBBase{
	
	protected Connection conn;
	
	protected int executeUpdate(PreparedStatement pstmt){
		int resp = -1;
		try
		{			
			resp = pstmt.executeUpdate();
			pstmt.close();
		}
		catch (SQLException sqle){
			UtilLog.registrar(sqle);
		}
		catch (Exception ex) {
			UtilLog.registrar(ex);
		}
		
		finally{
			if (pstmt != null) {
				try{
					pstmt.close();					
				} 
				catch (SQLException e) {
					UtilLog.registrar(e); 
					e.printStackTrace();
				}
			}
		}					
		return resp;
	}
	
	protected ResultSet executeQuery(PreparedStatement pstmt){
		ResultSet resp = null;
		try
		{			
			resp = pstmt.executeQuery();
		}
		catch (SQLException sqle){
			UtilLog.registrar(sqle);
		}
		catch (Exception ex) {
			UtilLog.registrar(ex);
		}		
		finally{
			if (pstmt != null) {
				try{
					pstmt.close();					
				} 
				catch (SQLException e) {
					UtilLog.registrar(e); 
					e.printStackTrace();
				}
			}
		}					
		return resp;
	}
}
