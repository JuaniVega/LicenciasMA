package mvc.controller.dao;

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
	
	public static List<TipoDocumento> getTipoDocumento() throws Exception {
		try {
			String query = "select td.id from public.tipo_documento td;";                            
			ArrayList<TipoDocumento> tipoDoc = (ArrayList<TipoDocumento>)((Object)ConexionP.consultar(query, TipoDocumento.class));
			return tipoDoc;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<TipoGrupoSanguineo> getTipoGrupoSanguineo() throws Exception {
		try {
			String query = "select tgs.id  from public.tipo_grupo_sanguineo tgs;";                            
			ArrayList<TipoGrupoSanguineo> tipoGrupoSang = (ArrayList<TipoGrupoSanguineo>)((Object)ConexionP.consultar(query, TipoGrupoSanguineo.class));
			return tipoGrupoSang;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}
