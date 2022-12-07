package mvc.controller.gestores;

import java.util.List;

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.dto.PersonaDTO;
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
	
	public static void actualizarConductorDonante(EmitirLicenciaDTO emitirLicenciaDTO) {
		PersonaDao.updateConductorDonante(emitirLicenciaDTO.getNumDoc(), emitirLicenciaDTO.getEsDonante());
	}
	public static void actualizarDatosConductor(PersonaDTO personaDTO, int dni) {
		PersonaDao.updateDatosConductor(personaDTO, dni);
	}
}
