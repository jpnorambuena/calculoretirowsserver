package cl.ssffaa.calculoRetiroWS.util;

import cl.ssffaa.calculoRetiroWS.util.enums.EnumCiviles;

public class OperacionDeNegocio {

//	private Connection conn;
//	
//	public OperacionDeNegocio(Connection c){
//	 this.conn = c;	
//	}
	
	public String obtenerTipoDeTituloProf(String tipoDeCivil){
		
		if(tipoDeCivil.equalsIgnoreCase("")){
			return "";
		}
		else if(tipoDeCivil.equalsIgnoreCase(EnumCiviles.PROF)){
			return "P.U.";
		}
		else{
			return "T.A.";
		}	
	}
	
	public int obtenerMensualidadesDesahucio(int aniosDesahucio, int mesesDesahucio){
		
		mesesDesahucio = Util.obtenerMesesNormalizados(0, mesesDesahucio);
		aniosDesahucio = Util.obtenerAniosNormalizados(0, mesesDesahucio, aniosDesahucio);
		
		if(mesesDesahucio >= 6){
			aniosDesahucio++;
		}
		
		if(aniosDesahucio > 30){
			return 30;
		}
		else{
			return aniosDesahucio;
		}
	}
	
}
