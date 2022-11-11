package mvc.controller.dao;

import java.util.List;

import mvc.model.Persona;

public interface PersonaDao {
	
	public Persona agregarPersona(Persona persona);
	public List<Persona> buscarTodasLasPersonas();
	public Persona personaPorDNI(Integer dni);

}
