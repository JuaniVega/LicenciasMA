package mvc.model;

public class TipoLicencia {
	
	private Integer id_tipo_licencia;
	private String  clase;
	private String 	descripcion;
	
	public TipoLicencia() {
		super();
	}
	
	public TipoLicencia(Integer id_tipo_licencia, String clase, String descripcion) {
		super();
		this.id_tipo_licencia 	= id_tipo_licencia;
		this.clase 				= clase;
		this.descripcion 		= descripcion;
	}
	
	public Integer getId_tipo_licencia() {
		return id_tipo_licencia;
	}
	public void setId_tipo_licencia(Integer id_tipo_licencia) {
		this.id_tipo_licencia = id_tipo_licencia;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}