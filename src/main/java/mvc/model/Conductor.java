package mvc.model;

public class Conductor {

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
