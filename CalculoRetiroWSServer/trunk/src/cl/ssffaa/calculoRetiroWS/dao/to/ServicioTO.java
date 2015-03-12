package cl.ssffaa.calculoRetiroWS.dao.to;

public class ServicioTO {

	private String servicio;
	private String tipoDeServicio;
	private int anios = -1;
	private int meses = -1; 
	private int dias = -1;
	private int enDias = -1;
	private double porcentaje = -1;
	
	public ServicioTO( String servicio, String tipoDeServicio, int anios, int meses, int dias, int enDias, double porcentaje){
		this.servicio = servicio;
		this.tipoDeServicio = tipoDeServicio;
		this.anios = anios;
		this.meses = meses;
		this.dias = dias;
		this.enDias = enDias;
		this.porcentaje = porcentaje;
	}
	
	public ServicioTO(){
		super();
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getTipoDeServicio() {
		return tipoDeServicio;
	}

	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getEnDias() {
		return enDias;
	}

	public void setEnDias(int enDias) {
		this.enDias = enDias;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
