package mvc.controller.dao;

import java.sql.Connection;
import java.util.List;

import mvc.model.Persona;

public class PersonaDaoSQL implements PersonaDao{
	

	private static final String insert_Persona = "select * from persona"; //???
	
	public Persona agregarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> buscarTodasLasPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona personaPorDNI(Integer dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
