package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.CompensacionDB;
import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.GradoJerarquicoDB;
import cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql.ReajusteDB;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.ICompensacion;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IGradoJerarquico;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IReajuste;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeReajuste;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTiposDePersonal;

public class FacadeCompensacion {

	private Connection conn;
	
	public FacadeCompensacion(Connection c){
		this.conn = c;
	}
	
	public int obtenerPlanillaSuplementariaLey19699Actual(int gradoLey19699, int idReajuste){
		
		
		if(gradoLey19699 <= 0 || gradoLey19699 > 14)
			return 0;
				
		int idEspecificacionGrado = -1;
		int aegeProfesional = -1;
		int aegeTecnica = -1;
		int idTipoDePersonalProfesional = -1;
		int idTipoDePersonalTecnico = -1;
		int gradoJerarquico = gradoLey19699;
		boolean buscandoGradosSuperiores = true;
		
		FacadeTipoDePersonal facadeTipoPersonal = new FacadeTipoDePersonal(this.conn);
		idTipoDePersonalProfesional = facadeTipoPersonal.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_PROF_UNIV);
		idTipoDePersonalTecnico = facadeTipoPersonal.obtenerIdTipoDePersonal(EnumTiposDePersonal.CIVILES_TEC_ADM_PLANTA_Y_CONTRATA);
		
		
		IGradoJerarquico gradoJerarquicoDB = new GradoJerarquicoDB(this.conn);
		
		FacadeAsignacion facadeAsignacion = new FacadeAsignacion(this.conn);
		
				
		while (aegeProfesional < 0) {
			
			idEspecificacionGrado = gradoJerarquicoDB.obtenerIdEspecificacionDeGrado(gradoJerarquico, idTipoDePersonalProfesional);
			
			if(idEspecificacionGrado < 0){
				if(buscandoGradosSuperiores){
					gradoJerarquico--;
					if(gradoJerarquico == 0){
						gradoJerarquico = gradoLey19699 + 1;
						buscandoGradosSuperiores = false;
					}
				}
				else{
					gradoJerarquico++;
					if(gradoJerarquico == 14){
						aegeProfesional = 0;
					}
				}
			}
			else{
				aegeProfesional = facadeAsignacion.obtenerAege(idReajuste, idEspecificacionGrado);	
			}
		}
		
		buscandoGradosSuperiores = true;
		gradoJerarquico = gradoLey19699;
		
		while (aegeTecnica < 0) {
			
			idEspecificacionGrado = gradoJerarquicoDB.obtenerIdEspecificacionDeGrado(gradoJerarquico, idTipoDePersonalTecnico);
			
			if(idEspecificacionGrado < 0){
				if(buscandoGradosSuperiores){
					gradoJerarquico--;
					if(gradoJerarquico == 0){
						gradoJerarquico = gradoLey19699 + 1;
						buscandoGradosSuperiores = false;
					}
				}
				else{
					gradoJerarquico++;
					if(gradoJerarquico == 20){
						aegeTecnica = 0;
					}
				}
			}
			else{
				aegeTecnica = facadeAsignacion.obtenerAege(idReajuste, idEspecificacionGrado);
			}
		}
		
		return aegeProfesional - aegeTecnica;
	}
	
	public int obtenerPlanillaSuplementariaLey19699anio1981(int planillaSuplementariaLey19699Actual, Date fechaDeBaja){
		
		List<Double> reajustes = new ArrayList<Double>();
		int planillaSuplementariaLey19699Anio1981 = planillaSuplementariaLey19699Actual;
		Double porcentaje = 0.0;
		
		IReajuste reajusteDB = new ReajusteDB(this.conn);
		
		reajustes = reajusteDB.obtenerPorcentajesDeReajustes(fechaDeBaja, EnumTipoDeReajuste.ACTIVO);
		
		for (Double reajuste : reajustes) {
			porcentaje = (reajuste + 100.0)/100.0;
			planillaSuplementariaLey19699Anio1981 = (int) Math.round(planillaSuplementariaLey19699Anio1981/porcentaje);
		}
		
		if(planillaSuplementariaLey19699Anio1981 >= 0 ){
			return planillaSuplementariaLey19699Anio1981;
		}
		else{
			return 0;
		}
	}
	
	public int obtenerPlanillaSuplementariaDFL_1_68(int gradoPlanillaSuplementaria){
		
		if(gradoPlanillaSuplementaria <= 0 || gradoPlanillaSuplementaria > 20)
			return 0;
		
		
		ICompensacion compensacionDB = new CompensacionDB(this.conn);
		
		int planillaSuplementariaDFL_1_68 = 0;
		
		try {
			planillaSuplementariaDFL_1_68 = compensacionDB.obtenerPlanillaSuplementariaDFL_1_68(gradoPlanillaSuplementaria);
		} catch (Exception e) {
			UtilLog.registrar(e);
		}
		
		return planillaSuplementariaDFL_1_68;
	}
	
	public int obtenerBonificacionCompensatoria(int porcentajeSobresueldo, int idReajusteAaplicar, int idEspecificacionGrado){
		
		int bonificacionCompensacion = 0;
		
		ICompensacion compensacionDB = new CompensacionDB(this.conn);
		
		if(porcentajeSobresueldo > 0){
			bonificacionCompensacion = compensacionDB.obtenerBonificacionCompensatoriaConSobresueldo(idReajusteAaplicar, idEspecificacionGrado);
		}
		else{	
			bonificacionCompensacion = compensacionDB.obtenerBonificacionCompensatoriaSinSobresueldo(idReajusteAaplicar, idEspecificacionGrado);
		}
		
		if(bonificacionCompensacion < 0){
			return 0;
		}
		else{
			return bonificacionCompensacion;
		}
	}
}