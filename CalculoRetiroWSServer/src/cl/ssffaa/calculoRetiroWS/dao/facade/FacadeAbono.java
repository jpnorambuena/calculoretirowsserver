package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cl.ssffaa.calculoRetiroWS.dao.to.AbonoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleAbonoTO;
import cl.ssffaa.calculoRetiroWS.util.Archivo;
import cl.ssffaa.calculoRetiroWS.util.Util;
import cl.ssffaa.calculoRetiroWS.util.UtilNode;

public class FacadeAbono {


public DetalleAbonoTO obtenerDetalleDeAbonos(String abonos){
		
		DetalleAbonoTO detalleAbono = new DetalleAbonoTO();
		List<AbonoTO> listaAbonos = new ArrayList<AbonoTO>();
		
		int valorAnios = 0;
		int valorMeses = 0;
		int valorDias = 0;
		
		int totalAnios = 0;
		int totalMeses = 0;
		int totalDias = 0;
		
		Document abonosXml = Archivo.convertirStringToDocument(abonos);
		if(abonosXml != null){
			Element raizAbonos = abonosXml.getDocumentElement();
			
			NodeList nlAbonos = raizAbonos.getChildNodes();
			AbonoTO abonoTO = null;
			
			if(nlAbonos != null){
	    		for(int i=0; i<nlAbonos.getLength(); i++){
		    		Node nAbono = nlAbonos.item(i);
		    		if(nAbono.getNodeType() == Node.ELEMENT_NODE){
			        	Element eAbono = (Element) nAbono;
			        	abonoTO = new AbonoTO();
			        	if(eAbono != null){
			        		Element eTipo = (Element) eAbono.getElementsByTagName("tipo").item(0);
			        		if (eTipo != null)
			        			abonoTO.setTipo(eTipo.getTextContent());
			        		else
			        			abonoTO.setTipo("");
			        		
			        		Element eAnios = (Element) eAbono.getElementsByTagName("anios").item(0);
			        		if (eAnios != null)
			        			valorAnios = Integer.parseInt(eAnios.getTextContent());
			        		else
			        			valorAnios = 0;;
			        		
			        		Element eMeses = (Element) eAbono.getElementsByTagName("meses").item(0);
			        		if (eMeses != null)
			        			valorMeses = Integer.parseInt(eMeses.getTextContent());
			        		else
			        			valorMeses = 0;
			        		
			        		Element eDias = (Element) eAbono.getElementsByTagName("dias").item(0);
			        		if (eDias != null)
			        			valorDias = Integer.parseInt(eDias.getTextContent());
			        		else
			        			valorDias = 0;
			        		
			        		
			        		abonoTO.setAnios(valorAnios);
			        		abonoTO.setMeses(valorMeses);
			        		abonoTO.setDias(valorDias);
			        		
			        		listaAbonos.add(abonoTO);
				    		
				    		totalAnios += valorAnios;
					    	totalMeses += valorMeses;
					    	totalDias += valorDias;
			        	}
					}	
	    		}
		    	detalleAbono.setAbonos(listaAbonos);
		    	detalleAbono.setTotalAnios(Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios));
		    	detalleAbono.setTotalMeses(Util.obtenerMesesNormalizados(totalDias, totalMeses));
		    	detalleAbono.setTotalDias(Util.obtenerDiasNormalizados(totalDias));
		    }
		}
		else{
			detalleAbono.setAbonos(listaAbonos);
			detalleAbono.setTotalAnios(0);
	    	detalleAbono.setTotalMeses(0);
	    	detalleAbono.setTotalDias(0);
		}
		return detalleAbono;
	}
	

	public DetalleAbonoTO obtenerDetalleDeAbonosAntiguo(String abonos){
		
		DetalleAbonoTO detalleAbono = new DetalleAbonoTO();
		List<AbonoTO> listaAbonos = new ArrayList<AbonoTO>();
		
		Document abonosXml = Archivo.convertirStringToDocument(abonos);
		if(abonosXml != null){
			Element raizAbonos = abonosXml.getDocumentElement();
			NodeList columnasAbonos = raizAbonos.getElementsByTagName("columna"); 
			NodeList valoresAbonos = null;
			NodeList valoresAniosAbonos = null;
			NodeList valoresMesesAbonos = null;
			NodeList valoresDiasAbonos = null;
			
			int valorAnios = 0;
			int valorMeses = 0;
			int valorDias = 0;
			
			int totalAnios = 0;
			int totalMeses = 0;
			int totalDias = 0;
			
			AbonoTO abono = null;
					
		    for(int i=0; i<columnasAbonos.getLength(); i++) {   
	
		        Node nodoColumna = columnasAbonos.item(i);
		        
		        if(nodoColumna.getNodeType() == Node.ELEMENT_NODE){
		        	Element columna = (Element) nodoColumna;
		        
		        	if(columna.getAttribute("titulo").equalsIgnoreCase("Abono")){
		        		valoresAbonos = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Años")){
		        		valoresAniosAbonos = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Meses")){
		        		valoresMesesAbonos = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Días")){
		        		valoresDiasAbonos = columna.getChildNodes();       		
		        	}
		        }
		    }
		    
		    
		    //Agregar los valores de los abonos al detelle de los servicios	    
		    
		    if(valoresAbonos != null){
		    	for(int j=0; j<valoresAbonos.getLength(); j++){
			    	
		    		String valor = UtilNode.obtenerValorDesdeLista(valoresAbonos, j);
		    		abono = new AbonoTO();
		    		
		    		if(!valor.isEmpty() || valor != ""){
		    		
			    		abono.setTipo(valor);
				    	if(valoresAniosAbonos != null){
				    		valorAnios = UtilNode.obtenerValorNumericoDesdeLista(valoresAniosAbonos, j);
				    	}
				    	else{
				    		valorAnios = 0;
				    	}
				    	abono.setAnios(valorAnios);
				    	
				    	if(valoresMesesAbonos != null){
				    		valorMeses = UtilNode.obtenerValorNumericoDesdeLista(valoresMesesAbonos, j);
				    	}
				    	else{
				    		valorMeses = 0;
				    	}
				    	abono.setMeses(valorMeses);
				    	
				    	if(valoresDiasAbonos != null){
				    		valorDias = UtilNode.obtenerValorNumericoDesdeLista(valoresDiasAbonos, j);
				    	}
				    	else{
				    		valorDias = 0;
				    	}
				    	abono.setDias(valorDias);
				    	
				    	listaAbonos.add(abono);
			    		
			    		totalAnios += valorAnios;
				    	totalMeses += valorMeses;
				    	totalDias += valorDias;
		    		}
		    		
			    }
			    
		    	detalleAbono.setAbonos(listaAbonos);
		    	detalleAbono.setTotalAnios(Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios));
		    	detalleAbono.setTotalMeses(Util.obtenerMesesNormalizados(totalDias, totalMeses));
		    	detalleAbono.setTotalDias(Util.obtenerDiasNormalizados(totalDias));
		    }
		}
		else{
			detalleAbono.setAbonos(listaAbonos);
			detalleAbono.setTotalAnios(0);
	    	detalleAbono.setTotalMeses(0);
	    	detalleAbono.setTotalDias(0);
		}
		return detalleAbono;
	}

}

