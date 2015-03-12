package cl.ssffaa.calculoRetiroWS.properties;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class Propiedades {
	
	public static final String FS = File.separator;
	public static String CONF_PATH;
	public static String TMP_PATH ;
	public static String CATALINA_HOME;
	public static String XML_PROPERTIES_PATH = "";
	public static String PLANTILLA_EMAIL = "";
	static public String RUTA_PLANTILLAS = "";
	static public String RUTA_PLANTILLA_EMAIL = "";
	static public String IDIOMA_DEFECTO = "";
	static public String NOMBRE_CLIENTE = "";
	static public String DBTYPE = "postgresql";
	
	private static HashMap<String, String> parametros = new HashMap<String,String>();

	static{
		 try {
			 
			 	String path = "/cl/ssffaa/calculoRetiroWS/properties/aplication.properties";
				InputStream in = Propiedades.class.getResourceAsStream(path);			
				Properties props = new Properties();    
				props.load(in);
				CATALINA_HOME=System.getProperty( props.getProperty("VAR_ENTORNO")) + props.getProperty("DIRECTORIO_BASE");
				CONF_PATH = CATALINA_HOME + FS + "conf";
				TMP_PATH = CATALINA_HOME + FS + "tmp";
				XML_PROPERTIES_PATH = CONF_PATH + FS + props.getProperty("XML_PROPERTIES_PATH");
				RUTA_PLANTILLA_EMAIL = CONF_PATH + FS + props.getProperty("RUTA_PLANTILLA_EMAIL");
			 
		    	//usar el parser Xerces y no queremos que valide el documento
		        SAXBuilder builder=new SAXBuilder(false); 
		       
		      	//construyo el arbol que representa el documento y obtengo la raiz.
		        Document doc=builder.build(XML_PROPERTIES_PATH);	        
		        Element raiz=doc.getRootElement();
		        
		        //todos los hijos que tengan como nombre "propiedad"		        
		        List propiedades=raiz.getChildren("propiedad");
		        Iterator i = propiedades.iterator();
		        while (i.hasNext()){
		            Element prop= (Element)i.next();
		            String nombre = prop.getAttributeValue("nombre");
		            String valor = prop.getAttributeValue("valor");
		            parametros.put(nombre.toUpperCase(), valor);
		        }
		         
		        
				System.out.println("Properties cargado");
				
				
		     }catch (Exception ex) {
		    	 System.out.println("[ERROR] [Propiedades] [HashMap][" + ex.getMessage() + "]");
			 }		 	
	}
	
	static public String getProperty(String nombre){
		String ret = "";
		if(parametros.containsKey(nombre))
			ret = parametros.get(nombre);
		
		return ret;
	}
}
