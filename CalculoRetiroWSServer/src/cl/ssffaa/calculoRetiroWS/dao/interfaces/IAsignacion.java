package cl.ssffaa.calculoRetiroWS.dao.interfaces;

public interface IAsignacion {

	int obtenerMontoAege(int idReajuste, int idEspecificacionGrado);
	int obtenerMontoAege1981(int gradoJerarquico, int idTipoDePersonal);
	int obtenerMontoAege1981(int gradoJerarquico, String tipoDePersonal);
}
