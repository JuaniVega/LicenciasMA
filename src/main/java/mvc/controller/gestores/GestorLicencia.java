package mvc.controller.gestores;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import mvc.controller.dao.LicenciaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.model.Costo;
import mvc.model.Licencia;
import mvc.model.Persona;
import mvc.model.TipoLicencia;
import mvc.model.Vigencia;

public class GestorLicencia {
	
	public static List<TipoLicencia> obtenerTiposLicencias() throws Exception{
		return LicenciaDao.getTiposLicencias();
	}

	public static TipoLicencia obtenerTipoLicencia(int idTipoLicencia) throws Exception{
		return LicenciaDao.getTipoLicencia(idTipoLicencia);
	}
	
	public static List<Vigencia> obtenerVigencias() throws Exception{
		return LicenciaDao.getVigencias();
	}
	
	public static List<Licencia> obtenerLicenciaxDni(int dni) throws Exception{
		return LicenciaDao.getLicenciaxDni(dni);
	}
	
	public static List<Licencia> obtenerLicenciaVigentexDni(int dni) throws Exception{
		return LicenciaDao.getLicenciaVigentexDni(dni);
	}
	
	public static List<Licencia> obtenerLicenciaVigentexPersona(List<Persona> personas) throws Exception{
		return LicenciaDao.getLicenciaVigentexPersona(personas);
	}
	
	public static List<Licencia> obtenerLicenciasExpiradas() throws Exception{
		return LicenciaDao.getLicenciasLicenciasExpiradas();
	}
	
	public static List<Licencia> obtenerLicenciaxDnixTipo(int dni, int tipo) throws Exception{
		return LicenciaDao.getLicenciaxDnixTipo(dni, tipo);
	}
	
	public static List<Costo> obtenerCostoxClasexAnio(String clase, int anios) throws Exception{
		return LicenciaDao.getCostoxClasexAnio(clase, anios);
	}
	
	public static void actualizarNumCopia(EmitirLicenciaDTO emitirLicenciaDTO) {
		int dni;
		int tipoLicencia;
		int valNuevaCopia;
		
		dni = emitirLicenciaDTO.getNumDoc();
		tipoLicencia = emitirLicenciaDTO.getIntLicenciasSeleccionadas().get(0);
		valNuevaCopia = emitirLicenciaDTO.getNumCopia();
		LicenciaDao.updateNumCopia( dni, tipoLicencia, valNuevaCopia);
	}
	
	public static void actualizarVigenciasDesactualizadas() {
		LicenciaDao.updateVigenciasDesactualizadas();
	}
	
	public static void crearLicencia(EmitirLicenciaDTO emitirLicenciaDTO) throws Exception{
		for(int i=0; i<emitirLicenciaDTO.getLicenciasSeleccionadas().size();i++) {
			
			Licencia licencia = new Licencia();
			
			licencia.setIdPersona(emitirLicenciaDTO.getNumDoc());
			licencia.setIdTipoLicencia(emitirLicenciaDTO.getIntLicenciasSeleccionadas().get(i));
			licencia.setCosto(emitirLicenciaDTO.getCosto().get(i));
			licencia.setCosto(emitirLicenciaDTO.getCosto().get(i));
			licencia.setFechaEmision(emitirLicenciaDTO.getFechaEmision());
			licencia.setFechaVigencia(emitirLicenciaDTO.getFechaVigencia());
			licencia.setEsCopia(emitirLicenciaDTO.getEsCopia());
			actualizarVigencia(licencia.getIdPersona(), licencia.getIdTipoLicencia());
			licencia.setEstaVigente(emitirLicenciaDTO.getEstaVigente());
			licencia.setObservaciones(emitirLicenciaDTO.getObservaciones());
			licencia.setNumCopia(emitirLicenciaDTO.getNumCopia());
			
			LicenciaDao.newLicencia(licencia);
		}
	}


	public static void renovarLicencia(Persona per , Licencia lic) throws Exception{
		
		actualizarVigencia(per.getId(),lic.getIdLicencia());
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
	}


	public static LocalDate calculoVigencia(LocalDate fechaNacimiento, Integer dni) throws Exception{
		List<Vigencia> listaVigencias = obtenerVigencias();
		Integer vigencia=0;
		LocalDate fechaVigencia= null;
		LocalDate fechaActual= LocalDate.now();
		Period periodEdad = Period.between(fechaNacimiento, fechaActual);
		Integer edad= periodEdad.getYears();
		
		Integer difMeses= 12-periodEdad.getMonths();
		
		//Calcula cantidad de a?os por los que se va a emitir.
		if(edad>=17 && edad<21) {
			List<Licencia> licencias= LicenciaDao.getLicenciaxDni(dni);
			if(licencias.size()==0) {
				vigencia=listaVigencias.get(0).getVigencia();
			}else {
				vigencia=listaVigencias.get(1).getVigencia();
			}
		}else if (edad<46) {
			vigencia=listaVigencias.get(2).getVigencia();
		}else if (edad<60) {
			vigencia=listaVigencias.get(3).getVigencia();
		}else if (edad<70) {
			vigencia=listaVigencias.get(4).getVigencia();
		}else if (edad>=70) {
			vigencia=listaVigencias.get(5).getVigencia();
		}
		
		
		//Calcula diferencia de fecha actual con cumplea?os para definir tiempo en a?os y meses.
		if(difMeses<6) {
			//A la vigencia le sumo los meses de diferencia
			Integer anio=fechaActual.getYear()+vigencia;
			Integer mes=fechaActual.getMonth().getValue()+difMeses;
			if(mes>12) {
				mes=mes-12;
				anio=anio+1;
			}
			Integer dia=fechaNacimiento.getDayOfMonth();
			fechaVigencia = LocalDate.of(anio, mes, dia);
		}else {
			//A la vigencia le resto 1 y le sumo los meses de diferencia
			Integer anio=fechaActual.getYear()+vigencia-1;
			Integer mes=fechaActual.getMonth().getValue()+difMeses;
			if(mes>12) {
				mes=mes-12;
				anio=anio+1;
			}
			Integer dia=fechaNacimiento.getDayOfMonth();
			fechaVigencia = LocalDate.of(anio, mes, dia);		
			}
		
		return fechaVigencia;
	}
	
	public static Integer calculoAniosVigencia(LocalDate fechaNacimiento, Integer dni) throws Exception {
		List<Vigencia> listaVigencias = obtenerVigencias();
		Integer vigencia=0;
		LocalDate fechaActual= LocalDate.now();
		Period periodEdad = Period.between(fechaNacimiento, fechaActual);
		Integer edad= periodEdad.getYears();
		
		Integer difMeses= 12-periodEdad.getMonths();
		
		//Calcula cantidad de a�os por los que se va a emitir.
		if(edad>=17 && edad<21) {
			List<Licencia> licencias= LicenciaDao.getLicenciaxDni(dni);
			if(licencias.size()==0) {
				vigencia=listaVigencias.get(0).getVigencia();
			}else {
				vigencia=listaVigencias.get(1).getVigencia();
			}
		}else if (edad<46) {
			vigencia=listaVigencias.get(2).getVigencia();
		}else if (edad<60) {
			vigencia=listaVigencias.get(3).getVigencia();
		}else if (edad<70) {
			vigencia=listaVigencias.get(4).getVigencia();
		}else if (edad>=70) {
			vigencia=listaVigencias.get(5).getVigencia();
		}
		
		return vigencia;
	}
	
}