package mvc.model;

public class TipoGrupoSanguineo {
	
	private Integer id_grupo_sanguineo;
	private String 	tipo_grupo_sanguineo;
	
	public TipoGrupoSanguineo() {
		super();
	}
	
	public TipoGrupoSanguineo(Integer id_grupo_sanguineo, String tipo_grupo_sanguineo) {
		super();
		this.id_grupo_sanguineo 	= id_grupo_sanguineo;
		this.tipo_grupo_sanguineo 	= tipo_grupo_sanguineo;
	}
	
	public Integer getId_grupo_sanguineo() {
		return id_grupo_sanguineo;
	}
	
	public void setId_grupo_sanguineo(Integer id_grupo_sanguineo) {
		this.id_grupo_sanguineo = id_grupo_sanguineo;
	}
	
	public String getTipo_grupo_sanguineo() {
		return tipo_grupo_sanguineo;
	}
	
	public void setTipo_grupo_sanguineo(String tipo_grupo_sanguineo) {
		this.tipo_grupo_sanguineo = tipo_grupo_sanguineo;
	}

}