package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import mvc.controller.dao.LicenciaDao;
import mvc.controller.gestores.GestorLicencia;
import mvc.model.Costo;


public class Prueba {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {

		LicenciaDao licencia = new LicenciaDao();
		String clase= "A";
		int anio = 5;
		List<Costo> list = new ArrayList<Costo>();
		list= licencia.getCostoxClasexAnio(clase, anio);
		Integer i= list.get(0).getCosto();
		Integer a= 20; 
		assertEquals(a, i); 

	}

}
