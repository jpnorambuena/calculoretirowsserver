package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.Date;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.TrienioDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ITrienio;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;

public class FacadeTrienio {

	private Connection conn;
	
	public FacadeTrienio(Connection c){
		this.conn = c;
	}
	
	public int obtenerCantidadDeTrienios(int anios, int meses, int dias){
		
		if(dias >= 30){
			meses = meses + dias/30;
			dias = dias%30;
		}
		if(meses >= 12){
			anios = anios + meses/12;
			meses = meses%12;
		}
		if(meses >= 6){
			anios++;
		}
		int trienios = anios/3;
		
		return trienios;
		
	}
	
	public int obtenerPorcentajeTrienios(int trienios, Date fechaDeBaja){
		
		ITrienio trienioDB = new TrienioDB(this.conn);
		
		int porcentajeTrienios = -1;
		try {
			porcentajeTrienios = trienioDB.obtenerPorcentajeTrienios(trienios, fechaDeBaja);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		if(porcentajeTrienios >= 0){
			return porcentajeTrienios;
		}	
		else{
			return porcentajeTrienios;
		}
	}

	public int obtenerAsignacionTrieniosLey18263(int sueldoBaseLey18263, int porcentajeTrienios){
		
		int asignacionTrienios = (int) Math.round((sueldoBaseLey18263 * porcentajeTrienios)/100.0);
		
		return asignacionTrienios;
	}
	
	public int obtenerAsignacionTrieniosLey18694(int sueldoBaseLey18694, int porcentajeTrienios){
		
		int asignacionTrienios = (int) Math.round((sueldoBaseLey18694 * porcentajeTrienios)/100.0);
		
		return asignacionTrienios;
	}

	public boolean aplicaTrienioAdicional(int anios, int meses, int dias){
		
		if(dias >= 30){
			meses = meses + dias/30;
			dias = dias%30;
		}
		if(meses >= 12){
			anios = anios + meses/12;
			meses = meses%12;
		}
		
		if(anios%3 == 0){
			return false;
		}
		else{
			if(meses >= 6){
				if((anios+1)%3 == 0){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
	}
	
	public int obtenerMesesSiguienteTrienio(int anios, int meses, int dias){
			
		if(dias >= 30){
			meses = meses + dias/30;
			dias = dias%30;
		}
		if(meses >= 12){
			anios = anios + meses/12;
			meses = meses%12;
		}
		
		if(anios%3 == 0){
			return 0;
		}
		else{
			if(meses >= 6){
				if((anios+1)%3 == 0){
					return (11-meses);
				}
				else{
					return 0;
				}
			}
			else{
				return 0;
			}
		}
	}
	
	public int obtenerDiasSiguienteTrienio(int anios, int meses, int dias){
		
		if(dias >= 30){
			meses = meses + dias/30;
			dias = dias%30;
		}
		if(meses >= 12){
			anios = anios + meses/12;
			meses = meses%12;
		}
		
		if(anios%3 == 0){
			return 0;
		}
		else{
			if(meses >= 6){
				if((anios+1)%3 == 0){
					return (30-dias);
				}
				else{
					return 0;
				}
			}
			else{
				return 0;
			}
		}
	}
}
