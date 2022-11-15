package mvc.model;

import java.time.LocalDate;

public class Persona {
	
	protected Integer idPersona;
	protected Integer dni;
	protected Integer tipoDoc;
	protected String nombre; 
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected String sexo;
	
	public Persona() {
		super();
	}

	public Persona(Integer idPersona, Integer dni, Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String sexo) {
		super();
		this.dni			 = dni;
		this.tipoDoc 		 = tipoDoc;
		this.nombre 		 = nombre;
		this.apellido 		 = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo 			 = sexo;
	}
	
	public Integer getId() {
		return idPersona;
	}

	public void setId(Integer id) {
		this.idPersona = id;
	}

	public Integer getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	//1=Masculino 2=Femenino
	public Integer getCodSexo() {
		if(sexo.equals("M")) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		if(sexo.equals(1)) {
			this.sexo="M";
		}else{
			this.sexo="F";
		}
	}
	
	
	

}