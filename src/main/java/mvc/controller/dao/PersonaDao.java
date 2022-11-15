package mvc.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Administrativo;
import mvc.model.Conductor;
import mvc.model.Persona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;
import util.ConexionP;

public class PersonaDao {
	public static List<Persona> getPersonaxDni(int dni) throws Exception {
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo  from public.persona p where p.dni="+dni+";";                            
			ArrayList<Persona> persona = (ArrayList<Persona>)((Object)ConexionP.consultar(query, Persona.class));
			return persona;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Conductor> getConductorxDni(int dni) throws Exception {
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, c.direccion, c.num_dir, c.piso, c.departamento, c.grupo_sanguineo, c.dona_organos, p.sexo  from public.persona p inner join public.conductor c on p.dni=c.dni  where p.dni="+dni+";";                            
			ArrayList<Conductor> conductor = (ArrayList<Conductor>)((Object)ConexionP.consultar(query, Conductor.class));
			return conductor;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Administrativo> getAdministrativoxDni(int dni) throws Exception {
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, a.email, a.pass from public.persona p inner join public.administrativo a on p.dni=a.dni where p.dni="+dni+";";                            
			ArrayList<Administrativo> admin = (ArrayList<Administrativo>)((Object)ConexionP.consultar(query, Administrativo.class));
			return admin;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<TipoDocumento> getTiposDocumentos() throws Exception {
		List<TipoDocumento> tipoDoc = new ArrayList<TipoDocumento>();
		try {
			String query = "select td.id, td.tipo_doc, td.descripcion from public.tipo_documento td;";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				TipoDocumento tipoDocumento = new TipoDocumento(rs.getInt("id"),rs.getString("tipo_doc"), rs.getString("descripcion"));
				tipoDoc.add(tipoDocumento);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoDoc;
	}
	
	public static List<TipoGrupoSanguineo> getTiposGrupoSanguineos() throws Exception {
		List<TipoGrupoSanguineo> tipoGrupSang = new ArrayList<TipoGrupoSanguineo>();
		try {
			String query = "select tgs.id, tgs.tipo_grupo_sanguineo from public.tipo_grupo_sanguineo tgs;";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				TipoGrupoSanguineo tipoGS = new TipoGrupoSanguineo(rs.getInt("id"),rs.getString("tipo_grupo_sanguineo"));
				tipoGrupSang.add(tipoGS);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoGrupSang;
	}
	
	public static void updateConductorDonante (Integer doc, boolean esDonante) {
		
		Connection con = ConexionP.conectarDB();
		try {
			//Comienza transacci�n
			con.setAutoCommit(false);
				
			String query = "update public.conductor set dona_organos ="+esDonante+" where dni ="+doc+";";
				
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
}
