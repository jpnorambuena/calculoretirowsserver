package cl.ssffaa.calculoRetiroWS.dao.to;

import java.io.Serializable;

public class ReajusteSectorActivoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReajusteActivo;
	private int idReajuste;
	private EspecificacionGradoTO especificacionGrado;
	private int aege;
	private int bonificacionRiesgo;
	private double porcentajeRiesgo;
	private int bonifMandoAdm;
	private int asigAltoMando;
	private int bonifCompConSobresueldo;
	private int bonifCompSinSobresueldo;
	
	public ReajusteSectorActivoTO(int idReajusteActivo, int idReajuste, EspecificacionGradoTO especificacionGrado, 
			int aege, int bonificacionRiesgo, double porcentajeRiesgo, 
			int bonifMandoAdm, int asigAltoMando, 
			int bonifCompConSobresueldo, int bonifCompSinSobresueldo){
		
		this.idReajusteActivo = idReajuste;
		this.idReajuste = idReajuste;
		this.especificacionGrado = especificacionGrado;
		this.aege = aege;
		this.bonificacionRiesgo = bonificacionRiesgo;
		this.porcentajeRiesgo = porcentajeRiesgo;
		this.bonifMandoAdm = bonifMandoAdm;
		this.asigAltoMando = asigAltoMando;
		this.bonifCompConSobresueldo = bonifCompConSobresueldo;
		this.bonifCompSinSobresueldo = bonifCompSinSobresueldo;
	}

	public ReajusteSectorActivoTO(){
		super();
	}
	
	public int getIdReajusteActivo() {
		return idReajusteActivo;
	}

	public void setIdReajusteActivo(int idReajusteActivo) {
		this.idReajusteActivo = idReajusteActivo;
	}

	public int getIdReajuste() {
		return idReajuste;
	}

	public void setIdReajuste(int idReajuste) {
		this.idReajuste = idReajuste;
	}

	public EspecificacionGradoTO getEspecificacionGrado() {
		return especificacionGrado;
	}

	public void setEspecificacionGrado(EspecificacionGradoTO especificacionGrado) {
		this.especificacionGrado = especificacionGrado;
	}

	public int getAege() {
		return aege;
	}

	public void setAege(int aege) {
		this.aege = aege;
	}

	public int getBonificacionRiesgo() {
		return bonificacionRiesgo;
	}

	public void setBonificacionRiesgo(int bonificacionRiesgo) {
		this.bonificacionRiesgo = bonificacionRiesgo;
	}

	public double getporcentajeRiesgo() {
		return porcentajeRiesgo;
	}

	public void setporcentajeRiesgo(double porcentajeRiesgo) {
		this.porcentajeRiesgo = porcentajeRiesgo;
	}

	public int getBonifMandoAdm() {
		return bonifMandoAdm;
	}

	public void setBonifMandoAdm(int bonifMandoAdm) {
		this.bonifMandoAdm = bonifMandoAdm;
	}

	public int getAsigAltoMando() {
		return asigAltoMando;
	}

	public void setAsigAltoMando(int asigAltoMando) {
		this.asigAltoMando = asigAltoMando;
	}

	public int getBonifCompConSobresueldo() {
		return bonifCompConSobresueldo;
	}

	public void setBonifCompConSobresueldo(int bonifCompConSobresueldo) {
		this.bonifCompConSobresueldo = bonifCompConSobresueldo;
	}

	public int getBonifCompSinSobresueldo() {
		return bonifCompSinSobresueldo;
	}

	public void setBonifCompSinSobresueldo(int bonifCompSinSobresueldo) {
		this.bonifCompSinSobresueldo = bonifCompSinSobresueldo;
	}

}
