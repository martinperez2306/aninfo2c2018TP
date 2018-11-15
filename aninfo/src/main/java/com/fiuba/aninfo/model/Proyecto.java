package com.fiuba.aninfo.model;

public class Proyecto {
	
	private String codigo;
	
	private String vencimiento;
	
	private String fechaEntrega;
	
	private String presupuesto;
	
	public Proyecto() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}
}
