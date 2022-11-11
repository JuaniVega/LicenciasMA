package mvc.model;

import java.time.LocalDate;

public class Conductor extends Persona {
	
	private String direccion;
	private Integer tipoGrupoSanguineo;
	private Boolean donaOrganos;
	
	public Conductor(Integer idPersona, Integer dni,Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String direccion, Integer tipoGrupoSanguineo, Boolean donaOrganos) {
		super(idPersona, dni, tipoDoc, nombre, apellido, fechaNacimiento);
		this.direccion = direccion;
		this.tipoGrupoSanguineo = tipoGrupoSanguineo;
		this.donaOrganos = donaOrganos;
	}

	public Conductor() {
		
	}
	
	public Conductor(String datos) {
		String[] atributo = datos.split("\t");
		this.idPersona=Integer.parseInt(atributo[0]);
		this.dni=Integer.parseInt(atributo[1]);
		this.tipoDoc=Integer.parseInt(atributo[2]);
		this.nombre=atributo[3];
		this.apellido=atributo[4];
		this.fechaNacimiento=LocalDate.parse(atributo[5]);
		this.direccion=atributo[6];
		this.tipoGrupoSanguineo=Integer.parseInt(atributo[7]);
		this.donaOrganos=Boolean.parseBoolean(atributo[8]);
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
	
	

}
