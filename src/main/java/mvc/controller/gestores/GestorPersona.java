package mvc.controller.gestores;

import java.util.List;

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.dto.ConductorDTO;
import mvc.model.Administrativo;
import mvc.model.Conductor;
import mvc.model.Persona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;

public class GestorPersona {

	public static List<Persona> obtenerPersonaxDni(int dni) throws Exception{
		return PersonaDao.getPersonaxDni(dni);
	}
	
	public static List<Persona> obtenerPersonaxNombre(String nombre) throws Exception{
		return PersonaDao.getPersonaxNombre(nombre);
	}
	
	public static List<Persona> obtenerPersonaxApellido(String apellido) throws Exception{
		return PersonaDao.getPersonaxApellido(apellido);
	}
	
	public static List<Persona> obtenerPersonaxGrupoSanguineo(int grupoS) throws Exception{
		return PersonaDao.getPersonaxGrupoSanguineo(grupoS);
	}
	
	public static List<Persona> obtenerPersonaxEsDonante(boolean esDonante) throws Exception{
		return PersonaDao.getPersonaxEsDonante(esDonante);
	}
	
	public static List<Conductor> obtenerConductorxDni(int dni) throws Exception{
		return PersonaDao.getConductorxDni(dni);
	}
	
	public static List<Administrativo> obtenerAdministrativoxDni(int dni) throws Exception{
		return PersonaDao.getAdministrativoxDni(dni);
	}
	
	public static List<TipoDocumento> obtenerTiposDocumentos() throws Exception{
		return PersonaDao.getTiposDocumentos();
	}

	public static TipoDocumento obtenerTipoDocumento(int tipoDoc) throws Exception{
		return PersonaDao.getTipoDocumento(tipoDoc);
	}
	
	public static List<TipoGrupoSanguineo> obtenerTiposGrupoSanguineos() throws Exception{
		return PersonaDao.getTiposGrupoSanguineos();
	}

	public static TipoGrupoSanguineo obtenerTipoGrupoSanguineo(int tipoGrupSang) throws Exception{
		return PersonaDao.getTipoGrupoSanguineo(tipoGrupSang);
	}
	
	;
	public static List<Persona> obtenerPersonasxListaDni(List<Integer> listaDniLicencia) throws Exception{
		return PersonaDao.getPersonasxListaDni(listaDniLicencia);
	}
	
	public static void actualizarConductorDonante(EmitirLicenciaDTO emitirLicenciaDTO) {
		PersonaDao.updateConductorDonante(emitirLicenciaDTO.getNumDoc(), emitirLicenciaDTO.getEsDonante());
	}
	public static void actualizarDatosConductor(ConductorDTO personaDTO, int dni) {
		PersonaDao.updateDatosConductor(personaDTO, dni);
	}
	
	public static List<Persona> iniciarSesion(String usu, String cont) throws Exception {
		return PersonaDao.login(usu, cont);
	}
	
	public static void crearConductor(ConductorDTO conductorDTO) throws Exception{
		Conductor conductor = new Conductor();
		String usuAdmin;
		
		conductor.setNombre(conductorDTO.getNombre());
		conductor.setApellido(conductorDTO.getApellido());
		conductor.setTipoDoc(conductorDTO.getTipoDoc());
		conductor.setDni(conductorDTO.getDni());
		conductor.setDireccion(conductorDTO.getCalle());
		conductor.setNumDir(conductorDTO.getNumCalle());
		conductor.setPiso(conductorDTO.getPiso());
		conductor.setDpto(conductorDTO.getDpto());
		conductor.setFechaNacimiento(conductorDTO.getFechaNacimiento());
		conductor.setTipoGrupoSanguineo(conductorDTO.getGrupoSang());
		conductor.setDonaOrganos(conductorDTO.getEsDonante());
		conductor.setSexo(conductorDTO.getSexo());
		
		usuAdmin = conductorDTO.getUsuAdmin();
		
		PersonaDao.newConductor(conductor, usuAdmin);
	}
}
