package cl.ssffaa.calculoRetiroWS.dao.interfaces;

public interface IAvo {

	double obtenerPorcentajeAvos(int anios, int meses);
	String obtenerCantidadAvos(int anios, int meses);
}
