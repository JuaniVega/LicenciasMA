package mvc.controller.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.model.TipoLicencia;
import util.ConexionP;

public class LicenciaDao {

	public static List<TipoLicencia> getTipoLicencia() throws Exception {
		try {
			String query = "select tl.id from public.tipo_licencia tl ;";                            
			ArrayList<TipoLicencia> tipoLicencia = (ArrayList<TipoLicencia>)((Object) ConexionP.consultar(query, TipoLicencia.class));
			return tipoLicencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	

}
