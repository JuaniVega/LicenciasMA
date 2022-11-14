package mvc.model;

import java.time.LocalDate;

public class Licencia {
	
	private Integer idLicencia;
	private Integer idPersona;
	private Integer idTipoLicencia;
	private Integer costo;
	private LocalDate fechaEmision;
	private LocalDate fechaVigencia;
	private Boolean esCopia;
	private Boolean estaVigente;
	private String observaciones;
	
	public Licencia() {
		super();
	}


	public Licencia(Integer idLicencia, Integer idPersona, Integer idTipoLicencia, Integer costo,
			LocalDate fechaEmision, LocalDate fechaVigencia, Boolean esCopia, Boolean estaVigente, String observaciones) {
		super();
		this.idLicencia = idLicencia;
		this.idPersona = idPersona;
		this.idTipoLicencia = idTipoLicencia;
		this.costo = costo;
		this.fechaEmision = fechaEmision;
		this.fechaVigencia = fechaVigencia;
		this.esCopia = esCopia;
		this.estaVigente = estaVigente;
		this.observaciones=observaciones;
	}
	
	public Licencia(String datos) {
		String[] atributo = datos.split("\t");
		this.idLicencia=Integer.parseInt(atributo[0]);
		this.idPersona=Integer.parseInt(atributo[1]);
		this.idTipoLicencia=Integer.parseInt(atributo[2]);
		this.costo=Integer.parseInt(atributo[3]);
		this.fechaEmision=LocalDate.parse(atributo[4]);
		this.fechaVigencia=LocalDate.parse(atributo[5]);
		this.esCopia=Boolean.parseBoolean(atributo[6]);
		this.estaVigente=Boolean.parseBoolean(atributo[7]);
		this.observaciones=atributo[8];
	}


	public Integer getIdLicencia() {
		return idLicencia;
	}


	public void setIdLicencia(Integer idLicencia) {
		this.idLicencia = idLicencia;
	}


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public Integer getIdTipoLicencia() {
		return idTipoLicencia;
	}


	public void setIdTipoLicencia(Integer idTipoLicencia) {
		this.idTipoLicencia = idTipoLicencia;
	}


	public Integer getCosto() {
		return costo;
	}


	public void setCosto(Integer costo) {
		this.costo = costo;
	}


	public LocalDate getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public LocalDate getFechaVigencia() {
		return fechaVigencia;
	}


	public void setFechaVigencia(LocalDate fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}


	public Boolean getEsCopia() {
		return esCopia;
	}


	public void setEsCopia(Boolean esCopia) {
		this.esCopia = esCopia;
	}


	public Boolean getEstaVigente() {
		return estaVigente;
	}


	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
