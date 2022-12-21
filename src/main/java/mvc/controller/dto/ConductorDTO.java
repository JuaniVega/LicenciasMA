package mvc.controller.dto;

import java.time.LocalDate;

public class ConductorDTO {
	private String nombre;
	private String apellido;
	private String calle;
	private Integer numcalle;
	private String depto;
	private Integer piso;
	private Integer sexo;
	private Integer dni;
	private Integer tipoDoc;
	private LocalDate fechaNacimiento;
	private Integer grupoSang;
	private Boolean esDonante;
	
	private String nombreUsuAdmin;
	private String apellidoUsuAdmin;
	private String usuAdmin;
	
	
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
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumCalle() {
		return numcalle;
	}
	public void setNumCalle(int numcalle) {
		this.numcalle = numcalle;
	}
	public String getDpto() {
		return depto;
	}
	public void setDpto(String depto) {
		this.depto = depto;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public Integer getSexo() {
		return sexo;
	}
	public String getCodSexo() {
		if(sexo.equals(1)) {
			return "M";
		}else{
			return "F";
		}
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Integer getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Integer getGrupoSang() {
		return grupoSang;
	}
	public void setGrupoSang(Integer grupoSang) {
		this.grupoSang = grupoSang;
	}
	public Boolean getEsDonante() {
		return esDonante;
	}
	public void setEsDonante(Boolean esDonante) {
		this.esDonante = esDonante;
	}
	public String getNombreUsuAdmin() {
		return nombreUsuAdmin;
	}
	public void setNombreUsuAdmin(String nombreUsuAdmin) {
		this.nombreUsuAdmin = nombreUsuAdmin;
	}
	public String getApellidoUsuAdmin() {
		return apellidoUsuAdmin;
	}
	public void setApellidoUsuAdmin(String apellidoUsuAdmin) {
		this.apellidoUsuAdmin = apellidoUsuAdmin;
	}
	public String getUsuAdmin() {
		return nombreUsuAdmin+" "+apellidoUsuAdmin;
	}
	

}
