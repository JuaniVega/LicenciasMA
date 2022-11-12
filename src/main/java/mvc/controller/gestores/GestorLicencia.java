package mvc.controller.gestores;

import java.util.List;

import mvc.controller.dao.TipoLicenciaDao;
import mvc.model.TipoLicencia;

public class GestorLicencia {
	
	public static List<TipoLicencia> obtenerTipoLicencia() throws Exception{
		return TipoLicenciaDao.getTipoLicencia();
	}

}
