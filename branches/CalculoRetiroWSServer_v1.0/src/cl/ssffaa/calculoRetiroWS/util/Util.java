package cl.ssffaa.calculoRetiroWS.util;

public class Util {

	public static boolean isNumber(String string) {
		
		if(string == null || string.isEmpty() ){
			return false;
		}
		int i = 0;
		if(string.charAt(0) == '-'){
			if(string.length() > 1){
				i++;
			}
			else{
				return false;
			}
		}
		for(; i < string.length(); i++){
			if(!Character.isDigit(string.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public static int obtenerValorPorcentual(String texto){
		
		//Quitar espacios en blanco
		texto = texto.replace(" ", "");
		
		String[] porcentajeString = texto.split("%");
		
		if(isNumber(porcentajeString[0])){
			return Integer.parseInt(porcentajeString[0]);
		}
		else{
			return 0;
		}		
	}
	

	public static int obtenerDiasNormalizados(int dias){
		if(dias >= 30){
			dias = dias % 30;
		}
		return dias;
	}
	
	public static int obtenerMesesNormalizados(int dias, int meses){
		if(dias >= 30){
			meses = meses + dias/30;
		}
		meses = meses % 12;
		
		return meses;
	}
	
	public static int obtenerAniosNormalizados(int dias, int meses, int anios){
		if(dias >= 30){
			meses = meses + dias/30;
			dias = dias % 30;
		}
		if(meses >= 12){
			anios = anios + meses/12;
			meses = meses % 12;
		}
		return anios;
	}
	
	public static  double aproximacionNdecimales(double valor, int cantidadDeDecimales){
		
		double result = valor * Math.pow(10, cantidadDeDecimales);
		result = Math.round(result);
		result = result / Math.pow(10, cantidadDeDecimales);
	
		return result;
	}
		
}
