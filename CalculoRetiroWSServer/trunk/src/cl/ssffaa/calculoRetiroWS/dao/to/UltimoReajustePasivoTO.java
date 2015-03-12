package cl.ssffaa.calculoRetiroWS.dao.to;

import java.io.Serializable;

public class UltimoReajustePasivoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReajuste;
	private String alias;
	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoDeBeneficio;
	private Double porcentaje;	
	private int monto;
	private int montoReajustado;
	
	public UltimoReajustePasivoTO(int idReajuste, String alias,
			String tipoDocumento, String numeroDocumento,
			String tipoDeBeneficio, Double porcentaje, int monto,
			int montoReajustado) {
		
		this.idReajuste = idReajuste;
		this.alias = alias;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.tipoDeBeneficio = tipoDeBeneficio;
		this.porcentaje = porcentaje;
		this.monto = monto;
		this.montoReajustado = montoReajustado;
	}

	public UltimoReajustePasivoTO(){
		super();
	}
	
	public int getIdReajuste() {
		return idReajuste;
	}

	public void setIdReajuste(int idReajuste) {
		this.idReajuste = idReajuste;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDeBeneficio() {
		return tipoDeBeneficio;
	}

	public void setTipoDeBeneficio(String tipoDeBeneficio) {
		this.tipoDeBeneficio = tipoDeBeneficio;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getMontoReajustado() {
		return montoReajustado;
	}

	public void setMontoReajustado(int montoReajustado) {
		this.montoReajustado = montoReajustado;
	}
	
	
	
}
