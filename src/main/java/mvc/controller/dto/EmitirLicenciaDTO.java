package mvc.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmitirLicenciaDTO {
	private String nombreCond;
	private String apellidoCond;
	private Integer tipoDoc;
	private Integer numDoc;
	private LocalDate fechaNacimiento;
	private String sexo;
	private Integer grupoSang;
	private Boolean esDonante;
	private String calle;
	private Integer numCalle;
	private Integer piso;
	private String dpto;
	private String observaciones;
	private ArrayList<String> licenciasSeleccionadas;
	
	public String getNombreCond() {
		return nombreCond;
	}
	public void setNombreCond(String nombreCond) {
		this.nombreCond = nombreCond;
	}
	public String getApellidoCond() {
		return apellidoCond;
	}
	public void setApellidoCond(String apellidoCond) {
		this.apellidoCond = apellidoCond;
	}
	public Integer getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public Integer getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(Integer numDoc) {
		this.numDoc = numDoc;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getGrupoSang() {
		return grupoSang;
	}
	public void setGrupoSang(Integer grupoSang) {
		this.grupoSang = grupoSang;
	}
	public Boolean getEsDonante() {
		return esDonante;
	}
	public void setEsDonante(Boolean esDonante) {
		this.esDonante = esDonante;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumCalle() {
		return numCalle;
	}
	public void setNumCalle(Integer numCalle) {
		this.numCalle = numCalle;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public ArrayList<Integer> getLicenciasSeleccionadas() {
		ArrayList<Integer> licenciasValNum= new ArrayList<Integer>();
		
		for(int i=0; i<licenciasSeleccionadas.size();i++) {
			licenciasValNum.add(Integer.parseInt(licenciasSeleccionadas.get(i)));
		}
		
		return licenciasValNum;
	}
	public void setLicenciasSeleccionadas(ArrayList<String> licenciasSeleccionadas) {
		this.licenciasSeleccionadas = licenciasSeleccionadas;
	}
	
	

}
