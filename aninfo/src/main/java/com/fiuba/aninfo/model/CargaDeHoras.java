package com.fiuba.aninfo.model;

public class CargaDeHoras {

	private Integer cantidadDeHoras;
	private Integer dia;
	private Integer mes;
	private Integer anio;
	private Proyecto proyecto;
	private Tarea tarea;
	private Empleado empleado;

	public CargaDeHoras() {

	}

	public Integer getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	public void setCantidadDeHoras(Integer cantidadDeHoras) {
		this.cantidadDeHoras = cantidadDeHoras;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
