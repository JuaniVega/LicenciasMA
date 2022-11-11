package mvc.model;

import java.sql.Date;

public class Persona {
	
	private String nombre;
    private String apellido;
    private String dni;
    private TipoDocumento tipo_doc;
    private Date fecha_nacimiento;
    
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public TipoDocumento getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(TipoDocumento tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
    
    
    
}
