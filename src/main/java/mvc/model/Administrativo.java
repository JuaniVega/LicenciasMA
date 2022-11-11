package mvc.model;

import java.time.LocalDate;

public class Administrativo extends Persona{
	
	private String email;
	private String contraseña;
	
	public Administrativo(Integer id, Integer dni,Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String email, String contraseña) {
		super(id, dni, tipoDoc, nombre, apellido, fechaNacimiento);
		this.email = email;
		this.contraseña = contraseña;
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
		this.contraseña=atributo[7];
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
}
