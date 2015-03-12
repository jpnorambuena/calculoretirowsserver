package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.AvoDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IAvo;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class FacadeAvo {
	
	Connection conn;
	
	public FacadeAvo(Connection c){
		this.conn = c;
	}
	
	public double obtenerPorcentajeAvos(int anios, int meses){
		
		double porcentaje = 0.0;
		int mesesTotales = 0;
				
    	mesesTotales = anios * 12 + meses;
    	IAvo avoDB = new AvoDB(this.conn);
    	
    	if(meses >= 6){
    		anios++;
    		meses = 0;
    	}
    	    	
    	if(mesesTotales <= 0){
    		porcentaje = 0.0;
    	}
    	else if(mesesTotales >= 360){
    		porcentaje = 100;
    	}
    	else{
    		try {
				porcentaje = avoDB.obtenerPorcentajeAvos(anios, meses);
			} catch (Exception e) {
				UtilLog.registrar(e);
			}
		}
    	if(porcentaje < 0){
    		return 0;
    	}
    	else{
    		return porcentaje;
    	}
	}
	
	public String obtenerCantidadAvos(int anios, int meses){
		
		String valor = "";
		int mesesTotales = 0;
				
    	mesesTotales = anios * 12 + meses;
    	IAvo avoDB = new AvoDB(this.conn);
    	
    	if(meses >= 6){
    		anios++;
    		meses = 0;
    	}
    	    	
    	if(mesesTotales <= 0){
    		valor = "";
    	}
    	else if(mesesTotales >= 360){
    		valor = "30/30";
    	}
    	else{
    		try {
				valor = avoDB.obtenerCantidadAvos(anios, meses);
			} catch (Exception e) {
				UtilLog.registrar(e);
			}
		}
		return valor;
	}

	public int obtenerMontoAvos(int totalLey18263, double porcentajeAvos){
		
		int montoAvos = 0;
		
		montoAvos = (int) Math.round((totalLey18263 * porcentajeAvos)/100.0);
		
		return montoAvos;
	}
	
}
