package cl.ssffaa.calculoRetiroWS.dao.implementation.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import cl.ssffaa.calculoRetiroWS.dao.implementation.DBBase;
import cl.ssffaa.calculoRetiroWS.dao.interfaces.IReajuste;
import cl.ssffaa.calculoRetiroWS.dao.to.EspecificacionGradoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteSectorActivoTO;
import cl.ssffaa.calculoRetiroWS.dao.to.ReajusteTO;
import cl.ssffaa.calculoRetiroWS.dao.to.SueldoBaseTO;
import cl.ssffaa.calculoRetiroWS.util.UtilLog;
import cl.ssffaa.calculoRetiroWS.util.enums.EnumTipoBeneficioReajuste;

public class ReajusteDB extends DBBase implements IReajuste {

	public ReajusteDB(Connection c) {
		this.conn = c;
	}
	
	@Override
	public int obtenerIdReajuste(Date fechaDeBaja) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT id_reajuste" +
						" FROM reajuste" +
						" WHERE fecha_inicio < ?" +
							" AND tipo_reajuste = 'Activo'" +
							" AND es_ultima_version = true" +
							" AND activo = true" +
						" ORDER BY fecha_inicio DESC limit 1; ";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("id_reajuste");
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}

		return resp;
	}

	@Override
	public List<Double> obtenerPorcentajesDeReajustes(Date fechaDeBaja,
			String tipoDeReajuste) {
		List<Double> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = " SELECT porcentaje" +
					   " FROM reajuste" +
					   " WHERE tipo_reajuste = ?" +
					   		" AND es_ultima_version = true" +
					   		" AND activo = true" +
					   		" AND fecha_inicio < ?" +
					   		" ORDER BY fecha_inicio DESC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setString(1, tipoDeReajuste);
			pstmt.setTimestamp(2, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs = pstmt.executeQuery();
			resp = new ArrayList<Double>();

			
			while(rs.next()){
				Double porcentaje = new Double(0);
					
				porcentaje = rs.getDouble("porcentaje");
				
				resp.add(porcentaje);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

	@Override
	public List<ReajusteTO> obtenerReajustes() {
		List<ReajusteTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String query = "SELECT id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio," +
				" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc," +
				" fecha_doc, version, es_ultima_version, fecha_creacion, fecha_modificacion," +
				" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre" +
		   " FROM reajuste" +
		   " WHERE es_ultima_version = true" +
		   		" AND activo = true" +
		   		" ORDER BY fecha_inicio DESC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteTO>();

			while(rs.next()){
				ReajusteTO reajuste = new ReajusteTO();
								
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setIdUltimoUsuario(rs.getString("id_ultimo_usuario"));
				reajuste.setAlias(rs.getString("alias"));
				reajuste.setTipoReajuste(rs.getString("tipo_reajuste"));
				reajuste.setTipoBeneficio(rs.getString("tipo_beneficio"));
				reajuste.setPorcentaje(rs.getDouble("porcentaje"));
				reajuste.setMonto(rs.getInt("monto"));
				reajuste.setTipoDeCalculo(rs.getString("tipo_de_calculo"));
				reajuste.setFechaInicio(rs.getTimestamp("fecha_inicio"));
				reajuste.setTipoDocumento(rs.getString("tipo_doc"));
				reajuste.setNumeroDocumento(rs.getString("numero_doc"));
				reajuste.setFechaDocumento(rs.getTimestamp("fecha_doc"));
				reajuste.setVersion(rs.getInt("version"));
				reajuste.setEsUltimaVersion(rs.getBoolean("es_ultima_version"));
				reajuste.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
				reajuste.setFechaModificacion(rs.getTimestamp("fecha_modificacion"));
				reajuste.setNumeroOrdenMinisterial(rs.getString("numero_orden_min"));
				reajuste.setFechaOrdenMinisterial(rs.getTimestamp("fecha_orden_min"));
				reajuste.setActivo(rs.getBoolean("activo"));
				reajuste.setIdReajustePadre(rs.getInt("id_reajuste_padre"));
				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

	@Override
	public List<ReajusteTO> obtenerReajustes(Date fechaDeBaja) {
		List<ReajusteTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio," +
							" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc," +
							" fecha_doc, version, es_ultima_version, fecha_creacion, fecha_modificacion," +
							" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre" +
					   " FROM reajuste" +
					   " WHERE es_ultima_version = true" +
					   		" AND activo = true" +
					   		" AND fecha_inicio < ?" +
					   		" ORDER BY fecha_inicio DESC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteTO>();

			while(rs.next()){
				ReajusteTO reajuste = new ReajusteTO();
								
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setIdUltimoUsuario(rs.getString("id_ultimo_usuario"));
				reajuste.setAlias(rs.getString("alias"));
				reajuste.setTipoReajuste(rs.getString("tipo_reajuste"));
				reajuste.setTipoBeneficio(rs.getString("tipo_beneficio"));
				reajuste.setPorcentaje(rs.getDouble("porcentaje"));
				reajuste.setMonto(rs.getInt("monto"));
				reajuste.setTipoDeCalculo(rs.getString("tipo_de_calculo"));
				reajuste.setFechaInicio(rs.getTimestamp("fecha_inicio"));
				reajuste.setTipoDocumento(rs.getString("tipo_doc"));
				reajuste.setNumeroDocumento(rs.getString("numero_doc"));
				reajuste.setFechaDocumento(rs.getTimestamp("fecha_doc"));
				reajuste.setVersion(rs.getInt("version"));
				reajuste.setEsUltimaVersion(rs.getBoolean("es_ultima_version"));
				reajuste.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
				reajuste.setFechaModificacion(rs.getTimestamp("fecha_modificacion"));
				reajuste.setNumeroOrdenMinisterial(rs.getString("numero_orden_min"));
				reajuste.setFechaOrdenMinisterial(rs.getTimestamp("fecha_orden_min"));
				reajuste.setActivo(rs.getBoolean("activo"));
				reajuste.setIdReajustePadre(rs.getInt("id_reajuste_padre"));

				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

	@Override
	public List<ReajusteTO> obtenerReajustes(Date fechaDeBaja,
			String tipoDeReajuste) {
		
		List<ReajusteTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio," +
							" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc," +
							" fecha_doc, version, es_ultima_version, fecha_creacion, fecha_modificacion," +
							" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre" +
					   " FROM reajuste" +
					   " WHERE tipo_reajuste = ?" +
					   		" AND es_ultima_version = true" +
					   		" AND activo = true" +
					   		" AND fecha_inicio < ?" +
					   		" ORDER BY fecha_inicio ASC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setString(1, tipoDeReajuste);
			pstmt.setTimestamp(2, new java.sql.Timestamp(fechaDeBaja.getTime()));
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteTO>();

			while(rs.next()){
				ReajusteTO reajuste = new ReajusteTO();
								
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setIdUltimoUsuario(rs.getString("id_ultimo_usuario"));
				reajuste.setAlias(rs.getString("alias"));
				reajuste.setTipoReajuste(rs.getString("tipo_reajuste"));
				reajuste.setTipoBeneficio(rs.getString("tipo_beneficio"));
				reajuste.setPorcentaje(rs.getDouble("porcentaje"));
				reajuste.setMonto(rs.getInt("monto"));
				reajuste.setTipoDeCalculo(rs.getString("tipo_de_calculo"));
				reajuste.setFechaInicio(rs.getTimestamp("fecha_inicio"));
				reajuste.setTipoDocumento(rs.getString("tipo_doc"));
				reajuste.setNumeroDocumento(rs.getString("numero_doc"));
				reajuste.setFechaDocumento(rs.getTimestamp("fecha_doc"));
				reajuste.setVersion(rs.getInt("version"));
				reajuste.setEsUltimaVersion(rs.getBoolean("es_ultima_version"));
				reajuste.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
				reajuste.setFechaModificacion(rs.getTimestamp("fecha_modificacion"));
				reajuste.setNumeroOrdenMinisterial(rs.getString("numero_orden_min"));
				reajuste.setFechaOrdenMinisterial(rs.getTimestamp("fecha_orden_min"));
				reajuste.setActivo(rs.getBoolean("activo"));
				reajuste.setIdReajustePadre(rs.getInt("id_reajuste_padre"));
				
				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

	@Override
	public List<ReajusteTO> obtenerTodosReajustes() {
		List<ReajusteTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String query = "SELECT id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio," +
				" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc," +
				" fecha_doc, version, es_ultima_version, fecha_creacion, fecha_modificacion," +
				" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre" +
		   " FROM reajuste" +
		   " WHERE es_ultima_version = true" +
		   		" ORDER BY fecha_inicio DESC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteTO>();

			while(rs.next()){
				ReajusteTO reajuste = new ReajusteTO();
								
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setIdUltimoUsuario(rs.getString("id_ultimo_usuario"));
				reajuste.setAlias(rs.getString("alias"));
				reajuste.setTipoReajuste(rs.getString("tipo_reajuste"));
				reajuste.setTipoBeneficio(rs.getString("tipo_beneficio"));
				reajuste.setPorcentaje(rs.getDouble("porcentaje"));
				reajuste.setMonto(rs.getInt("monto"));
				reajuste.setTipoDeCalculo(rs.getString("tipo_de_calculo"));
				reajuste.setFechaInicio(rs.getTimestamp("fecha_inicio"));
				reajuste.setTipoDocumento(rs.getString("tipo_doc"));
				reajuste.setNumeroDocumento(rs.getString("numero_doc"));
				reajuste.setFechaDocumento(rs.getTimestamp("fecha_doc"));
				reajuste.setVersion(rs.getInt("version"));
				reajuste.setEsUltimaVersion(rs.getBoolean("es_ultima_version"));
				reajuste.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
				reajuste.setFechaModificacion(rs.getTimestamp("fecha_modificacion"));
				reajuste.setNumeroOrdenMinisterial(rs.getString("numero_orden_min"));
				reajuste.setFechaOrdenMinisterial(rs.getTimestamp("fecha_orden_min"));
				reajuste.setActivo(rs.getBoolean("activo"));
				reajuste.setIdReajustePadre(rs.getInt("id_reajuste_padre"));
				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}

	@Override
	public int obtenerIdUltimoReajuste(String tipoDeReajuste) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT id_reajuste" +
						" FROM reajuste" +
						" WHERE tipo_reajuste = ?" +
							" AND es_ultima_version = true" +
							" AND activo = true" +
						" ORDER BY fecha_inicio DESC limit 1; ";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tipoDeReajuste);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("id_reajuste");
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}

		return resp;
	}

	@Override
	public int obtenerIdUltimoReajuste(String tipoDeReajuste, Date fechaDeInicio, int idReajuste) {
		int resp = -1;
		PreparedStatement pstmt = null;
		String query = " SELECT id_reajuste" +
						" FROM reajuste" +
						" WHERE tipo_reajuste = ?" +
							" AND es_ultima_version = true" +
							" AND activo = true" +
							" AND fecha_inicio < ?" +
							" AND id_reajuste != ?" +
						" ORDER BY fecha_inicio DESC limit 1; ";
		ResultSet rs = null; 
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tipoDeReajuste);
			pstmt.setTimestamp(2, new java.sql.Timestamp(fechaDeInicio.getTime()));
			pstmt.setInt(3, idReajuste);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){				
				resp = rs.getInt("id_reajuste");
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}

		return resp;
	}
	
	@Override
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivo(
			int idReajuste, String tipoDePersonal) {
		
		List<ReajusteSectorActivoTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		String query = " SELECT rsa.id_reajuste, rsa.id_reajuste_activo, egj.id_grado_jerarquico," +
				" egj.nombre_ejercito, egj.nombre_armada, egj.nombre_fuerza_aerea, egj.id_especificacion_grado," +
				" egj.id_grado_economico_base, tp.tipo, egj.id_tipo_personal, sb.monto," +
				" rsa.aege, rsa.bonif_riesgo, rsa.porcentaje_riesgo, rsa.bonif_mando_adm, rsa.asig_alto_mando," +
				" rsa.bonif_comp_con_sob, rsa.bonif_comp_sin_sob" +
			" FROM reajuste_sector_activo rsa INNER JOIN especificacion_grado_jerarquico egj ON(rsa.id_reajuste = ? AND rsa.id_especificacion_grado = egj.id_especificacion_grado)" +
				" INNER JOIN tipo_personal tp ON(egj.id_tipo_personal = tp.id_tipo_personal AND tp.tipo = ?)" +
				" INNER JOIN sueldo_base sb ON(sb.id_reajuste = ? AND egj.id_grado_economico_base = sb.id_grado_economico)" +
			" ORDER BY egj.id_grado_jerarquico ASC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setInt(1, idReajuste);
			pstmt.setString(2, tipoDePersonal);
			pstmt.setInt(3, idReajuste);
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteSectorActivoTO>();
			
			while(rs.next()){
				ReajusteSectorActivoTO reajuste = new ReajusteSectorActivoTO();
				EspecificacionGradoTO especificacionGrado = new EspecificacionGradoTO();
				
				reajuste.setIdReajusteActivo(rs.getInt("id_reajuste_activo"));
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setAege(rs.getInt("aege"));
				reajuste.setBonificacionRiesgo(rs.getInt("bonif_riesgo"));
				reajuste.setporcentajeRiesgo(rs.getDouble("porcentaje_riesgo"));
				reajuste.setBonifMandoAdm(rs.getInt("bonif_mando_adm"));
				reajuste.setAsigAltoMando(rs.getInt("asig_alto_mando"));
				reajuste.setBonifCompConSobresueldo(rs.getInt("bonif_comp_con_sob"));
				reajuste.setBonifCompSinSobresueldo(rs.getInt("bonif_comp_sin_sob"));
				
				especificacionGrado.setIdEspecificacionGrado(rs.getInt("id_especificacion_grado"));
				especificacionGrado.setIdGradoEconomicoBase(rs.getInt("id_grado_economico_base"));
				especificacionGrado.setIdTipoDePersonal(rs.getInt("id_tipo_personal"));
				especificacionGrado.setTipoDePersonal(rs.getString("tipo"));
				especificacionGrado.setIdGradoJerarquico(rs.getInt("id_grado_jerarquico"));
				especificacionGrado.setNombreEjercito(rs.getString("nombre_ejercito"));
				especificacionGrado.setNombreArmada(rs.getString("nombre_armada"));
				especificacionGrado.setNombreFuerzaAerea(rs.getString("nombre_fuerza_aerea"));
				
				reajuste.setEspecificacionGrado(especificacionGrado);
				
				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}
	
	@Override
	public List<ReajusteSectorActivoTO> obtenerTodosReajustesSectorActivo(int idReajuste) {
		
		List<ReajusteSectorActivoTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		String query = " SELECT rsa.id_reajuste, rsa.id_reajuste_activo, egj.id_grado_jerarquico," +
				" egj.nombre_ejercito, egj.nombre_armada, egj.nombre_fuerza_aerea, egj.id_especificacion_grado," +
				" egj.id_grado_economico_base, tp.tipo, egj.id_tipo_personal, sb.monto," +
				" rsa.aege, rsa.bonif_riesgo, rsa.porcentaje_riesgo, rsa.bonif_mando_adm, rsa.asig_alto_mando," +
				" rsa.bonif_comp_con_sob, rsa.bonif_comp_sin_sob" +
			" FROM reajuste_sector_activo rsa INNER JOIN especificacion_grado_jerarquico egj ON(rsa.id_reajuste = ? AND rsa.id_especificacion_grado = egj.id_especificacion_grado)" +
				" INNER JOIN tipo_personal tp ON(egj.id_tipo_personal = tp.id_tipo_personal)" +
				" INNER JOIN sueldo_base sb ON(sb.id_reajuste = ? AND egj.id_grado_economico_base = sb.id_grado_economico)" +
			" ORDER BY tp.id_tipo_personal, egj.id_grado_jerarquico ASC;";

		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setInt(1, idReajuste);
			pstmt.setInt(2, idReajuste);
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteSectorActivoTO>();
			
			while(rs.next()){
				ReajusteSectorActivoTO reajuste = new ReajusteSectorActivoTO();
				EspecificacionGradoTO especificacionGrado = new EspecificacionGradoTO();
				
				reajuste.setIdReajusteActivo(rs.getInt("id_reajuste_activo"));
				reajuste.setIdReajuste(rs.getInt("id_reajuste"));
				reajuste.setAege(rs.getInt("aege"));
				reajuste.setBonificacionRiesgo(rs.getInt("bonif_riesgo"));
				reajuste.setporcentajeRiesgo(rs.getDouble("porcentaje_riesgo"));
				reajuste.setBonifMandoAdm(rs.getInt("bonif_mando_adm"));
				reajuste.setAsigAltoMando(rs.getInt("asig_alto_mando"));
				reajuste.setBonifCompConSobresueldo(rs.getInt("bonif_comp_con_sob"));
				reajuste.setBonifCompSinSobresueldo(rs.getInt("bonif_comp_sin_sob"));
				
				especificacionGrado.setIdEspecificacionGrado(rs.getInt("id_especificacion_grado"));
				especificacionGrado.setIdGradoEconomicoBase(rs.getInt("id_grado_economico_base"));
				especificacionGrado.setIdTipoDePersonal(rs.getInt("id_tipo_personal"));
				especificacionGrado.setTipoDePersonal(rs.getString("tipo"));
				especificacionGrado.setIdGradoJerarquico(rs.getInt("id_grado_jerarquico"));
				especificacionGrado.setNombreEjercito(rs.getString("nombre_ejercito"));
				especificacionGrado.setNombreArmada(rs.getString("nombre_armada"));
				especificacionGrado.setNombreFuerzaAerea(rs.getString("nombre_fuerza_aerea"));
				
				reajuste.setEspecificacionGrado(especificacionGrado);
				
				resp.add(reajuste);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}
	
	@Override
	public List<ReajusteSectorActivoTO> obtenerReajustesSectorActivoSugerido(
			int idReajusteAnterior, String tipoDePersonal, ReajusteTO reajuste, HashMap<Integer, Integer> sueldosBase) {
		
		List<ReajusteSectorActivoTO> resp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = " SELECT rsa.id_reajuste, rsa.id_reajuste_activo, egj.id_grado_jerarquico," +
							" egj.nombre_ejercito, egj.nombre_armada, egj.nombre_fuerza_aerea, egj.id_especificacion_grado," +
							" egj.id_grado_economico_base, tp.tipo, egj.id_tipo_personal," +
							" rsa.aege, rsa.bonif_riesgo, rsa.porcentaje_riesgo, rsa.bonif_mando_adm, rsa.asig_alto_mando," +
							" rsa.bonif_comp_con_sob, rsa.bonif_comp_sin_sob" +
						" FROM reajuste_sector_activo rsa "+
							" INNER JOIN especificacion_grado_jerarquico egj ON(rsa.id_reajuste = ? AND rsa.id_especificacion_grado = egj.id_especificacion_grado)" +
							" INNER JOIN tipo_personal tp ON(egj.id_tipo_personal = tp.id_tipo_personal AND tp.tipo = ?)" +
						" ORDER BY egj.id_grado_jerarquico ASC;";
		
		try {
			pstmt = this.conn.prepareStatement(query);
			pstmt.setInt(1, idReajusteAnterior);
			pstmt.setString(2, tipoDePersonal);
			rs = pstmt.executeQuery();
			resp = new ArrayList<ReajusteSectorActivoTO>();

			int sueldoBase = 0;
			int nuevoSueldoBase = 0;
			int aege = 0;
			int nuevaAege = 0;
			int gradoEconomicoBase = 0;
			int nuevaBonificacionRiesgo = 0;
			int bonifCompConSobresueldo = 0;
			int bonifCompSinSobresueldo = 0;
			int nuevaBonifCompConSobresueldo = 0;
			int nuevaBonifCompSinSobresueldo = 0;
			double porcentajeRiesgo = 0.0;
			double nuevoPorcentajeReajuste = reajuste.getPorcentaje();
			int nuevoMontoReajuste = reajuste.getMonto();
			
			while(rs.next()){
				ReajusteSectorActivoTO reajusteActivo = new ReajusteSectorActivoTO();
				EspecificacionGradoTO especificacionGrado = new EspecificacionGradoTO();
				
				gradoEconomicoBase = rs.getInt("id_grado_economico_base");
				
				porcentajeRiesgo = rs.getDouble("porcentaje_riesgo");
				aege = rs.getInt("aege");
				bonifCompConSobresueldo = rs.getInt("bonif_comp_con_sob");
				bonifCompSinSobresueldo = rs.getInt("bonif_comp_sin_sob");
				
				sueldoBase = sueldosBase.get(gradoEconomicoBase);
				
				if(reajuste.getTipoBeneficio().equalsIgnoreCase(EnumTipoBeneficioReajuste.PORCENTUAL)){
					nuevaAege = (int) Math.round((aege * nuevoPorcentajeReajuste) / 100.0) + aege;
					nuevoSueldoBase = (int) Math.round((sueldoBase * nuevoPorcentajeReajuste) / 100.0) + sueldoBase;
				}
				else{//Monetario
					nuevaAege = aege + nuevoMontoReajuste;
					nuevoSueldoBase = sueldoBase + nuevoMontoReajuste;
				}
							
				nuevaBonificacionRiesgo = (int) Math.round((nuevoSueldoBase * porcentajeRiesgo) / 100.0);
				nuevaBonifCompConSobresueldo = (int) Math.round((bonifCompConSobresueldo * nuevoPorcentajeReajuste) / 100.0) + bonifCompConSobresueldo;
				nuevaBonifCompSinSobresueldo = (int) Math.round((bonifCompSinSobresueldo * nuevoPorcentajeReajuste) / 100.0) + bonifCompSinSobresueldo;
				
				
				reajusteActivo.setIdReajusteActivo(rs.getInt("id_reajuste_activo"));
				reajusteActivo.setIdReajuste(rs.getInt("id_reajuste"));
				reajusteActivo.setAege(nuevaAege);
				reajusteActivo.setBonificacionRiesgo(nuevaBonificacionRiesgo);
				reajusteActivo.setporcentajeRiesgo(porcentajeRiesgo);				
				reajusteActivo.setBonifMandoAdm(rs.getInt("bonif_mando_adm"));
				reajusteActivo.setAsigAltoMando(rs.getInt("asig_alto_mando"));
				
				reajusteActivo.setBonifCompConSobresueldo(nuevaBonifCompConSobresueldo);
				reajusteActivo.setBonifCompSinSobresueldo(nuevaBonifCompSinSobresueldo);
				
				especificacionGrado.setIdEspecificacionGrado(rs.getInt("id_especificacion_grado"));
				especificacionGrado.setIdGradoEconomicoBase(gradoEconomicoBase);
				especificacionGrado.setIdTipoDePersonal(rs.getInt("id_tipo_personal"));
				especificacionGrado.setTipoDePersonal(rs.getString("tipo"));
				especificacionGrado.setIdGradoJerarquico(rs.getInt("id_grado_jerarquico"));
				especificacionGrado.setNombreEjercito(rs.getString("nombre_ejercito"));
				especificacionGrado.setNombreArmada(rs.getString("nombre_armada"));
				especificacionGrado.setNombreFuerzaAerea(rs.getString("nombre_fuerza_aerea"));
				
				reajusteActivo.setEspecificacionGrado(especificacionGrado);
				
				resp.add(reajusteActivo);
			}
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			UtilLog.registrar(e);
		}finally{
			if(pstmt!=null){
				try {
					if(rs!=null)
						rs.close();
					pstmt.close();
				} catch (SQLException sqle) {
					UtilLog.registrar(sqle);
				}
			}
		}
		return resp;
	}
	
	
	@Override
	public int validarExistenciaAlias(String alias) {
		
		PreparedStatement pstmt = null;
		String query = " SELECT COUNT(*) AS total" + 
						" FROM reajuste"+
						" WHERE alias=?;";
		 
		int resp = -1;
		ResultSet rs = null;
		
		try{
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,alias );
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				resp = rs.getInt("total");
			}
			pstmt.close();
			rs.close();
			

		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;
	}

	@Override
	public int agregarReajusteSectorPasivo(ReajusteTO reajuste) {
		
		int idReajuste = this.obtenerSiguienteIdReajuste();
		
		if(idReajuste > 0){
			reajuste.setIdReajuste(idReajuste);
			int resp = this.agregarReajuste(reajuste);
			return resp;
		}
		else
			return idReajuste;
	}
	
	@Override
	public int agregarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, 
			List<ReajusteSectorActivoTO> reajustesSectorActivo) {
		
		int idReajuste = this.obtenerSiguienteIdReajuste();
		
		if(idReajuste > 0){
			reajuste.setIdReajustePadre(reajuste.getIdReajuste());
			reajuste.setIdReajuste(idReajuste);
			
			int resp = this.agregarReajuste(reajuste);
			
			if(resp > 0){
				resp = this.agregarSueldosBase(sueldosBase, idReajuste);
				if(resp > 0)
					resp = this.agregarReajustesSectorActivo(reajustesSectorActivo, idReajuste);
			}
			return resp;
		}
		else
			return idReajuste;
	}

	private int agregarReajuste(ReajusteTO reajuste) {
		
		PreparedStatement pstmt = null;
		String query = " INSERT INTO reajuste(id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio, " + 
							" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc, " +
							" fecha_doc, version, es_ultima_version, fecha_creacion, " +
							" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre)" +
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int resp = -1; 
		
		try{
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,reajuste.getIdReajuste() );
			pstmt.setString(2,reajuste.getIdUltimoUsuario() );
			pstmt.setString(3,reajuste.getAlias() );
			pstmt.setString(4,reajuste.getTipoReajuste() );
			pstmt.setString(5,reajuste.getTipoBeneficio() );
			pstmt.setDouble(6,reajuste.getPorcentaje() );
			pstmt.setInt(7,reajuste.getMonto() );
			pstmt.setString(8,reajuste.getTipoDeCalculo() );
			pstmt.setTimestamp(9, new java.sql.Timestamp(reajuste.getFechaInicio().getTime()) );
			pstmt.setString(10,reajuste.getTipoDocumento() );
			pstmt.setString(11,reajuste.getNumeroDocumento() );
			pstmt.setTimestamp(12, new java.sql.Timestamp(reajuste.getFechaDocumento().getTime()) );
			pstmt.setInt(13, 1 ); //Version 1
			pstmt.setBoolean(14, true ); //Es ultima versión
			pstmt.setTimestamp(15, new java.sql.Timestamp(new Date().getTime()) );
			pstmt.setString(16,reajuste.getNumeroOrdenMinisterial() );
			
			if(reajuste.getFechaOrdenMinisterial() != null)
				pstmt.setTimestamp(17, new java.sql.Timestamp(reajuste.getFechaOrdenMinisterial().getTime()) );
			else
				pstmt.setTimestamp(17, null);
			
			pstmt.setBoolean(18,reajuste.getActivo() );
			pstmt.setInt(19, reajuste.getIdReajustePadre() );
			
			resp = pstmt.executeUpdate();
			
			pstmt.close();
			
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;
		
	}
	

	
	@Override
	public int modificarReajusteSectorPasivo(ReajusteTO reajuste) {
		
		int resp = this.actualizarEsUltimaVersion(reajuste.getIdReajuste(), false);
		
		if(resp > 0){
			int idReajuste = this.obtenerSiguienteIdReajuste();
			if(idReajuste > 0){
				reajuste.setIdReajustePadre(reajuste.getIdReajuste());
				reajuste.setIdReajuste(idReajuste);
				resp = this.agregarReajusteModificado(reajuste);
			}
			else
				return idReajuste;
		}
		return resp;
	}
	
	
	@Override
	public int modificarReajusteSectorActivo(ReajusteTO reajuste, List<SueldoBaseTO> sueldosBase, 
			List<ReajusteSectorActivoTO> reajustesSectorActivo) {
		
		int resp = this.actualizarEsUltimaVersion(reajuste.getIdReajuste(), false);
		
		if(resp > 0){
			int idReajuste = this.obtenerSiguienteIdReajuste();
			if(idReajuste > 0){
				reajuste.setIdReajustePadre(reajuste.getIdReajuste());
				reajuste.setIdReajuste(idReajuste);
				resp = this.agregarReajusteModificado(reajuste);
				if(resp > 0){
					resp = this.agregarSueldosBase(sueldosBase, idReajuste);
					if(resp > 0)
						resp = this.agregarReajustesSectorActivo(reajustesSectorActivo, idReajuste);
				}
			}
			else
				return idReajuste;
		}
		return resp;
	}
	
	
	private int agregarReajusteModificado(ReajusteTO reajuste) {
		
		PreparedStatement pstmt = null;
		String query = " INSERT INTO reajuste(id_reajuste, id_ultimo_usuario, alias, tipo_reajuste, tipo_beneficio, " + 
							" porcentaje, monto, tipo_de_calculo, fecha_inicio, tipo_doc, numero_doc, " +
							" fecha_doc, version, es_ultima_version, fecha_creacion, fecha_modificacion, " +
							" numero_orden_min, fecha_orden_min, activo, id_reajuste_padre)" +
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int resp = -1; 
		
		try{
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,reajuste.getIdReajuste() );
			pstmt.setString(2,reajuste.getIdUltimoUsuario() );
			pstmt.setString(3,reajuste.getAlias() );
			pstmt.setString(4,reajuste.getTipoReajuste() );
			pstmt.setString(5,reajuste.getTipoBeneficio() );
			pstmt.setDouble(6,reajuste.getPorcentaje() );
			pstmt.setInt(7,reajuste.getMonto() );
			pstmt.setString(8,reajuste.getTipoDeCalculo() );
			pstmt.setTimestamp(9, new java.sql.Timestamp(reajuste.getFechaInicio().getTime()) );
			pstmt.setString(10,reajuste.getTipoDocumento() );
			pstmt.setString(11,reajuste.getNumeroDocumento() );
			pstmt.setTimestamp(12, new java.sql.Timestamp(reajuste.getFechaDocumento().getTime()) );
			pstmt.setInt(13, reajuste.getVersion() + 1 ); 
			pstmt.setBoolean(14, true ); //Es ultima versión
			pstmt.setTimestamp(15, new java.sql.Timestamp(reajuste.getFechaCreacion().getTime()) );
			pstmt.setTimestamp(16, new java.sql.Timestamp(new Date().getTime())  );
			pstmt.setString(17,reajuste.getNumeroOrdenMinisterial() );
			
			if(reajuste.getFechaOrdenMinisterial() != null)
				pstmt.setTimestamp(18, new java.sql.Timestamp(reajuste.getFechaOrdenMinisterial().getTime()) );
			else
				pstmt.setTimestamp(18, null);
			
			pstmt.setBoolean(19,reajuste.getActivo() );	
			pstmt.setInt(20, reajuste.getIdReajustePadre() );
			
			resp = pstmt.executeUpdate();
			
			pstmt.close();
			
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;
	}
		
	
	private int actualizarEsUltimaVersion(int idReajuste, boolean esUltimaVersion){
		
		PreparedStatement pstmt = null;
		String query = " UPDATE reajuste" +
						" SET es_ultima_version = ?" +
						" WHERE id_reajuste = ?;";
		
		int resp = -1; 
		
		try{
			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, esUltimaVersion);
			pstmt.setInt(2, idReajuste);
		
			resp = pstmt.executeUpdate();
			
			pstmt.close();
			
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;
	}

	private int agregarSueldosBase(List<SueldoBaseTO> sueldosBase, int idReajuste){
				
		PreparedStatement pstmt = null;
				
		String query = " INSERT INTO sueldo_base("+
							" id_reajuste, id_grado_economico, monto) " + 
						" VALUES (?, ?, ?);";
		
		int resp = -1; 
		
		try{
			for(SueldoBaseTO sb:sueldosBase){
				
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, idReajuste);
				pstmt.setInt(2,  sb.getIdGrado() );
				pstmt.setInt(3,  sb.getMonto() );
				
				resp = pstmt.executeUpdate();
				
				if(resp < 0){
					pstmt.close();
					return resp;
				}
			}
			pstmt.close();
			
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;
		
	}
	
	private int agregarReajustesSectorActivo(List<ReajusteSectorActivoTO> reajustesSectorActivo, int idReajuste){
		
		PreparedStatement pstmt = null;
		
		String query = " INSERT INTO reajuste_sector_activo("+
							" id_reajuste, id_especificacion_grado, aege, " + 
							" bonif_riesgo, porcentaje_riesgo, bonif_mando_adm, asig_alto_mando, " +
							"  bonif_comp_con_sob, bonif_comp_sin_sob)" +
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int resp = -1; 
		
		try{
			for(ReajusteSectorActivoTO reajuste:reajustesSectorActivo){
				
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, idReajuste);
				pstmt.setInt(2,  reajuste.getEspecificacionGrado().getIdEspecificacionGrado() );
				pstmt.setInt(3,  reajuste.getAege() );
				pstmt.setInt(4,  reajuste.getBonificacionRiesgo() );
				pstmt.setDouble(5,  reajuste.getporcentajeRiesgo() );
				pstmt.setInt(6,  reajuste.getBonifMandoAdm() );
				pstmt.setInt(7,  reajuste.getAsigAltoMando() );
				pstmt.setInt(8,  reajuste.getBonifCompConSobresueldo() );
				pstmt.setInt(9,  reajuste.getBonifCompSinSobresueldo() );				
				
				resp = pstmt.executeUpdate();
				
				if(resp < 0){
					pstmt.close();
					return resp;
				}
			}
			pstmt.close();
			
		}
		catch (SQLException sqle) {
			UtilLog.registrar(sqle);
		}
		catch (Exception e) {
			UtilLog.registrar(e);
		}
		return resp;	
	}
	
	public int obtenerSiguienteIdReajuste()
	{		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int resp = -1;
		String query = "SELECT nextval('reajuste_id_reajuste_seq') as NEXTVAL";
		
		try
		{						
			pstmt = conn.prepareStatement(query);
						
			rs = pstmt.executeQuery();
			
			if(rs.next())
				resp = rs.getInt("NEXTVAL");
			rs.close();
			pstmt.close();
			
		}
		catch(SQLException sqle){
			UtilLog.registrar(sqle);
		}
		catch (Exception ex) {
			UtilLog.registrar(ex);
		}
		finally{
			if (pstmt != null) {
		          try {
		               pstmt.close();
		               
		          } catch (SQLException e) {
		               e.printStackTrace();
		          }
			}
		}		
		return resp;
	}
	
	public int activarDesactivarReajuste(int idReajuste, boolean activo){
		int resp = -1;
		PreparedStatement pstmt = null;
		
		String query = " UPDATE reajuste " +
					   " SET activo = ?, " +
					   " fecha_modificacion = ? " +
					   " WHERE id_reajuste = ? ";
		
		try{		
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, !activo);
			pstmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime())  );
			pstmt.setInt(3, idReajuste);				
			resp = pstmt.executeUpdate();			
			pstmt.close();
		}
		catch(SQLException sqle){
			UtilLog.registrar(sqle);
		}
		catch (Exception ex) {
			UtilLog.registrar(ex);
		}
		finally{
			if (pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		return resp;
	}
}
