package cl.ssffaa.calculoRetiroWS.dao.interfaces;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteSectorActivoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteTO;
import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;


public interface IReajuste {

	public int obtenerIdReajuste(Date fechaDeBaja);
	public List<Double> obtenerPorcentajesDeReajustes(Date fechaDeBaja, String tipoDeReajuste);
	public List<ReajusteTO> obtenerReajustes(Date fechaDeBaja);
	public List<ReajusteTO> obtenerReajustes(Date fechaDeBaja, String tipoDeReajuste);
	public List<ReajusteTO> obtenerReajustes();
	public List<ReajusteTO> obtenerTodosReajustes();
	public int obtenerIdUltimoReajuste(String tipoDeReajuste);
	public int obtenerIdUltimoReajuste(String tipoDeReajuste, Date fechaDeInicio, int idReajuste);
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivo(int idReajuste, String tipoDePersonal);
	public List<ReajusteSectorActivoTO> obtenerTodosReajustesSectorActivo(int idReajuste);
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivoSugerido(int idReajusteAnterior, String tipoDePersonal, ReajusteTO reajuste, HashMap<Integer, Integer> sueldosBase);
	public int validarExistenciaAlias(String alias);
	public int agregarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, List<ReajusteSectorActivoTO> reajustesSectorActivo);
	public int modificarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, List<ReajusteSectorActivoTO> reajustesSectorActivo);
	public int agregarReajusteSectorPasivo(ReajusteTO reajuste);
	public int modificarReajusteSectorPasivo(ReajusteTO reajuste);
	public int activarDesactivarReajuste(int idReajuste, boolean activo);
}
