package mvc.model;

import java.time.LocalDate;

public class Administrativo extends Persona{
	
	private String email;
	private String contrasenia;
	

	public Administrativo() {
		super();
	}
	
	public Administrativo(Integer id, Integer dni, Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String sexo, String email, String contrasenia) {
		super(id, dni, tipoDoc, nombre, apellido, fechaNacimiento, sexo);		
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	
	
}