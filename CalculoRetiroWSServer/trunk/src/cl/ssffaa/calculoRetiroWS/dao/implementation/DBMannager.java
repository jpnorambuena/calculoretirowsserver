package cl.ssffaa.calculoRetiroWS.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cl.ssffaa.calculoRetiroWS.properties.Propiedades;



public class DBMannager {

	static protected String jndiName = Propiedades.getProperty("JNDI_NAME");
	private static final Log log = LogFactory.getLog(DBConnection.class);
	
		
	/**
	 * Metodo que obtiene una conexion a LOGIN desde el POOL de conexiones para JBoss.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	static public Connection getConnection(){	
			
	    Context ctx = null;
	    DataSource ds = null;
	    Connection conn = null;
	    	    
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiName);
		} catch (NamingException e) {
			log.fatal(e.getMessage());
		}			
		try {
			conn= ds.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			log.fatal(e.getMessage());
		}

		return conn;
    }
	
	static public void close(Statement stmt, ResultSet rs) throws SQLException{
		if (rs    != null) try { rs.close();    } catch (SQLException e) {System.out.println(e);}         
		if (stmt != null) try { stmt.close(); } catch (SQLException e) {System.out.println(e);}
	}
	
	static public void close(ResultSet rs, Statement stmt) throws SQLException{
		close(stmt,rs);
	}
	
	static public boolean closeOnSuccess(Connection connection){
		boolean ret = commit(connection);
		ret = close(connection) && ret;
		return ret;
	}
	
	static public boolean closeOnError(Connection connection){
		boolean ret = rollback(connection);
		ret = close(connection) && ret;
		return ret;
	}
	
	/**
	 * 
	 * Cierra la conección haciendo commit o rollback
	 * de acuerdo al valor de success. 
	 * success==true --> commit
	 * success==false--> rollback
	 * 
	 * 
	 * 
	 * @author German	 
	 * */
	
	static public boolean close(Connection connection, boolean success){
		if(success){
			return closeOnSuccess(connection);
		}else{
			return closeOnError(connection);
		}		
	}
	
	
	static protected boolean setAutoCommit(Connection connection, Boolean autoCommit){
		try {
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	static protected boolean commit(Connection connection){
		try {
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	static protected boolean rollback(Connection connection){
		try {
			connection.rollback();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
		
	static protected boolean close(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}		
		return true;
	}	
	
}
