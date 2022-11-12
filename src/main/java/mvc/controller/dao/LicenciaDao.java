package mvc.controller.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.model.Licencia;
import util.ConexionP;

public class LicenciaDao {

	public static List<Licencia> getAllLicencia() throws Exception {
		try {
			String query = "select l.* from licencia;";                            
			ArrayList<Licencia> licencias = (ArrayList<Licencia>)((Object) ConexionP.consultar(query, Licencia.class));
			return licencias;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	

}
