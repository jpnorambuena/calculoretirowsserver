package cl.ssffaa.calculoRetiroWS.util;

public class UtilLog {
	
	public static String getNombreMetodo(){
        //Retorna el nombre del metodo desde el cual se hace el llamado
        return new Exception().getStackTrace()[1].getMethodName();
	}
	
	public static String getNombreClase(){
        //Retorna el nombre de la clase desde el cual se hace el llamado
        return new Exception().getStackTrace()[1].getClassName();
	}
	
	public static void registrar(Exception ex){
		System.out.println("[ERROR] [" + ex.getStackTrace()[1].getClassName() + "] ["+ ex.getStackTrace()[1].getMethodName() +"][" + ex.getMessage() + "]");
		
		//System.out.println("[ERROR registrar] [" + ex.getStackTrace()[0].getClassName() + "] ["+ ex.getStackTrace()[0].getMethodName() +"][" + ex.getMessage() + "]");
	}
	
	public static void registrarExcepcion(String tipoError, String nombreClase, String nombreMetodo, Exception excepcion){
		System.out.println("["+ tipoError +"] [" + nombreClase + "] [" +nombreMetodo+ "][" + excepcion + "]");
	}
	
	public static void registrarAlerta(String tipoDeAlerta, String rut, String mensaje){
		System.out.println("[" + tipoDeAlerta + "] [" + rut + "] [" + mensaje +"]");
	}
}
