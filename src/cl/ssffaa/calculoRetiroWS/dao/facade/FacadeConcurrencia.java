package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cl.ssffaa.calculoRetiroWS.dao.to.ConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DistribucionConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ServicioTO;
import cl.ssffaa.calculoRetiroWS.util.Archivo;
import cl.ssffaa.calculoRetiroWS.util.Util;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.UtilNode;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeServicio;

public class FacadeConcurrencia {


public DetalleConcurrenciaTO obtenerDetalleDeConcurrencias(String concurrencias){
		
		DetalleConcurrenciaTO detalleConcurrencia = new DetalleConcurrenciaTO();
		List<ConcurrenciaTO> listaConcurrencias = new ArrayList<ConcurrenciaTO>();
		
		Document concurrenciasXml = Archivo.convertirStringToDocument(concurrencias);
		
		if(concurrenciasXml != null){
		    Element raizConcurrencias= concurrenciasXml.getDocumentElement();
			NodeList columnasConcurrencias = raizConcurrencias.getElementsByTagName("columna"); 
			NodeList valoresConcurrencias = null;
			NodeList valoresAniosConcurrencias = null;
			NodeList valoresMesesConcurrencias = null;
			NodeList valoresDiasConcurrencias = null;
			
			int valorAnios = 0;
			int valorMeses = 0;
			int valorDias = 0;
			
			int totalAnios = 0;
			int totalMeses = 0;
			int totalDias = 0;
			
			ConcurrenciaTO concurrencia = null;
			
		    for(int i=0; i<columnasConcurrencias.getLength(); i++) {   
	
		        Node nodoColumna = columnasConcurrencias.item(i);
		        
		        if(nodoColumna.getNodeType() == Node.ELEMENT_NODE){
		        	Element columna = (Element) nodoColumna;
		        
		        	if(columna.getAttribute("titulo").equalsIgnoreCase("Concurrencia")){
		        		valoresConcurrencias = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Años")){
		        		valoresAniosConcurrencias  = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Meses")){
		        		valoresMesesConcurrencias = columna.getChildNodes();       		
		        	}
		        	else if(columna.getAttribute("titulo").equalsIgnoreCase("Días")){
		        		valoresDiasConcurrencias = columna.getChildNodes();       		
		        	}
		        }
		    }
			
		    
		    //Agregar los valores de las concurrencias al detelle de los servicios	    
		    
		    if(valoresConcurrencias != null){
		    	for(int j=0; j<valoresConcurrencias.getLength(); j++){
			    	
		    		String valor = UtilNode.obtenerValorDesdeLista(valoresConcurrencias, j);
		    		concurrencia = new ConcurrenciaTO();
		    		
		    		if(!valor.isEmpty() || valor != ""){
			    		
		    			concurrencia.setTipo(valor);
		    			if(valoresAniosConcurrencias != null){
				    		valorAnios = UtilNode.obtenerValorNumericoDesdeLista(valoresAniosConcurrencias, j);
				    	}
				    	else{
				    		valorAnios = 0;
				    	}
				    	concurrencia.setAnios(valorAnios);
				    	
				    	if(valoresMesesConcurrencias != null){
				    		valorMeses = UtilNode.obtenerValorNumericoDesdeLista(valoresMesesConcurrencias, j);
				    	}
				    	else{
				    		valorMeses = 0;
				    	}
				    	concurrencia.setMeses(valorMeses);
				    	
				    	if(valoresDiasConcurrencias != null){
				    		valorDias = UtilNode.obtenerValorNumericoDesdeLista(valoresDiasConcurrencias, j);
				    	}
				    	else{
				    		valorDias = 0;
				    	}
				    	concurrencia.setDias(valorDias);
			    	
				    	listaConcurrencias.add(concurrencia);
			    		
			    		totalAnios += valorAnios;
				    	totalMeses += valorMeses;
				    	totalDias += valorDias;
		    		}
			    }
		    	detalleConcurrencia.setConcurrencias(listaConcurrencias);
		    	detalleConcurrencia.setTotalAnios(Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios));
		    	detalleConcurrencia.setTotalMeses(Util.obtenerMesesNormalizados(totalDias, totalMeses));
		    	detalleConcurrencia.setTotalDias(Util.obtenerDiasNormalizados(totalDias));
		    }
		}
		else{
			detalleConcurrencia.setConcurrencias(listaConcurrencias);
	    	detalleConcurrencia.setTotalAnios(0);
	    	detalleConcurrencia.setTotalMeses(0);
	    	detalleConcurrencia.setTotalDias(0);
		}
		return detalleConcurrencia;
	}

	public DistribucionConcurrenciaTO obtenerDistribucionConcurrencia(List<ServicioTO> listaDeServicios, int distribucionCapredena, 
			int cantidadConcurrencias){
	
		//Inicializa cada atributo
		DistribucionConcurrenciaTO distribucionConcurrencia = new DistribucionConcurrenciaTO();
		ItemGrillaWSTO itemGrillaDistribucionConcurrencia[] = new ItemGrillaWSTO[cantidadConcurrencias+1];
				    	
		int cantidadColumnas = 2;
		int total = 0;
		int indiceConcurrencias = 0;
		if(listaDeServicios != null){
			
			for(int i=0; i<listaDeServicios.size(); i++){
		    	
	    		ServicioTO servicio = listaDeServicios.get(i);
	    		
	    		ItemGrillaWSTO itemGrilla = new ItemGrillaWSTO();
	    		ItemColumnaWSTO listaItemColumna[] = new ItemColumnaWSTO[cantidadColumnas];
	    			    		
	    		if(servicio != null){
	    			if(servicio.getTipoDeServicio() == EnumTipoDeServicio.TOTAL_CON_ABONOS || 
	    					servicio.getTipoDeServicio() == EnumTipoDeServicio.CONCURRENCIA){
	    		
		    			for(int k = 0; k < cantidadColumnas; k++)
		            	{	
		    				ItemColumnaWSTO itemColumna = new ItemColumnaWSTO();
		    				itemColumna.setOrden(k+1);
		    				
		    				int monto = (int) Math.round((distribucionCapredena * servicio.getPorcentaje())/100.0);
		    						
		    				switch (k) {
								case 0:
									itemColumna.setId("_Institucion");
									itemColumna.setTipo("ALF");
									if(servicio.getTipoDeServicio() == EnumTipoDeServicio.TOTAL_CON_ABONOS)
										itemColumna.setValor(EnumTipoDeServicio.CAPREDENA);
									else
										itemColumna.setValor(servicio.getServicio());
									break;
								case 1:
									itemColumna.setId("_Monto");
									itemColumna.setTipo("NUM");
									itemColumna.setValor(monto+"");
									total += monto;
									break;
								
								default:
									itemColumna.setId("");
									itemColumna.setValor("");
									itemColumna.setTipo("");
									break;
							}
		    				listaItemColumna[k] = itemColumna;
		            	}
		    			itemGrilla.setListaColumnas(listaItemColumna);
		    			itemGrillaDistribucionConcurrencia[indiceConcurrencias] = itemGrilla;
		    			indiceConcurrencias++;
	    			}
	    		}
	    	}
			distribucionConcurrencia.setItemGrillaDistribucionConcurrencia(itemGrillaDistribucionConcurrencia);
			distribucionConcurrencia.setTotal(total);
		}
	    	
	    	
		return distribucionConcurrencia;
	}
	
	
	public String obtenerXmlDistribucionConcurrencia(List<ServicioTO> listaDeServicios, int distribucionCapredena, 
			int cantidadConcurrencias){
			    	
		int cantidadColumnas = 2;
		int total = 0;
		String xml = "";
		
		try {
			Document doc = (((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).getDOMImplementation()).createDocument(null,  "detalleConcurrencias", null);
			//Element detalleConcurrencias = doc.createElement("detalleConcurrencias");
			//doc.getDocumentElement().appendChild(detalleConcurrencias);
			
			if(listaDeServicios != null){
				for(int i=0; i<listaDeServicios.size(); i++){
			    	
		    		ServicioTO servicio = listaDeServicios.get(i);
		    				    		
		    		Element concurrencia = doc.createElement("concurrencia");
		    			    		
		    		if(servicio != null){
		    		
		    			if(servicio.getTipoDeServicio() == EnumTipoDeServicio.TOTAL_CON_ABONOS || 
		    					servicio.getTipoDeServicio() == EnumTipoDeServicio.CONCURRENCIA){
			    				
			    			for(int k = 0; k < cantidadColumnas; k++)
			            	{	
			    				int montoConcurrencia = (int) Math.round((distribucionCapredena * servicio.getPorcentaje())/100.0);
	    						
			    				switch (k) {
									case 0:
										Element institucion = doc.createElement("institucion");
										if(servicio.getTipoDeServicio() == EnumTipoDeServicio.TOTAL_CON_ABONOS)
											institucion.setTextContent(EnumTipoDeServicio.CAPREDENA);
										else
											institucion.setTextContent(servicio.getServicio());
										concurrencia.appendChild(institucion);
										break;
									case 1:
										Element monto = doc.createElement("monto");
										monto.setTextContent(montoConcurrencia+"");
										concurrencia.appendChild(monto);
										total += montoConcurrencia;
										break;
									
									default:
										break;
								}
			            	}
			    			doc.getDocumentElement().appendChild(concurrencia);
			    		}
			    	}
					xml = Archivo.convertirDocumentToString(doc);
				}
			}
			
		} catch (DOMException e) {
			UtilLog.registrar(e);
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			UtilLog.registrar(e);
			e.printStackTrace();
		}
			    	
		return xml;
	}
}
