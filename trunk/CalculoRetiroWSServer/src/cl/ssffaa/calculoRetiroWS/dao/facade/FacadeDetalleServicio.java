package cl.ssffaa.calculoRetiroWS.dao.facade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cl.ssffaa.calculoRetiroWS.dao.to.AbonoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleAbonoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleConcurrenciaTO;
import cl.ssffaa.calculoRetiroWS.dao.to.DetalleDeServiciosTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ItemGrillaWSTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ServicioTO;
import cl.ssffaa.calculoRetiroWS.util.Archivo;
import cl.ssffaa.calculoRetiroWS.util.Util;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoDeServicio;

public class FacadeDetalleServicio {


	public List<ServicioTO> obtenerListaDeServicios(String instituciones, DetalleAbonoTO detalleAbonos, 
			DetalleConcurrenciaTO detalleConcurrencia, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc){
		
		
		List<ServicioTO> listaServicios = new ArrayList<ServicioTO>();;
		ServicioTO servicio = new ServicioTO();
		
		int totalConAbonosAnios = aniosCPDNyConsc;
	    int totalConAbonosMeses = mesesCPDNyConsc;
	    int totalConAbonosDias = diasCPDNyConsc;
	    int totalConAbonosEnDias = 0;
	    
	    int totalConAbonosAniosNormalizado = 0;
	    int totalConAbonosMesesNormalizado = 0;
	    int totalConAbonosDiasNormalizado = 0;
	    
	    int totalAnios = 0;
    	int totalMeses = 0;
    	int totalDias = 0;
    	int totalEnDias = 0;
    	
    	int totalAniosNormalizado = 0;
    	int totalMesesNormalizado = 0;
    	int totalDiasNormalizado = 0;
    	
    	int cantidadAbonos = 0;
    	if(detalleAbonos != null && detalleAbonos.getAbonos() != null)
    		cantidadAbonos = detalleAbonos.getAbonos().size();	
    	
		servicio.setServicio(instituciones);
		servicio.setAnios(aniosCPDNyConsc);
		servicio.setMeses(mesesCPDNyConsc);
		servicio.setDias(diasCPDNyConsc);
		servicio.setTipoDeServicio(EnumTipoDeServicio.CAPREDENA);
		
		listaServicios.add(servicio);
		
		
		List<AbonoTO> listaAbonos = null;
		
		if(detalleAbonos != null)
			listaAbonos =	detalleAbonos.getAbonos();
		
		 if(detalleAbonos != null && listaAbonos != null){
	    	for(int j=0; j<listaAbonos.size(); j++){
		    	
	    		AbonoTO abono = listaAbonos.get(j);
	    		servicio = new ServicioTO();
//	    		int valorEnDias = 0;
	    		
	    		if(abono != null){
	    			servicio.setServicio(abono.getTipo());
	    			servicio.setAnios(abono.getAnios());
	    			servicio.setMeses(abono.getMeses());
	    			servicio.setDias(abono.getDias());
//	    			valorEnDias = (abono.getAnios()*360) + (abono.getMeses()*30) + abono.getDias();
//	    			servicio.setEnDias(valorEnDias);
	    			servicio.setTipoDeServicio(EnumTipoDeServicio.ABONO);
	    			
	    			listaServicios.add(servicio);
	    		}
		    }
	    	//Suma de los tiempos capredena y conscripción + los tiempos de los abonos
	    	totalConAbonosAnios += detalleAbonos.getTotalAnios();
	    	totalConAbonosMeses += detalleAbonos.getTotalMeses();
	    	totalConAbonosDias += detalleAbonos.getTotalDias();
	    }
		
		 //AGREGAR LA SUMA PARCIAL DE TIEMPOS
	    
	    totalConAbonosDiasNormalizado = Util.obtenerDiasNormalizados(totalConAbonosDias);
	    totalConAbonosMesesNormalizado = Util.obtenerMesesNormalizados(totalConAbonosDias, totalConAbonosMeses);
	    totalConAbonosAniosNormalizado = Util.obtenerAniosNormalizados(totalConAbonosDias, totalConAbonosMeses, totalConAbonosAnios);
	        
	    totalConAbonosEnDias = (totalConAbonosAniosNormalizado*360) + (totalConAbonosMesesNormalizado*30) + totalConAbonosDiasNormalizado;
	    
	    
	    //SUMA PARCIAL DE TIEMPOS HASTA LOS ABONOS
		
	    servicio = new ServicioTO();
	    
	    servicio.setServicio("Total con abonos");
		servicio.setAnios(totalConAbonosAniosNormalizado);
		servicio.setMeses(totalConAbonosMesesNormalizado);
		servicio.setDias(totalConAbonosDiasNormalizado);
		servicio.setEnDias(totalConAbonosEnDias);
		servicio.setTipoDeServicio(EnumTipoDeServicio.TOTAL_CON_ABONOS);
		
		listaServicios.add(servicio);
		
		
		totalAnios = totalConAbonosAniosNormalizado;
    	totalMeses = totalConAbonosMesesNormalizado;
    	totalDias = totalConAbonosDiasNormalizado;
    	totalEnDias = totalConAbonosEnDias;
			
	    	
	    //FILAS CON CONCURRENCIAS
		
    	List<ConcurrenciaTO> listaConcurrencias = null;
		
		if(detalleConcurrencia != null)
			listaConcurrencias = detalleConcurrencia.getConcurrencias();
		
		 if(detalleConcurrencia != null && listaConcurrencias != null){
	    	for(int j=0; j<listaConcurrencias.size(); j++){
		    	
	    		ConcurrenciaTO concurrencia = listaConcurrencias.get(j);
	    		servicio = new ServicioTO();
	    		int valorEnDias = 0;
	    		
	    		if(concurrencia != null){
	    			servicio.setServicio(concurrencia.getTipo());
	    			servicio.setAnios(concurrencia.getAnios());
	    			servicio.setMeses(concurrencia.getMeses());
	    			servicio.setDias(concurrencia.getDias());
	    			valorEnDias = (concurrencia.getAnios()*360) + (concurrencia.getMeses()*30) + concurrencia.getDias();
	    			servicio.setEnDias(valorEnDias);
	    			servicio.setTipoDeServicio(EnumTipoDeServicio.CONCURRENCIA);
	    			
	    			listaServicios.add(servicio);
	    		}
		    }
	    	//Suma de los tiempos capredena y conscripción + los tiempos de los abonos
	    	totalAnios += detalleConcurrencia.getTotalAnios();
	    	totalMeses += detalleConcurrencia.getTotalMeses();
	    	totalDias += detalleConcurrencia.getTotalDias();
	    }
		
		
		//AGREGAR LA SUMA TOTAL DE TIEMPOS
	    
		totalDiasNormalizado = Util.obtenerDiasNormalizados(totalDias);
		totalMesesNormalizado = Util.obtenerMesesNormalizados(totalDias, totalMeses);
		totalAniosNormalizado = Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios);    
		totalEnDias = (totalAniosNormalizado*360) + (totalMesesNormalizado*30) + totalDiasNormalizado;
    	
		    
	    //AGREGAR LOS PORCENTAJES A LAS CONCURRENCIAS
	    
		double porcentaje = 0.0;
	    double valor = 0.0;
	    double sumaPorcentaje = 0.0;
	    
	    for(int k=cantidadAbonos+1; k<listaServicios.size(); k++){
	    	valor =	listaServicios.get(k).getEnDias() * 100.0;
	    	valor = valor / totalEnDias;
	    	porcentaje = Util.aproximacionNdecimales(valor, 5);
	    	listaServicios.get(k).setPorcentaje(porcentaje);
	    	sumaPorcentaje += porcentaje;
	    }
	    
	    //AGREGAR LA SUMA TOTAL DE TIEMPOS
	    
	    totalDiasNormalizado = Util.obtenerDiasNormalizados(totalDias);
	    totalMesesNormalizado = Util.obtenerMesesNormalizados(totalDias, totalMeses);
	    totalAniosNormalizado = Util.obtenerAniosNormalizados(totalDias, totalMeses, totalAnios);
	    
	    
	    //FILA CON LA SUMA TOTAL DE TIEMPOS
		
	    
	    servicio = new ServicioTO();
	    
	    servicio.setServicio("Total efectivos, abonos y concurrencias");
		servicio.setAnios(totalAniosNormalizado);
		servicio.setMeses(totalMesesNormalizado);
		servicio.setDias(totalDiasNormalizado);
		servicio.setEnDias(totalEnDias);
		servicio.setPorcentaje(sumaPorcentaje);
		servicio.setTipoDeServicio(EnumTipoDeServicio.TOTAL_SERVICIOS);
		listaServicios.add(servicio);
	      		
		return listaServicios;		
	}
	
	public DetalleDeServiciosTO obtenerDetalleDeServicios(String instituciones, DetalleAbonoTO detalleAbonos, 
			DetalleConcurrenciaTO detalleConcurrencia, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc){
	
		List<ServicioTO> listaDeServicios = this.obtenerListaDeServicios(instituciones, detalleAbonos, detalleConcurrencia, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc);
		
		//Inicializa cada atributo
		DetalleDeServiciosTO detalleDeServicios = new DetalleDeServiciosTO();
		ItemGrillaWSTO itemGrillaDetalleDeServicios[] = new ItemGrillaWSTO[listaDeServicios.size()];
				    	
		int cantidadColumnas = 6;
		
		if(listaDeServicios != null){
			
			for(int i=0; i<listaDeServicios.size(); i++){
		    	
	    		ServicioTO servicio = listaDeServicios.get(i);
	    		
	    		ItemGrillaWSTO itemGrilla = new ItemGrillaWSTO();
	    		ItemColumnaWSTO listaItemColumna[] = new ItemColumnaWSTO[cantidadColumnas];
	    			    		
	    		if(servicio != null){
	    		
	    			for(int k = 0; k < cantidadColumnas; k++)
	            	{	
	    				ItemColumnaWSTO itemColumna = new ItemColumnaWSTO();
	    				itemColumna.setOrden(k+1);
	    				itemColumna.setTipo("ALF");
	    				switch (k) {
							case 0:
								itemColumna.setId("_Detalle_de_servicios");
								itemColumna.setValor(servicio.getServicio());
								break;
							case 1:
								itemColumna.setId("_Anos");
								itemColumna.setValor(servicio.getAnios()+"");
								break;
							case 2:
								itemColumna.setId("_Meses");
								itemColumna.setValor(servicio.getMeses()+"");
								break;
							case 3:
								itemColumna.setId("_Dias");
								itemColumna.setValor(servicio.getDias()+"");
								break;
							case 4:
								itemColumna.setId("_En_dias");
								if(servicio.getEnDias() >= 0)
									itemColumna.setValor(servicio.getEnDias()+"");
								else
									itemColumna.setValor("");
								break;
							case 5:
								itemColumna.setId("_Porcentaje");
								if(servicio.getPorcentaje() >= 0)
									itemColumna.setValor(servicio.getPorcentaje()+"");
								else
									itemColumna.setValor("");
								break;
							default:
								itemColumna.setId("");
								itemColumna.setValor("");
								break;
						}
	    				listaItemColumna[k] = itemColumna;
	            	}
	    			itemGrilla.setListaColumnas(listaItemColumna);
	    			itemGrillaDetalleDeServicios[i] = itemGrilla;
	    		}
	    	}
			ServicioTO resumenServicios = listaDeServicios.get(listaDeServicios.size()-1);
			
			detalleDeServicios.setItemGrillaDetalleDeServicios(itemGrillaDetalleDeServicios);
			detalleDeServicios.setServicios(listaDeServicios);
			detalleDeServicios.setTotalAnios(resumenServicios.getAnios());
			detalleDeServicios.setTotalMeses(resumenServicios.getMeses());
			detalleDeServicios.setTotalDias(resumenServicios.getDias());
			detalleDeServicios.setTotalEnDias(resumenServicios.getEnDias());
			detalleDeServicios.setTotalPorcentaje(resumenServicios.getPorcentaje());
		}
	    	
	    	
		return detalleDeServicios;
	}
	
	public String obtenerXmlDetalleDeServicios(String instituciones, DetalleAbonoTO detalleAbonos, 
			DetalleConcurrenciaTO detalleConcurrencia, int aniosCPDNyConsc, int mesesCPDNyConsc, int diasCPDNyConsc){
	
		String xml = "";
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element detalleDeServicios = doc.createElement("detalleDeServicios");
								
			List<ServicioTO> listaDeServicios = this.obtenerListaDeServicios(instituciones, detalleAbonos, detalleConcurrencia, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc);
						
			if(listaDeServicios != null){
				
				for(int i=0; i<listaDeServicios.size(); i++){
			    	
		    		ServicioTO servicioTO = listaDeServicios.get(i);
		    				    		
		    		Element servicio = doc.createElement("servicio");
		    			    		
		    		if(servicio != null){
		    		
		    			
						Element detalle = doc.createElement("detalle");
						detalle.setTextContent(servicioTO.getServicio());
						servicio.appendChild(detalle);
						
						Element anios = doc.createElement("anios");
						anios.setTextContent(servicioTO.getAnios()+"");
						servicio.appendChild(anios);
						
						Element meses = doc.createElement("meses");
						meses.setTextContent(servicioTO.getMeses()+"");
						servicio.appendChild(meses);
			
						Element dias = doc.createElement("dias");
						dias.setTextContent(servicioTO.getDias()+"");
						servicio.appendChild(dias);
			
						Element enDias = doc.createElement("enDias");
						if(servicioTO.getEnDias() >= 0)
							enDias.setTextContent(servicioTO.getEnDias()+"");
						else
							enDias.setTextContent("");
						servicio.appendChild(enDias);
						
						Element proporcion = doc.createElement("proporcion");
						if(servicioTO.getPorcentaje() >= 0)
							proporcion.setTextContent(servicioTO.getPorcentaje()+"");
						else
							proporcion.setTextContent("");
						servicio.appendChild(proporcion);
						
		    			detalleDeServicios.appendChild(servicio);
		    		}
		    	}
				doc.appendChild(detalleDeServicios);
				xml = Archivo.convertirDocumentToString(doc);
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
