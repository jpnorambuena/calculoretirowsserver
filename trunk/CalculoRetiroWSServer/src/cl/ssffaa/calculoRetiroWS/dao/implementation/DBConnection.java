package cl.ssffaa.calculoRetiroWS.dao.implementation;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cl.ssffaa.calculoRetiroWS.properties.Propiedades;


public class DBConnection{
	
	protected String jndiName = Propiedades.getProperty("JNDI_NAME");
	private static final Log log = LogFactory.getLog(DBConnection.class);
	protected Connection connection;
	
	
	public DBConnection(){
		this.connect();
	}
	
	/**
	 * Metodo que obtiene una conexion cualquiera desde el POOL de conexiones para JBoss.
	 * @param connectTo: nombre de la referencia al recurso JNDI que apunta al pool de conexiones deseada.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	public Connection getConnection(String jndiName){
			
	    Context ctx = null;
	    DataSource ds = null;
	    Connection conn = null;
	    
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiName);
		} catch (NamingException e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}			
		try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		this.connection = conn;
		return conn;
    }
	
	/**
	 * Metodo que obtiene una conexion a LOGIN desde el POOL de conexiones para JBoss.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	private Connection connect(){
			
	    Context ctx = null;
	    DataSource ds = null;
	    Connection conn = null;
	    
	    //this.connectTo = connectTo;
	    
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(this.jndiName);
		} catch (NamingException e) {
			//e.printStackTrace();
			log.fatal(e.getMessage());
		}			
		try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			//e.printStackTrace();
			log.fatal(e.getMessage());
		}
		this.connection = conn;
		return conn;
    }
	
	public void setAutoCommit(Boolean autoCommit){
		try {
			this.connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit(){
		try {
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback(){
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void close(){
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
}
