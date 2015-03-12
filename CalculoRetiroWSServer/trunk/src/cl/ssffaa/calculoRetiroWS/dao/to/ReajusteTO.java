package cl.ssffaa.calculoRetiroWS.dao.to;

import java.io.Serializable;
import java.util.Date;

public class ReajusteTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReajuste;
	private String idUltimoUsuario;
	private String alias;
	private String tipoReajuste;
	private String tipoBeneficio;
	private Double porcentaje;
	private int monto;
	private String tipoDeCalculo;
	private Date fechaInicio;
	private String tipoDocumento;
	private String numeroDocumento;
	private Date fechaDocumento;
	private int version;
	private boolean esUltimaVersion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String numeroOrdenMinisterial;
	private Date fechaOrdenMinisterial;
	private boolean activo;
	private int idReajustePadre;
	
	public ReajusteTO(int idReajuste, String idUltimoUsuario, String alias,
			String tipoReajuste, String tipoBeneficio, Double porcentaje,
			int monto, String tipoDeCalculo, Date fechaInicio,
			String tipoDocumento, String numeroDocumento, Date fechaDocumento,
			int version, Boolean esUltimaVersion, Date fechaCreacion,
			Date fechaModificacion, String numeroOrdenMinisterial, 
			Date fechaOrdenMinisterial, boolean activo, int idReajustePadre) {

		this.idReajuste = idReajuste;
		this.idUltimoUsuario = idUltimoUsuario;
		this.alias = alias;
		this.tipoReajuste = tipoReajuste;
		this.tipoBeneficio = tipoBeneficio;
		this.porcentaje = porcentaje;
		this.monto = monto;
		this.tipoDeCalculo = tipoDeCalculo;
		this.fechaInicio = fechaInicio;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaDocumento = fechaDocumento;
		this.version = version;
		this.esUltimaVersion = esUltimaVersion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.numeroOrdenMinisterial = numeroOrdenMinisterial;
		this.fechaOrdenMinisterial = fechaOrdenMinisterial;
		this.activo = activo;
		this.idReajustePadre = idReajustePadre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ReajusteTO(){
		super();
	}

	public int getIdReajuste() {
		return idReajuste;
	}

	public void setIdReajuste(int idReajuste) {
		this.idReajuste = idReajuste;
	}

	public String getIdUltimoUsuario() {
		return idUltimoUsuario;
	}

	public void setIdUltimoUsuario(String idUltimoUsuario) {
		this.idUltimoUsuario = idUltimoUsuario;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTipoReajuste() {
		return tipoReajuste;
	}

	public void setTipoReajuste(String tipoReajuste) {
		this.tipoReajuste = tipoReajuste;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean getEsUltimaVersion() {
		return esUltimaVersion;
	}

	public void setEsUltimaVersion(boolean esUltimaVersion) {
		this.esUltimaVersion = esUltimaVersion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getTipoBeneficio() {
		return tipoBeneficio;
	}

	public void setTipoBeneficio(String tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	public String getTipoDeCalculo() {
		return tipoDeCalculo;
	}

	public void setTipoDeCalculo(String tipoDeCalculo) {
		this.tipoDeCalculo = tipoDeCalculo;
	}

	public String getNumeroOrdenMinisterial() {
		return numeroOrdenMinisterial;
	}

	public void setNumeroOrdenMinisterial(String numeroOrdenMinisterial) {
		this.numeroOrdenMinisterial = numeroOrdenMinisterial;
	}
	
	public Date getFechaOrdenMinisterial() {
		return fechaOrdenMinisterial;
	}

	public void setFechaOrdenMinisterial(Date fechaOrdenMinisterial) {
		this.fechaOrdenMinisterial = fechaOrdenMinisterial;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public int getIdReajustePadre() {
		return idReajustePadre;
	}

	public void setIdReajustePadre(int idReajustePadre) {
		this.idReajustePadre = idReajustePadre;
	}
}
