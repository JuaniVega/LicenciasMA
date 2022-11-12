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
	
	public Licencia() {
		super();
	}


	public Licencia(Integer idLicencia, Integer idPersona, Integer idTipoLicencia, Integer costo,
			LocalDate fechaEmision, LocalDate fechaVigencia, Boolean esCopia, Boolean estaVigente) {
		super();
		this.idLicencia = idLicencia;
		this.idPersona = idPersona;
		this.idTipoLicencia = idTipoLicencia;
		this.costo = costo;
		this.fechaEmision = fechaEmision;
		this.fechaVigencia = fechaVigencia;
		this.esCopia = esCopia;
		this.estaVigente = estaVigente;
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
	
	

}
