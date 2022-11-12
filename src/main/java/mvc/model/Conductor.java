package mvc.model;

import java.time.LocalDate;

public class Conductor extends Persona {
	
	private String direccion;
	private Integer numDir;
	private Integer piso;
	private String dpto;
	private Integer tipoGrupoSanguineo;
	private Boolean donaOrganos;
	
	public Conductor(Integer idPersona, Integer dni,Integer tipoDoc, String nombre, String apellido, LocalDate fechaNacimiento, String direccion,String departamento, Integer numDir, Integer piso, Integer tipoGrupoSanguineo, Boolean donaOrganos) {
		super(idPersona, dni, tipoDoc, nombre, apellido, fechaNacimiento);
		this.direccion = direccion;
		this.numDir=numDir;
		this.piso=piso;
		this.dpto=departamento;
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
		this.numDir=Integer.parseInt(atributo[7]);
		this.piso=Integer.parseInt(atributo[8]);
		this.dpto=atributo[9];
		this.tipoGrupoSanguineo=Integer.parseInt(atributo[10]);
		this.donaOrganos=Boolean.parseBoolean(atributo[11]);
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
	
	

	private String direccion;
	private String numero;
	private String piso;
	private String puerta;
    private TipoGrupoSanguineo grupo_sanguineo;
    private boolean donaOrganos;
    
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public TipoGrupoSanguineo getGrupo_sanguineo() {
		return grupo_sanguineo;
	}
	public void setGrupo_sanguineo(TipoGrupoSanguineo grupo_sanguineo) {
		this.grupo_sanguineo = grupo_sanguineo;
	}
	public boolean isDonaOrganos() {
		return donaOrganos;
	}
	public void setDonaOrganos(boolean donaOrganos) {
		this.donaOrganos = donaOrganos;
	}
    


}
