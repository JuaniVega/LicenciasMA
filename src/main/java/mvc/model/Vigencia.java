package mvc.model;

public class Vigencia {
	
	private Integer id;
	private Integer vigencia;
	private String descripcion;
	
	public Vigencia() {
		super();
	}

	public Vigencia(Integer id, Integer vigencia, String descripcion) {
		super();
		this.id = id;
		this.vigencia = vigencia;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
