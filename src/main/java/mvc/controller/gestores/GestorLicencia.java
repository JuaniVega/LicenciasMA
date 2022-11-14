package mvc.controller.gestores;

import java.util.ArrayList;
import java.util.List;

import mvc.controller.dao.LicenciaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.model.Licencia;import mvc.model.TipoLicencia;

public class GestorLicencia {
	
	public static List<TipoLicencia> obtenerTipoLicencia() throws Exception{
		return LicenciaDao.getTipoLicencia();
	}
	
	public static List<Licencia> obtenerLicenciaxDni(int dni) throws Exception{
		return LicenciaDao.getLicenciaxDni(dni);
	}
	
	public static List<Licencia> obtenerLicenciaxDnixTipo(int dni, int tipo) throws Exception{
		return LicenciaDao.getLicenciaxDnixTipo(dni, tipo);
	}
	
	public static void crearLicencia(EmitirLicenciaDTO emitirLicenciaDTO) throws Exception{
		for(int i=0; i<emitirLicenciaDTO.getLicenciasSeleccionadas().size();i++) {
			
			Licencia licencia = new Licencia();
			
			licencia.setIdPersona(emitirLicenciaDTO.getNumDoc());
			licencia.setIdTipoLicencia(emitirLicenciaDTO.getLicenciasSeleccionadas().get(i));
			licencia.setCosto(emitirLicenciaDTO.getCosto());
			licencia.setFechaEmision(emitirLicenciaDTO.getFechaEmision());
			licencia.setFechaVigencia(emitirLicenciaDTO.getFechaVigencia());
			licencia.setEsCopia(emitirLicenciaDTO.getEsCopia());
			actualizarVigencia(licencia.getIdPersona(), licencia.getIdTipoLicencia());
			licencia.setEstaVigente(emitirLicenciaDTO.getEstaVigente());
			licencia.setObservaciones(emitirLicenciaDTO.getObservaciones());
			
			LicenciaDao.newLicencia(licencia);
		}
	}

	private static void actualizarVigencia(Integer idPersona, Integer idTipoLicencia) throws Exception {
		List<Licencia> licencias=LicenciaDao.getLicenciaxDni(idPersona);
		ArrayList<Integer> idLicencias= new ArrayList<Integer>();
		
		for(int i=0; i<licencias.size();i++) {
			if(licencias.get(i).getIdTipoLicencia()==idTipoLicencia && licencias.get(i).getEstaVigente()==true) {
				idLicencias.add(licencias.get(i).getIdLicencia());
			}
		}
		LicenciaDao.updateVigenciaLicencia(idLicencias, false);
	}

	public static List<Licencia> obtenerAllLicencias() throws Exception{
		return LicenciaDao.getAllLicencia();
	}}
