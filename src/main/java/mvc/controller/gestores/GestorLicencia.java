package mvc.controller.gestores;

import java.util.List;

import mvc.controller.dao.LicenciaDao;
import mvc.model.Licencia;
import mvc.model.TipoLicencia;

public class GestorLicencia {
	
	public static List<TipoLicencia> obtenerTipoLicencia() throws Exception{
		return LicenciaDao.getTipoLicencia();
	}

	public static List<Licencia> obtenerAllLicencias() throws Exception{
		return LicenciaDao.getAllLicencia();
	}

}
