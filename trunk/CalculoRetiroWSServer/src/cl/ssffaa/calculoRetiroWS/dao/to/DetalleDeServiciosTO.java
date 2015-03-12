package cl.ssffaa.calculoRetiroWS.dao.to;

import java.util.List;

public class DetalleDeServiciosTO {

	private ItemGrillaWSTO itemGrillaDetalleDeServicios[];
	private List<ServicioTO> servicios;
	private int totalAnios;
	private int totalMeses; 
	private int totalDias;
	private int totalEnDias;
	private double totalPorcentaje;
	
	
	public DetalleDeServiciosTO( ItemGrillaWSTO itemGrillaDetalleDeServicios[], int totalAnios, int totalMeses, int totalDias, int totalEnDias, double totalPorcentaje){
		this.itemGrillaDetalleDeServicios = itemGrillaDetalleDeServicios;
		this.totalAnios = totalAnios;
		this.totalMeses = totalMeses;
		this.totalDias = totalDias;
		this.totalEnDias = totalEnDias;
		this.totalPorcentaje = totalPorcentaje;
	}
	
	public DetalleDeServiciosTO(){
		super();
	}

	public ItemGrillaWSTO[] getItemGrillaDetalleDeServicios() {
		return itemGrillaDetalleDeServicios;
	}

	public void setItemGrillaDetalleDeServicios(ItemGrillaWSTO[] itemGrillaDetalleDeServicios) {
		this.itemGrillaDetalleDeServicios = itemGrillaDetalleDeServicios;
	}

	public List<ServicioTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioTO> servicios) {
		this.servicios = servicios;
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

	public int getTotalEnDias() {
		return totalEnDias;
	}

	public void setTotalEnDias(int totalEnDias) {
		this.totalEnDias = totalEnDias;
	}

	public double getTotalPorcentaje() {
		return totalPorcentaje;
	}

	public void setTotalPorcentaje(double totalPorcentaje) {
		this.totalPorcentaje = totalPorcentaje;
	}

	
}
