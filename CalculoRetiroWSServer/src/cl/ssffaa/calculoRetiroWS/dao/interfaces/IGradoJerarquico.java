package cl.ssffaa.calculoRetiroWS.dao.interfaces;

public interface IGradoJerarquico {

	int obtenerIdGradoJerarquicoUniformado(String institucion, String grado);
	int obtenerIdGradoJerarquicoCivil(String institucion, String grado);
	int obtenerIdEspecificacionDeGrado(int gradoJerarquico, int idTipoDePersonal);
}
