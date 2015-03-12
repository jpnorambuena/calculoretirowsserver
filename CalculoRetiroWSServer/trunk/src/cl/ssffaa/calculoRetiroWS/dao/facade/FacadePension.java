package cl.ssffaa.calculoRetiroWS.dao.facade;

public class FacadePension {
	
	public int obtenerPensionAotorgar(int totalDesahucioSegunAvos, int totalRemuneracionSegunAVOS, int montoFinalOtrosReajustes){
		
		if(totalDesahucioSegunAvos >= montoFinalOtrosReajustes){
			return totalDesahucioSegunAvos;
        }
        else{
        	if(totalRemuneracionSegunAVOS <= montoFinalOtrosReajustes){
        		return totalRemuneracionSegunAVOS;
        	}
        	else{
        		return montoFinalOtrosReajustes;
        	}
        }
	}
	
	public String obtenerMensajeTope(int totalDesahucioSegunAvos, int totalRemuneracionSegunAVOS, int montoFinalOtrosReajustes){
		
		if(totalDesahucioSegunAvos >= montoFinalOtrosReajustes){
			return "Ley Nº 20.717 (5,0% de reajuste)";
        }
        else{
        	if(totalRemuneracionSegunAVOS <= montoFinalOtrosReajustes){
        		return "Ley Nº 20.717 (5,0% de reajuste)";
        	}
        	else{
        		return "D.L. 670 Art. 70 (14% de reajuste)";
        	}
        }
	}
	
}
