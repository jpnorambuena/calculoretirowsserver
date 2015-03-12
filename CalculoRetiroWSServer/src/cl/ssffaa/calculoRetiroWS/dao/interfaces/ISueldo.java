package cl.ssffaa.calculoRetiroWS.dao.interfaces;

import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;


public interface ISueldo {

	public int obtenerSueldoEnActividad(int grado_economico, int id_Reajuste);
	public int obtenerSueldo1981(int grado_economico);
	public List<SueldoBaseTO> obtenerSueldosBase(int id_Reajuste);
}
