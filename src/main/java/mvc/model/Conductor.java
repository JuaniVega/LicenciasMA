package mvc.model;

import java.time.LocalDate;

public class Conductor extends Persona {
	
	private String direccion;
	private Integer numDir;
	private Integer piso;
	private String dpto;
	private Integer tipoGrupoSanguineo;
	private Boolean donaOrganos;
	
	public Conductor() {
		super();
	}
	
	public Conductor(Integer idPersona, Integer dni, Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String sexo, String direccion, Integer numDir, Integer piso, String departamento, Integer tipoGrupoSanguineo, Boolean donaOrganos) {
		super(idPersona, dni, tipoDoc, nombre, apellido, fechaNacimiento, sexo);
		this.direccion 			= direccion;
		this.numDir				= numDir;
		this.piso				= piso;
		this.dpto				= departamento;
		this.tipoGrupoSanguineo = tipoGrupoSanguineo;
		this.donaOrganos 		= donaOrganos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTipoGrupoSanguineo() {
		return tipoGrupoSanguineo;
	}

	public void setTipoGrupoSanguineo(Integer tipoGrupoSanguineo) {
		this.tipoGrupoSanguineo = tipoGrupoSanguineo;
	}

	public Boolean getDonaOrganos() {
		return donaOrganos;
	}

	public void setDonaOrganos(Boolean donaOrganos) {
		this.donaOrganos = donaOrganos;
	}

	public Integer getNumDir() {
		return numDir;
	}

	public void setNumDir(Integer numDir) {
		this.numDir = numDir;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	
	

}