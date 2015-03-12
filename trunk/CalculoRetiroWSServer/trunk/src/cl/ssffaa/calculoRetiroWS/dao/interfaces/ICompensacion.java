package cl.ssffaa.calculoRetiroWS.dao.interfaces;

public interface ICompensacion {

	public int obtenerPlanillaSuplementariaDFL_1_68(int gradoPlanillaSuplementaria);
	public int obtenerBonificacionCompensatoriaConSobresueldo(int idReajusteAaplicar, int idEspecificacionGrado);
	public int obtenerBonificacionCompensatoriaSinSobresueldo(int idReajusteAaplicar, int idEspecificacionGrado);
	
}
