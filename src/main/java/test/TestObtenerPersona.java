package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import mvc.controller.dao.PersonaDao;
import mvc.model.Persona;


public class TestObtenerPersona {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		PersonaDao persona = new PersonaDao();
		int dni = 41216693;
		List<Persona> list = new ArrayList<Persona>();
		
		list= persona.getPersonaxDni(dni);
		Integer i= list.get(0).getDni();
		System.out.println(i);
		Integer dniprueba= 41216693; 
		assertEquals(dniprueba, i); 
		
	}

}
