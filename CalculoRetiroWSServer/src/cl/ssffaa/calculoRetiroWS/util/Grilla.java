package cl.ssffaa.calculoRetiroWS.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Grilla {

	public static String concatenarValoresGrilla(String xmlGrilla, String nombreColumna, String separador){
		
		String valoresConcatenados = "";
		
		Document documentoXml = Archivo.convertirStringToDocument(xmlGrilla);
		
		if(documentoXml == null)
			return "";
		
		Element raiz = documentoXml.getDocumentElement();
		
	    NodeList listaColumnas = raiz.getElementsByTagName("columna"); 
	    
	    for(int i=0; i<listaColumnas.getLength(); i++) {   

	        Node nodoColumna = listaColumnas.item(i);
	        
	        if(nodoColumna.getNodeType() == Node.ELEMENT_NODE){
	        	Element columna = (Element) nodoColumna;
	        
	        	if(columna.getAttribute("titulo").equalsIgnoreCase(nombreColumna)){
	        		NodeList valores2 = columna.getElementsByTagName("valor");   
	        		
	        		for(int j=0; j<valores2.getLength(); j++) {
	    	            Node nodoValor = valores2.item(j);
	    	           
	    	            if(nodoValor.getNodeType() == Node.ELEMENT_NODE){
	    		        	Element valor = (Element) nodoValor;
		    		        
	    		        	if(valor != null){
	    		        		if(valoresConcatenados.length() > 0){
		    	            		valoresConcatenados = valoresConcatenados + separador;
		    	            	}
	    		        		
	    		        		valoresConcatenados = valoresConcatenados + valor.getTextContent(); 
	    		        		System.out.println("valoresConcatenados: " + valoresConcatenados);
		    	            }
	    	            }
	    	        }
	        		
	        		break;
	        	}
	        }
	    }
	    
		return valoresConcatenados;
	}
}
