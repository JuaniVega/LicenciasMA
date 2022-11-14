package mvc.controller.gestores;

import java.util.List;

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.model.Administrativo;
import mvc.model.Conductor;
import mvc.model.Persona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;

public class GestorPersona {

	public static List<Persona> obtenerPersonaxDni(int dni) throws Exception{
		return PersonaDao.getPersonaxDni(dni);
	}
	
	public static List<Conductor> obtenerConductorxDni(int dni) throws Exception{
		return PersonaDao.getConductorxDni(dni);
	}
	
	public static List<Administrativo> obtenerAdministrativoxDni(int dni) throws Exception{
		return PersonaDao.getAdministrativoxDni(dni);
	}
	
	public static List<TipoDocumento> obtenerTipoDocumento() throws Exception{
		return PersonaDao.getTipoDocumento();
	}
	
	public static List<TipoGrupoSanguineo> obtenerTipoGrupoSanguineo() throws Exception{
		return PersonaDao.getTipoGrupoSanguineo();
	}
	
	public static void actualizarConductorDonante(EmitirLicenciaDTO emitirLicenciaDTO) {
		PersonaDao.updateConductorDonante(emitirLicenciaDTO.getNumDoc(), emitirLicenciaDTO.getEsDonante());
	}
}
