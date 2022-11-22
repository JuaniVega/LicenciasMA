package mvc.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Licencia;
import mvc.model.TipoLicencia;
import mvc.model.Vigencia;
import util.ConexionP;

public class LicenciaDao {

	public static List<TipoLicencia> getTiposLicencias() throws Exception {
		ArrayList<TipoLicencia> tipoLicencia = new ArrayList<TipoLicencia>();
		try {
			String query = "select tl.id, tl.clase, tl.descripcion from public.tipo_licencia tl ;";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				TipoLicencia tipoLic = new TipoLicencia(rs.getInt("id"),rs.getString("clase"),rs.getString("descripcion"));
				tipoLicencia.add(tipoLic);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoLicencia;
	}

	public static TipoLicencia getTipoLicencia(int idTipoLicencia) throws Exception {
		TipoLicencia tipoLicencia = new TipoLicencia();
		try {
			String query = "select tl.id, tl.clase, tl.descripcion from public.tipo_licencia tl where tl.id ="+idTipoLicencia+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				tipoLicencia = new TipoLicencia(rs.getInt("id"),rs.getString("clase"),rs.getString("descripcion"));
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoLicencia;
	}
	
	public static List<Vigencia> getVigencias() throws Exception {
		ArrayList<Vigencia> vigencias = new ArrayList<Vigencia>();
		try {
			String query = "select v.id, v.vigencia, v.descripcion from public.vigencia v ;";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Vigencia vig = new Vigencia(rs.getInt("id"),rs.getInt("vigencia"),rs.getString("descripcion"));
				vigencias.add(vig);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return vigencias;
	}

	public static List<Licencia> getAllLicencia() throws Exception {
		ArrayList<Licencia> licencias = new ArrayList<Licencia>();
		try {
			String query = "select l.id, l.id_persona, l.id_tipo_licencia, l.costo, l.fecha_emision, l.fecha_vigencia, l.es_copia, l.estado_licencia, l.observaciones, from public.licencia l;";
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Licencia licencia = new Licencia(rs.getInt("id"), rs.getInt("id_persona"), rs.getInt("id_tipo_licencia"), rs.getInt("costo"), rs.getDate("fecha_emision").toLocalDate(), rs.getDate("fecha_vigencia").toLocalDate(), rs.getBoolean("es_copia"), rs.getBoolean("estado_licencia"), rs.getString("observaciones"));
				licencias.add(licencia);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return licencias;
	}
	
	public static List<Licencia> getLicenciaxDni(int dni) throws Exception {
		ArrayList<Licencia> licencia = new ArrayList<Licencia>();
		try {
			String query = "select l.id, l.id_persona, l.id_tipo_licencia, l.costo, l.fecha_emision, l.fecha_vigencia, l.es_copia, l.estado_licencia, l.observaciones from public.licencia l where id_persona ="+dni+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Licencia lic = new Licencia(rs.getInt("id"), rs.getInt("id_persona"), rs.getInt("id_tipo_licencia"), rs.getInt("costo"), rs.getDate("fecha_emision").toLocalDate(), rs.getDate("fecha_vigencia").toLocalDate(), rs.getBoolean("es_copia"), rs.getBoolean("estado_licencia"), rs.getString("observaciones"));
				licencia.add(lic);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return licencia;
	}
	
	public static List<Licencia> getLicenciaxDnixTipo(int dni, int tipo) throws Exception {
		ArrayList<Licencia> licencia = new ArrayList<Licencia>();
		try {
			String query = "select l.id, l.id_persona, l.id_tipo_licencia, l.costo, l.fecha_emision, l.fecha_vigencia, l.es_copia, l.estado_licencia, l.observaciones from public.licencia l where l.id_persona ="+dni+" and l.id_tipo_licencia ="+tipo+" order by fecha_emision ASC;";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Licencia lic = new Licencia(rs.getInt("id"), rs.getInt("id_persona"), rs.getInt("id_tipo_licencia"), rs.getInt("costo"), rs.getDate("fecha_emision").toLocalDate(), rs.getDate("fecha_vigencia").toLocalDate(), rs.getBoolean("es_copia"), rs.getBoolean("estado_licencia"), rs.getString("observaciones"));
				licencia.add(lic);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return licencia;
	}

	public static void newLicencia(Licencia licencia) {
		
		String query= "INSERT INTO public.licencia (id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia, usuario, observaciones) VALUES("+licencia.getIdPersona()+", "+licencia.getIdTipoLicencia()+", "+licencia.getCosto()+", '"+licencia.getFechaEmision()+"', '"+licencia.getFechaVigencia()+"', "+licencia.getEsCopia()+", "+licencia.getEstaVigente()+", 'aaa', "+licencia.getObservaciones()+"'.');";
		
		Connection con = ConexionP.conectarDB();
		try {
			//Comienza transacci�n
			con.setAutoCommit(false);
			
			con.createStatement().executeUpdate(query);
			
			con.commit();
		}
		catch (Exception e) {
		System.err.println("ERROR: " + e.getMessage());
		try {
			//deshace todos los cambios realizados en los datos
			con.rollback();
			} catch (SQLException ex1) {
				System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
				}
		}
	}    
	
	public static void updateVigenciaLicencia (ArrayList<Integer> licencias, boolean vigencia) {
		
		Connection con = ConexionP.conectarDB();
		try {
			//Comienza transacci�n
			con.setAutoCommit(false);
			
			for(int i=0; i<licencias.size();i++) {
				String query = "update public.licencia set estado_licencia ="+vigencia+" where id ="+licencias.get(i)+";";
				
				con.createStatement().executeUpdate(query);
				
				con.commit();
			}
		}
		catch (Exception e) {
		System.err.println("ERROR: " + e.getMessage());
		try {
			//deshace todos los cambios realizados en los datos
			con.rollback();
			} catch (SQLException ex1) {
				System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
				}
		}
		
	}
	

}
