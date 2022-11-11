package mvc.model;

public class TipoDocumento {
	
	private Integer tipoDocumento;
	
	public TipoDocumento(String datos) {
		String[] atributo = datos.split("\t");
		this.tipoDocumento= Integer.parseInt(atributo[0]);
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	
	public String getTipoDocumentoTexto() {
		switch(this.tipoDocumento) {
		case 1: return "DNI";
		case 2: return "LC";
		case 3: return "LE";
		case 4: return "CUIL";
		case 5: return "CUIT";
		default: return null;
		}
	}

}
