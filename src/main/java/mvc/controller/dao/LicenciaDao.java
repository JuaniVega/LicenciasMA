package mvc.controller.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Licencia;
import mvc.model.TipoLicencia;
import util.ConexionP;

public class LicenciaDao {


	public static List<TipoLicencia> getTipoLicencia() throws Exception {
		try {
			String query = "select tl.id from public.tipo_licencia tl ;";                            
			ArrayList<TipoLicencia> tipoLicencia = (ArrayList<TipoLicencia>)((Object) ConexionP.consultar(query, TipoLicencia.class));
			return tipoLicencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	
	public static List<Licencia> getAllLicencia() throws Exception {
		try {
			String query = "select id, id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia from public.licencia;";
			ArrayList<Licencia> licencias = (ArrayList<Licencia>)((Object) ConexionP.consultar(query, Licencia.class));
			return licencias;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Licencia> getLicenciaxDni(int dni) throws Exception {
		try {
			String query = "SELECT id, id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia, observaciones FROM public.licencia where id_persona ="+dni+";";                            
			ArrayList<Licencia> licencia = (ArrayList<Licencia>)((Object) ConexionP.consultar(query, Licencia.class));
			return licencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Licencia> getLicenciaxDnixTipo(int dni, int tipo) throws Exception {
		try {
			String query = "SELECT id, id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia, observaciones FROM public.licencia where id_persona ="+dni+" and id_tipo_licencia ="+tipo+" order by fecha_emision ASC;";                            
			ArrayList<Licencia> licencia = (ArrayList<Licencia>)((Object) ConexionP.consultar(query, Licencia.class));
			return licencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public static void newLicencia(Licencia licencia) {
		
		String query= "INSERT INTO public.licencia (id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia, usuario, observaciones) VALUES("+licencia.getIdPersona()+", "+licencia.getIdTipoLicencia()+", "+licencia.getCosto()+", '"+licencia.getFechaEmision()+"', '"+licencia.getFechaVigencia()+"', "+licencia.getEsCopia()+", "+licencia.getEstaVigente()+", 'aaa', "+licencia.getObservaciones()+"'.');";
		
		Connection con = ConexionP.conectarDB();
		try {
			//Comienza transacción
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
			//Comienza transacción
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
