package cl.ssffaa.calculoRetiroWS.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UtilNode {

	
	public static String obtenerValorDesdeLista(NodeList listaValores, int orden){
		
		if(listaValores != null){
			for(int i=0; i<listaValores.getLength(); i++){
				Node nodoValor = listaValores.item(i);
				if(nodoValor.getNodeType() == Node.ELEMENT_NODE){
		        	Element valor = (Element) nodoValor;
		        	if(valor.getAttribute("orden").equalsIgnoreCase(orden+"")){
		        		return valor.getTextContent();
		        	}
				}
			}
		}
		return "";
	}

	public static int obtenerValorNumericoDesdeLista(NodeList listaValores, int orden){
		
		if(listaValores != null){
			for(int i=0; i<listaValores.getLength(); i++){
				Node nodoValor = listaValores.item(i);
				if(nodoValor.getNodeType() == Node.ELEMENT_NODE){
		        	Element valor = (Element) nodoValor;
		        	if(valor.getAttribute("orden").equalsIgnoreCase(orden+"")){
		        		if(Util.isNumber(valor.getTextContent())){
		        			return Integer.parseInt(valor.getTextContent());
		        		}
		        		else{
		        			return 0;
		        		}
		        	}
				}
			}
		}
		return 0;
	}
	
	public static String obtenerValorDeNodo(Document document, String nombreNodo, int indiceNodo){
		
    	String valor = "";
    	if(document != null){
	    	NodeList listaNodos = document.getElementsByTagName(nombreNodo);
	    	if(listaNodos != null && listaNodos.getLength() > 0){   		
	    		Node nodo = listaNodos.item(indiceNodo);
				if(nodo.getNodeType() == Node.ELEMENT_NODE){
		        	Element elemento = (Element) nodo;
		        	if(elemento != null)
		        		valor = elemento.getTextContent();
				}
	    	}
    	}
    	return valor;
	}
	
	public static String obtenerSubXml(Document document, String nombreNodo, int indiceNodo){
		String subXml = "";
		
		try {
			Document nuevoDocument = (((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).getDOMImplementation()).createDocument(null, nombreNodo, null);
			if(document != null){
				NodeList listaNodos = document.getElementsByTagName(nombreNodo);
		    	if(listaNodos != null && listaNodos.getLength() > 0){   		
		    		Node nodo = listaNodos.item(indiceNodo);
		    		if(nodo.getNodeType() == Node.ELEMENT_NODE){
			        	Element elemento = (Element) nodo;
			        	if(elemento != null){
			        		NodeList nodosHijos = elemento.getChildNodes();
				    		
				    		if(nodosHijos != null){
				    			for(int i=0; i<nodosHijos.getLength(); i++){
				    				Node nodoHijo = nodosHijos.item(i);
				    				if(nodoHijo.getNodeType() == Node.ELEMENT_NODE){
				    		        	Element elementoHijo = (Element) nodoHijo;
				    		        	if(elementoHijo != null){
				    		        		System.out.println("elemento: "+ elementoHijo.getTagName() + " VALOR: " + elementoHijo.getTextContent());
				    		        		nuevoDocument.adoptNode(elementoHijo);
				    		        	}
				    				}
				    			}
				    		}
			        	}
			        	
					}		    		
		    	}
		    	
		    	subXml = Archivo.convertirDocumentToString(nuevoDocument);
			}
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return subXml;
	}
	
	public static String concatenarValores(String xml, String nombreNodo, String separador){
		String valoresConcatenados = "";
		
		Document document = Archivo.convertirStringToDocument(xml);
		
		if(document != null){
			NodeList listaNodos = document.getElementsByTagName(nombreNodo);
	    	if(listaNodos != null && listaNodos.getLength() > 0){   		
				for(int i=0; i<listaNodos.getLength(); i++){
					Node nodo = listaNodos.item(i);
					if(nodo.getNodeType() == Node.ELEMENT_NODE){
			        	Element elemento = (Element) nodo;
			        	if(elemento != null){
			        		if(valoresConcatenados.length() > 0){
	    	            		valoresConcatenados = valoresConcatenados + separador;
	    	            	}
			        		valoresConcatenados += elemento.getTextContent();
			        	}
					}
				}
	    	}
		}
		return valoresConcatenados;
	}
}
