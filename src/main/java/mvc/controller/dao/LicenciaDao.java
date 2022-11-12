package mvc.controller.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.model.Licencia;
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

	
	public static List<Licencia> getAllLicencia() throws Exception {
		try {
			String query = "select id, id_persona, id_tipo_licencia, costo, fecha_emision, fecha_vigencia, es_copia, estado_licencia from public.licencia;";
			ArrayList<Licencia> licencias = (ArrayList<Licencia>)((Object) ConexionP.consultar(query, Licencia.class));
			return licencias;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	

}
