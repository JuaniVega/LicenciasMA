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
	
	public Persona(Integer idPersona, Integer dni, Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String sexo) {
		super();
		this.idPersona = idPersona;
		this.dni=dni;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
	
	public Persona(String datos) {
		String[] atributo = datos.split("\t");
		this.idPersona=Integer.parseInt(atributo[0]);
		this.dni=Integer.parseInt(atributo[1]);
		this.tipoDoc=Integer.parseInt(atributo[2]);
		this.nombre=atributo[3];
		this.apellido=atributo[4];
		this.fechaNacimiento=LocalDate.parse(atributo[5]);
		this.sexo=atributo[6];
		
	}

	public Persona() {
		super();
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