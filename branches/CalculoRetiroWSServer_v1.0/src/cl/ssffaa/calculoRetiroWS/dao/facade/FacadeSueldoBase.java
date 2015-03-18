package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.ReajusteDB;
import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.SueldoDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IReajuste;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ISueldo;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteTO;
import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoBeneficioReajuste;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeReajuste;

public class FacadeSueldoBase {

	private Connection conn;
	
	public FacadeSueldoBase(Connection c){
		this.conn = c;
	}
	
	public int obtenerSueldo1981(int gradoEconomico){
		
		ISueldo sueldoDB = new SueldoDB(this.conn);
		
		int sueldo = -1;
		try {
			sueldo = sueldoDB.obtenerSueldo1981(gradoEconomico);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return sueldo;
	}
	
	public int obtenerSueldoEnActividad(int gradoEconomico, int idReajuste){
		
		int sueldo = -1;
		
		ISueldo sueldoDB = new SueldoDB(this.conn);
				
		if(idReajuste > 0){
			try {
				sueldo = sueldoDB.obtenerSueldoEnActividad(gradoEconomico, idReajuste);
			} catch (Exception e) {
				UtilLog.registrar(e);
			}
			if(sueldo > 0){
				return sueldo;
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}		
	}
	
	public List<SueldoBaseTO> obtenerSueldosBase(int idReajuste){
		
		List<SueldoBaseTO> listaSueldosBase = null;
		ISueldo sueldoDB = new SueldoDB(this.conn);
		
		listaSueldosBase = sueldoDB.obtenerSueldosBase(idReajuste);
		
		return listaSueldosBase;		
	}
	
	public List<SueldoBaseTO> obtenerSueldosBaseSugeridos(double porcentaje){
		
		int idUltimoReajuste = 1;
		List<SueldoBaseTO> listaSueldosBase = null;
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		idUltimoReajuste = reajusteDB.obtenerIdUltimoReajuste(EnumTipoDeReajuste.ACTIVO);
		
		ISueldo sueldoDB = new SueldoDB(this.conn);
		
		listaSueldosBase = sueldoDB.obtenerSueldosBase(idUltimoReajuste);
		
		return listaSueldosBase;		
	}
	
	public List<SueldoBaseTO> obtenerSueldosBaseSugeridos(ReajusteTO reajuste, int idUltimoReajuste){
		
		List<SueldoBaseTO> listaSueldosBase = null;
				
		ISueldo sueldoDB = new SueldoDB(this.conn);
		
		listaSueldosBase = sueldoDB.obtenerSueldosBase(idUltimoReajuste);
		
		if(listaSueldosBase != null && listaSueldosBase.size() > 0){
			for (SueldoBaseTO sueldoBaseTO : listaSueldosBase) {
				int nuevoMonto = 0;
				
				if(reajuste.getTipoBeneficio().equalsIgnoreCase(EnumTipoBeneficioReajuste.PORCENTUAL)){
					nuevoMonto = (int) Math.round((sueldoBaseTO.getMonto() * reajuste.getPorcentaje())/100.0) + sueldoBaseTO.getMonto();
				}
				else{
					nuevoMonto = (int) (sueldoBaseTO.getMonto() + reajuste.getMonto());
				}
				
				sueldoBaseTO.setMonto(nuevoMonto);
			}
		}
		
		return listaSueldosBase;		
	}
	
	public HashMap<Integer, Integer> generarHashMapSueldoBase(List<SueldoBaseTO> listaSueldosBase){
		
		HashMap<Integer, Integer> sueldosBase = new HashMap<Integer, Integer>();
		
		for (SueldoBaseTO sueldoBase : listaSueldosBase){
			sueldosBase.put(sueldoBase.getIdGrado(), sueldoBase.getMonto());
		}
		
		return sueldosBase;
	}
}
