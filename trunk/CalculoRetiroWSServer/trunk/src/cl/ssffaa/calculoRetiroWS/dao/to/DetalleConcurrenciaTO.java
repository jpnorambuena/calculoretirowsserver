package cl.ssffaa.calculoRetiroWS.dao.to;

import java.util.List;

public class DetalleConcurrenciaTO {

	private List<ConcurrenciaTO> concurrencias;
	private int totalAnios;
	private int totalMeses; 
	private int totalDias;
	
	public DetalleConcurrenciaTO( List<ConcurrenciaTO> concurrencias, int totalAnios, int totalMeses, int totalDias){
		this.concurrencias = concurrencias;
		this.totalAnios = totalAnios;
		this.totalMeses = totalMeses;
		this.totalDias = totalDias;
	}
	
	public DetalleConcurrenciaTO(){
		super();
	}

	public List<ConcurrenciaTO> getConcurrencias() {
		return concurrencias;
	}

	public void setConcurrencias(List<ConcurrenciaTO> concurrencias) {
		this.concurrencias = concurrencias;
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
