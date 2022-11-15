package mvc.model;

public class TipoDocumento {
	
	private Integer id_doc;
	private String 	tipo_doc;
	private String descripcion;

	public TipoDocumento(){
		super();
	}
	
	public TipoDocumento(Integer id_doc, String tipo_doc, String descripcion) {
		super();
		this.id_doc 	 = id_doc;
		this.tipo_doc 	 = tipo_doc;
		this.descripcion = descripcion;
	}

	public Integer getId_doc() {
		return id_doc;
	}

	public void setId_doc(Integer id_doc) {
		this.id_doc = id_doc;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}