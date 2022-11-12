package mvc.model;

public class TipoLicencia {
	
	private Integer tipoLicencia;
	
	public TipoLicencia(String datos) {
		String[] atributo = datos.split("\t");
		this.tipoLicencia=Integer.parseInt(atributo[0]);
	}
	
	public Integer getTipoLicencia() {
		return tipoLicencia;
	}
	
	public String getTipoLicenciaTexto() {
		switch(this.tipoLicencia) {
		case 1: return "A";
		case 2: return "B";
		case 3: return "C";
		case 4: return "D";
		case 5: return "E";
		case 6: return "F";
		case 7: return "G";
		default: return null;
		}
	}

}
