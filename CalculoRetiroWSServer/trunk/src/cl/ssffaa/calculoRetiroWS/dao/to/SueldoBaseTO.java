package cl.ssffaa.calculoRetiroWS.dao.to;

import java.io.Serializable;

public class SueldoBaseTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSueldoBase;
	private int idReajuste;
	private int idGrado;
	private int monto;
	
	public SueldoBaseTO(int idSueldoBase, int idReajuste, int idGrado, int monto){
		this.idSueldoBase = idSueldoBase;
		this.idReajuste = idReajuste;
		this.idGrado = idGrado;
		this.monto = monto;
	}
	
	public SueldoBaseTO(){
		super();
	}

	public int getIdSueldoBase() {
		return this.idSueldoBase;
	}

	public void setIdSueldoBase(int idSueldoBase) {
		this.idSueldoBase = idSueldoBase;
	}

	public int getIdReajuste() {
		return this.idReajuste;
	}

	public void setIdReajuste(int idReajuste) {
		this.idReajuste = idReajuste;
	}

	public int getIdGrado() {
		return this.idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public int getMonto() {
		return this.monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	
}
