package cl.ssffaa.calculoRetiroWS.util;

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
}
