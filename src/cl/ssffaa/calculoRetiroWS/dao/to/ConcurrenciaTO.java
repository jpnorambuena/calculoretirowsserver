package cl.ssffaa.calculoRetiroWS.dao.to;

public class ConcurrenciaTO {

	private String tipo;
	private int anios;
	private int meses; 
	private int dias;
	
	public ConcurrenciaTO( String tipo, int anios, int meses, int dias){
		this.tipo = tipo;
		this.anios = anios;
		this.meses = meses;
		this.dias = dias;
	}
	
	public ConcurrenciaTO(){
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
}
