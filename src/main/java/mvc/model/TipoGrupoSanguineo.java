package mvc.model;

public class TipoGrupoSanguineo {
	
	private Integer tipoGrupoSanguineo;
	
	public TipoGrupoSanguineo(String datos) {
		String[] atributo = datos.split("\t");
		this.tipoGrupoSanguineo=Integer.parseInt(atributo[0]);
	}

	public Integer getTipoGrupoSanguineo() {
		return tipoGrupoSanguineo;
	}
	
	public String getTipoGrupoSanguineoTexto() {
		switch(this.tipoGrupoSanguineo) {
		case 1: return "A+";
		case 2: return "A-";
		case 3: return "B+";
		case 4: return "B-";
		case 5: return "0+";
		case 6: return "0-";
		case 7: return "AB+";
		case 8: return "AB-";
		default: return null;
		}
	}

}