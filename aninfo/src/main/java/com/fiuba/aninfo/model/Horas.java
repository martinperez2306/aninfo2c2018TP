package com.fiuba.aninfo.model;

import java.util.Date;

public class Horas {
	
	private String codigoProyecto;
	private String codigoTarea;
	private String dniEmpleado;
	private Integer cantidadDeHoras;
	private Date fecha;
	
	public Horas(){
		
	}

	public String getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(String idProyecto) {
		this.codigoProyecto = idProyecto;
	}

	public String getCodigoTarea() {
		return codigoTarea;
	}

	public void setCodigoTarea(String idTarea) {
		this.codigoTarea = idTarea;
	}

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String idEmpleado) {
		this.dniEmpleado = idEmpleado;
	}

	public Integer getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	public void setCantidadDeHoras(Integer cantidadDeHoras) {
		this.cantidadDeHoras = cantidadDeHoras;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
