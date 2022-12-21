package mvc.model;

public class Costo {
	
	private Integer id;
	private String clase;
	private Integer anios;
	private Integer costo;
	
	public Costo() {
		super();
	}

	public Costo(Integer id, String clase, Integer anios, Integer costo) {
		super();
		this.id = id;
		this.clase = clase;
		this.anios = anios;
		this.costo = costo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Integer getAnios() {
		return anios;
	}

	public void setAnios(Integer anios) {
		this.anios = anios;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

}
