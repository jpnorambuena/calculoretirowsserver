package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.ReajusteDB;
import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.SueldoDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IReajuste;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ISueldo;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteSectorActivoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteTO;
import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;
import cl.ssffaa.calculoRetiroWS.dao.to.UltimoReajustePasivoTO;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoBeneficioReajuste;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoCalculoReajuste;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeReajuste;

public class FacadeReajuste {

	private Connection conn;
	
	public FacadeReajuste(Connection c){
		this.conn = c;
	}
	
	public int obtenerReajusteAaplicar(Date fechaBaja){
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int idReajuste = -1;
		try {
			idReajuste = reajusteDB.obtenerIdReajuste(fechaBaja);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return idReajuste;	
	}
	
	
	public int obtenerMontoReajusteHasta8_8(int montoAvos){
		
		int reajusteHasta8_8  = 0;
		
		reajusteHasta8_8 = (int) Math.round((montoAvos * 236.27) / 100.0);
		
		return reajusteHasta8_8;
	}


	public double obtenerPorcentajeReajusteDS376_1987(int reajusteHasta8_8, int edad){
		
		double porcentaje = 0.0;
		
		if(edad >= 65){
			if(reajusteHasta8_8 <= 17500){
				porcentaje = 18.05;
			}
			else{
				if(reajusteHasta8_8 > 17500 && reajusteHasta8_8 < 43500){
					porcentaje = 16.41;
				}
				else{
					if(reajusteHasta8_8 >= 43500 && reajusteHasta8_8 < 100000){
						porcentaje = 9.85;
					}
					else{
						porcentaje = 8.21;
					}
				}
			}
		}
		else{
			if(reajusteHasta8_8 > 0 &&  reajusteHasta8_8 < 43500){
				porcentaje = 16.41;
			}
			else{
				if(reajusteHasta8_8 >= 43500 && reajusteHasta8_8 < 100000){
					porcentaje = 9.85;
				}
				else{
					porcentaje = 8.21;
				}
			}
		}
		
		return porcentaje;
	}
	
	
	public int obtenerMontoReajusteDS376_1987(int reajusteHasta8_8, double porcentajeReajusteDS376_1987){
		
		int montoReajuste = 0;
		int monto = 0;
		
		monto = (int) Math.round((reajusteHasta8_8 * porcentajeReajusteDS376_1987)/100.0) + reajusteHasta8_8;
				
		if(porcentajeReajusteDS376_1987 == 18.05){
			montoReajuste = monto;
		}
		else{
			if(porcentajeReajusteDS376_1987 == 16.41){
				montoReajuste = monto;
			}
			else{
				if(porcentajeReajusteDS376_1987 == 9.85){
					if(monto <= 50638){
						montoReajuste = 50638;
					}
					else{
						montoReajuste = monto;
					}
				}
				else{	
					if(porcentajeReajusteDS376_1987 == 8.21){
						if(monto <= 109850){
							montoReajuste = 109850;
						}
						else{
							montoReajuste = monto;
						}
					}
					else{
						montoReajuste = 0;
					}
				}
			}
		}
		
		return montoReajuste;
	}
	

	public double obtenerPorcentajeReajusteDS321_1988(int montoReajusteDS376_1987, int edad){
		
		double porcentaje = 0.0;
		
		if(edad >= 65){
			if(montoReajusteDS376_1987 <= 19250){
				porcentaje = 17.49;
			}
			else{
				if(montoReajusteDS376_1987 > 19250 && montoReajusteDS376_1987 < 109850){
					porcentaje = 15.9;
				}
				else{
					porcentaje = 8.4;
				}
			}
		}
		else{
			if(montoReajusteDS376_1987 > 0 &&  montoReajusteDS376_1987 < 47850){
				porcentaje = 15.9;
			}
			else{
				if(montoReajusteDS376_1987 >= 47850 && montoReajusteDS376_1987 < 109850){
					porcentaje = 9.9;
				}
				else{
					porcentaje = 8.4;
				}
			}
		}
		
		return porcentaje;
	}

	
	public int obtenerMontoReajusteDS321_1988(int montoReajusteDS376_1987, double porcentajeReajusteDS321_1988){
		
		int montoReajuste = 0;
		int monto = 0;
		
		monto = (int) Math.round((montoReajusteDS376_1987 * porcentajeReajusteDS321_1988)/100.0) + montoReajusteDS376_1987;
		
		if(porcentajeReajusteDS321_1988 == 17.49){
			montoReajuste = monto;
		}
		else{
			if(porcentajeReajusteDS321_1988 == 15.9){
				montoReajuste = monto;
			}
			else{
				if(porcentajeReajusteDS321_1988 == 9.9){
					if(monto <= 55458){
						monto = 55458;
					}
					else{
						montoReajuste = monto;
					}
				}
				else{
					if(porcentajeReajusteDS321_1988 == 8.4){
						if(monto <= 120725){
							montoReajuste = 120725;
						}
						else{
							montoReajuste = monto;
						}
					}
					else{
						montoReajuste = 0;
					}
				}
			}
		}
		return montoReajuste;
	}

	
	public UltimoReajustePasivoTO obtenerUltimoReajustePasivo(int totalRemuneracionSegunAVOS, int montoReajusteDS321_1988, Date fechaDeBaja){
		
		UltimoReajustePasivoTO ultimoReajuste = new UltimoReajustePasivoTO();
		List<ReajusteTO> reajustes = new ArrayList<ReajusteTO>();
		int montoReajustado = montoReajusteDS321_1988;
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		reajustes = reajusteDB.obtenerReajustes(fechaDeBaja, EnumTipoDeReajuste.PASIVO);
		
		for (ReajusteTO reajuste : reajustes) {
			
			if(reajuste.getTipoBeneficio().equalsIgnoreCase(EnumTipoBeneficioReajuste.PORCENTUAL)){
				if(reajuste.getTipoDeCalculo().equalsIgnoreCase(EnumTipoCalculoReajuste.NORMAL)){
					montoReajustado = (int) Math.round((montoReajustado * reajuste.getPorcentaje())/100.0) + montoReajustado;
				}else if(reajuste.getTipoDeCalculo().equalsIgnoreCase(EnumTipoCalculoReajuste.ESPECIAL)){
					montoReajustado = this.obtenerCalculoReajusteEspecial(montoReajustado, reajuste.getPorcentaje());
				}				
			}else if(reajuste.getTipoBeneficio().equalsIgnoreCase(EnumTipoBeneficioReajuste.MONETARIO)){
				montoReajustado = montoReajustado + reajuste.getMonto();				
			}
			
			if(montoReajustado > totalRemuneracionSegunAVOS || reajustes.indexOf(reajuste) == reajustes.size()-1){
				ultimoReajuste.setIdReajuste(reajuste.getIdReajuste());
				ultimoReajuste.setAlias(reajuste.getAlias());
				ultimoReajuste.setTipoDocumento(reajuste.getTipoDocumento());
				ultimoReajuste.setNumeroDocumento(reajuste.getNumeroDocumento());
				ultimoReajuste.setTipoDeBeneficio(reajuste.getTipoBeneficio());
				ultimoReajuste.setPorcentaje(reajuste.getPorcentaje());
				ultimoReajuste.setMonto(reajuste.getMonto());
				ultimoReajuste.setMontoReajustado(montoReajustado);
				
				return ultimoReajuste;
			}
			
		}
		
		return ultimoReajuste;
	}
	
	
	public int obtenerCalculoReajusteEspecial(int monto, double porcentaje){
		
		if(monto >= 110000){
			return monto;
		}
		else{
			if(monto <= 100000){
				monto =  (int) Math.round((monto * porcentaje)/100.0) + monto;
			}
			else{
				monto = (int) Math.round((100000 * 10)/100.0) + 100000;
			}
		}
		
		return monto;
	}
	
	
	public List<ReajusteTO> obtenerReajustes(){
		List<ReajusteTO> listaReajustes = null;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		listaReajustes = reajusteDB.obtenerReajustes();
		
		return listaReajustes;
	}
	
	
	public List<ReajusteTO> obtenerTodosReajustes(){
		List<ReajusteTO> listaReajustes = null;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		listaReajustes = reajusteDB.obtenerTodosReajustes();
		
		return listaReajustes;
	}
	
	
	public int obtenerIdUltimoReajuste(String tipoDeReajuste){
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int idReajuste = -1;
		try {
			idReajuste = reajusteDB.obtenerIdUltimoReajuste(tipoDeReajuste);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return idReajuste;
	}
	
	public int obtenerIdUltimoReajuste(String tipoDeReajuste, Date fechaDeInicio, int idReajuste){
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int idUltimoReajuste = -1;
		try {
			idUltimoReajuste = reajusteDB.obtenerIdUltimoReajuste(tipoDeReajuste, fechaDeInicio, idReajuste);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return idUltimoReajuste;
	}
	
	
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivo(int idReajuste, String tipoDePersonal){
		List<ReajusteSectorActivoTO> listaValoresSectorActivo = null;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		listaValoresSectorActivo = reajusteDB.obtenerReajustesSectorActivo(idReajuste, tipoDePersonal);
		
		return listaValoresSectorActivo;
	}
	
	public List<ReajusteSectorActivoTO> obtenerTodosReajustesSectorActivo(int idReajuste){
		List<ReajusteSectorActivoTO> listaValoresSectorActivo = null;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		listaValoresSectorActivo = reajusteDB.obtenerTodosReajustesSectorActivo(idReajuste);
		
		return listaValoresSectorActivo;
	}
	
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivoSugerido(int idReajusteAnterior, String tipoDePersonal, ReajusteTO reajuste, List<SueldoBaseTO> listaSueldosBase){
		
		FacadeSueldoBase facadeSueldoBase = new FacadeSueldoBase(conn);
		
		HashMap<Integer, Integer> sueldosBase = facadeSueldoBase.generarHashMapSueldoBase(listaSueldosBase);
		
		List<ReajusteSectorActivoTO> listaValoresSectorActivo = null;
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		listaValoresSectorActivo = reajusteDB.obtenerReajustesSectorActivoSugerido(idReajusteAnterior, tipoDePersonal, reajuste, sueldosBase);
		
		return listaValoresSectorActivo;
	}
	
	public int validarExistenciaAlias(String alias){

		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int resp = reajusteDB.validarExistenciaAlias(alias);
		
		return resp;		
	}
	
	public int agregarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, List<ReajusteSectorActivoTO> reajustesSectorActivo){

		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int resp = reajusteDB.agregarReajusteSectorActivo(reajuste, sueldosBase, reajustesSectorActivo);
		
		return resp;		
	}
	
	public int modificarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, List<ReajusteSectorActivoTO> reajustesSectorActivo){

		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int resp = reajusteDB.modificarReajusteSectorActivo(reajuste, sueldosBase, reajustesSectorActivo);
		
		return resp;		
	}
	
	public int agregarReajusteSectorPasivo(ReajusteTO reajuste){

		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int resp = reajusteDB.agregarReajusteSectorPasivo(reajuste);
		
		return resp;		
	}
	
	public int modificarReajusteSectorPasivo(ReajusteTO reajuste){

		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		int resp = reajusteDB.modificarReajusteSectorPasivo(reajuste);
		
		return resp;		
	}
	
	public int activarDesactivarReajuste(ReajusteTO reajuste) throws Exception 
	{
		int resp = -1;
		
		boolean estadoAnterior = reajuste.getActivo();
		
		reajuste.setActivo(!estadoAnterior);
		if(reajuste.getTipoReajuste().equalsIgnoreCase(EnumTipoDeReajuste.ACTIVO)){
			List<ReajusteSectorActivoTO> listaValoresSectorActivo = null;
			IReajuste reajusteDB = new ReajusteDB(this.conn);
			
			listaValoresSectorActivo = reajusteDB.obtenerTodosReajustesSectorActivo(reajuste.getIdReajuste());
			
			if(listaValoresSectorActivo != null){
				List<SueldoBaseTO> listaSueldosBase = null;
				ISueldo sueldoDB = new SueldoDB(this.conn);
				
				listaSueldosBase = sueldoDB.obtenerSueldosBase(reajuste.getIdReajuste());
				
				if(listaSueldosBase != null)
					resp = this.modificarReajusteSectorActivo(reajuste, listaSueldosBase, listaValoresSectorActivo);
				else
					return -1;
			}
			else
				return -1;
		}
		else{
			resp = this.modificarReajusteSectorPasivo(reajuste);
		}
	
		if(resp < 0)
			throw new Exception("Error al activar/inactivar el reajuste");
		
		return resp;
	}
	
}
