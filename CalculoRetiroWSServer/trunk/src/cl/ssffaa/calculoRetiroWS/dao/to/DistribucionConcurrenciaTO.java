package cl.ssffaa.calculoRetiroWS.dao.to;

public class DistribucionConcurrenciaTO {

	private ItemGrillaWSTO itemGrillaDistribucionConcurrencia[];
	private int total;
	
	public DistribucionConcurrenciaTO( ItemGrillaWSTO itemGrillaDistribucionConcurrencia[], int total){
		this.itemGrillaDistribucionConcurrencia = itemGrillaDistribucionConcurrencia;
		this.total = total;
	}
	
	public DistribucionConcurrenciaTO(){
		super();
	}

	public ItemGrillaWSTO[] getItemGrillaDistribucionConcurrencia() {
		return itemGrillaDistribucionConcurrencia;
	}

	public void setItemGrillaDistribucionConcurrencia(
			ItemGrillaWSTO[] itemGrillaDistribucionConcurrencia) {
		this.itemGrillaDistribucionConcurrencia = itemGrillaDistribucionConcurrencia;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
