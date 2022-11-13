package mvc.model;

import java.time.LocalDate;

public class Administrativo extends Persona{
	
	private String email;
	private String contrasenia;
	
	public Administrativo(Integer id, Integer dni,Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento,String sexo, String email, String contraseña) {
		super(id, dni, tipoDoc, nombre, apellido, fechaNacimiento, sexo);		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	public Administrativo() {
		
	}
	
	public Administrativo(String datos) {
		String[] atributo = datos.split("\t");
		this.idPersona=Integer.parseInt(atributo[0]);
		this.dni=Integer.parseInt(atributo[1]);
		this.tipoDoc=Integer.parseInt(atributo[2]);
		this.nombre=atributo[3];
		this.apellido=atributo[4];
		this.fechaNacimiento=LocalDate.parse(atributo[5]);
		this.email=atributo[6];
		this.contrasenia=atributo[7];
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
