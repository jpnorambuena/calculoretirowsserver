package cl.ssffaa.calculoRetiroWS.dao.to;

import java.util.List;

public class DetalleAbonoTO {

	private List<AbonoTO> abonos;
	private int totalAnios;
	private int totalMeses; 
	private int totalDias;
	
	public DetalleAbonoTO( List<AbonoTO> abonos, int totalAnios, int totalMeses, int totalDias){
		this.abonos = abonos;
		this.totalAnios = totalAnios;
		this.totalMeses = totalMeses;
		this.totalDias = totalDias;
	}
	
	public DetalleAbonoTO(){
		super();
	}

	public List<AbonoTO> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<AbonoTO> abonos) {
		this.abonos = abonos;
	}

	public int getTotalAnios() {
		return totalAnios;
	}

	public void setTotalAnios(int totalAnios) {
		this.totalAnios = totalAnios;
	}

	public int getTotalMeses() {
		return totalMeses;
	}

	public void setTotalMeses(int totalMeses) {
		this.totalMeses = totalMeses;
	}

	public int getTotalDias() {
		return totalDias;
	}

	public void setTotalDias(int totalDias) {
		this.totalDias = totalDias;
	}

	
}
