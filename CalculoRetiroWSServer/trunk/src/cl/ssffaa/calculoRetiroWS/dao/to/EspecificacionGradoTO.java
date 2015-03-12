package cl.ssffaa.calculoRetiroWS.dao.to;

import java.io.Serializable;

public class EspecificacionGradoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEspecificacionGrado;
	private int idGradoEconomicoBase;
	private int idTipoDePersonal;
	private String tipoDePersonal;
	private int idGradoJerarquico;
	private String nombreEjercito;
	private String nombreArmada;
	private String nombreFuerzaAerea;
	
	public EspecificacionGradoTO(int idEspecificacionGrado,
			int idGradoEconomicoBase, int idTipoDePersonal, String tipoDePersonal,
			int idGradoJerarquico, String nombreEjercito, String nombreArmada,
			String nombreFuerzaAerea) {
		
		this.idEspecificacionGrado = idEspecificacionGrado;
		this.idGradoEconomicoBase = idGradoEconomicoBase;
		this.idTipoDePersonal = idTipoDePersonal;
		this.setTipoDePersonal(tipoDePersonal);
		this.idGradoJerarquico = idGradoJerarquico;
		this.nombreEjercito = nombreEjercito;
		this.nombreArmada = nombreArmada;
		this.nombreFuerzaAerea = nombreFuerzaAerea;
	}
	
	public EspecificacionGradoTO(){
		super();
	}

	public int getIdEspecificacionGrado() {
		return idEspecificacionGrado;
	}

	public void setIdEspecificacionGrado(int idEspecificacionGrado) {
		this.idEspecificacionGrado = idEspecificacionGrado;
	}

	public int getIdGradoEconomicoBase() {
		return idGradoEconomicoBase;
	}

	public void setIdGradoEconomicoBase(int idGradoEconomicoBase) {
		this.idGradoEconomicoBase = idGradoEconomicoBase;
	}

	public int getIdTipoDePersonal() {
		return idTipoDePersonal;
	}

	public void setIdTipoDePersonal(int idTipoDePersonal) {
		this.idTipoDePersonal = idTipoDePersonal;
	}

	public int getIdGradoJerarquico() {
		return idGradoJerarquico;
	}

	public void setIdGradoJerarquico(int idGradoJerarquico) {
		this.idGradoJerarquico = idGradoJerarquico;
	}

	public String getNombreEjercito() {
		return nombreEjercito;
	}

	public void setNombreEjercito(String nombreEjercito) {
		this.nombreEjercito = nombreEjercito;
	}

	public String getNombreArmada() {
		return nombreArmada;
	}

	public void setNombreArmada(String nombreArmada) {
		this.nombreArmada = nombreArmada;
	}

	public String getNombreFuerzaAerea() {
		return nombreFuerzaAerea;
	}

	public void setNombreFuerzaAerea(String nombreFuerzaAerea) {
		this.nombreFuerzaAerea = nombreFuerzaAerea;
	}

	public String getTipoDePersonal() {
		return tipoDePersonal;
	}

	public void setTipoDePersonal(String tipoDePersonal) {
		this.tipoDePersonal = tipoDePersonal;
	}
	
	
}
