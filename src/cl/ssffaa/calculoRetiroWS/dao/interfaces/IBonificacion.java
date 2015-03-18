package cl.ssffaa.calculoRetiroWS.dao.interfaces;

import java.util.Date;


public interface IBonificacion {

	public int obtenerPorcentajeBonifMandoyAdm(int gradoJerarquico, int tipoDePersonal, Date fechaDeBaja);
	public int obtenerPorcentajeBonifAltoMando(int gradoJerarquico, int tipoDePersonal, Date fechaDeBaja);
	public int obtenerPorcentajeBonificacionRiesgo(int idReajusteAaplicar, int idEspecificacionGrado);
	public int obtenerBonificacionRiesgo(int idReajusteAaplicar, int idEspecificacionGrado);
}
