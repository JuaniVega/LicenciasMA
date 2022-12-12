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
		ArrayList<Persona> persona = new ArrayList<Persona>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p where p.dni="+dni+";";   
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Persona person = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				persona.add(person);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return persona;
	}
	
	public static List<Persona> getPersonaxNombre(String nombre) throws Exception {
		ArrayList<Persona> persona = new ArrayList<Persona>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p where p.nombre='"+nombre+"';";   
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Persona person = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				persona.add(person);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return persona;
	}
	
	public static List<Persona> getPersonaxApellido(String apellido) throws Exception {
		ArrayList<Persona> persona = new ArrayList<Persona>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p where p.apellido='"+apellido+"';";   
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Persona person = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				persona.add(person);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return persona;
	}
	
	public static List<Persona> getPersonaxGrupoSanguineo(int grupoSang) throws Exception {
		ArrayList<Persona> persona = new ArrayList<Persona>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p inner join public.conductor c on p.dni = c.dni where c.grupo_sanguineo ="+grupoSang+";";   
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Persona person = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				persona.add(person);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return persona;
	}
	
	public static List<Persona> getPersonaxEsDonante(boolean esDonante) throws Exception {
		ArrayList<Persona> persona = new ArrayList<Persona>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p inner join public.conductor c on p.dni = c.dni where c.dona_organos  ="+esDonante+";";   
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Persona person = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				persona.add(person);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return persona;
	}
	
	public static List<Conductor> getConductorxDni(int dni) throws Exception {
		ArrayList<Conductor> conductor = new ArrayList<Conductor>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, c.direccion, c.num_dir, c.piso, c.departamento, c.grupo_sanguineo, c.dona_organos, p.sexo  from public.persona p inner join public.conductor c on p.dni=c.dni  where p.dni="+dni+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Conductor conduc = new Conductor(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"), rs.getString("direccion"), rs.getInt("num_dir"), rs.getInt("piso"), rs.getString("departamento"), rs.getInt("grupo_sanguineo"), rs.getBoolean("dona_organos"));
				conductor.add(conduc);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return conductor;
	}
	
	public static List<Administrativo> getAdministrativoxDni(int dni) throws Exception {
		ArrayList<Administrativo> administrativo= new ArrayList<Administrativo>();
		try {
			String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo, a.email, a.pass from public.persona p inner join public.administrativo a on p.dni=a.dni where p.dni="+dni+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				Administrativo admin = new Administrativo(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"), rs.getString("email"), rs.getString("pass"));
				administrativo.add(admin);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return administrativo;
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
	
	public static TipoDocumento getTipoDocumento(int idTipoDoc) throws Exception {
		TipoDocumento tipoDocumento = new TipoDocumento();
		try {
			String query = "select td.id, td.tipo_doc, td.descripcion from public.tipo_documento td where td.id ="+idTipoDoc+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				tipoDocumento = new TipoDocumento(rs.getInt("id"),rs.getString("tipo_doc"), rs.getString("descripcion"));
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoDocumento;
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

	public static TipoGrupoSanguineo getTipoGrupoSanguineo(int idTipoGrupSang) throws Exception {
		TipoGrupoSanguineo tipoGrupSang = new TipoGrupoSanguineo();
		try {
			String query = "select tgs.id, tgs.tipo_grupo_sanguineo from public.tipo_grupo_sanguineo tgs where tgs.id ="+idTipoGrupSang+";";                            
			ResultSet rs = ConexionP.consultarDatos(query);
			while(rs.next()) {
				tipoGrupSang = new TipoGrupoSanguineo(rs.getInt("id"),rs.getString("tipo_grupo_sanguineo"));
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return tipoGrupSang;
	}
	
	public static List<Persona> getPersonasxListaDni(List<Integer> listaDniLicencia) throws Exception {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Persona persona = new Persona();
		try {
			for(int i=0; i<listaDniLicencia.size();i++) {
				String query = "select p.id, p.dni, p.tipo_doc, p.nombre, p.apellido, p.fecha_nacimiento, p.sexo from public.persona p where p.dni="+listaDniLicencia.get(i)+";";                            
				ResultSet rs = ConexionP.consultarDatos(query);
				while(rs.next()) {
					persona = new Persona(rs.getInt("id"), rs.getInt("dni"), rs.getInt("tipo_doc"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("sexo"));
				}
				listaPersonas.add(persona);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		return listaPersonas;
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
