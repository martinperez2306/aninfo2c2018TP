package com.fiuba.aninfo.model;

public class PasoTarea {
	
	private Integer idPasoTarea;
	
	private String descripcion;
	
	private EstadoPasoTarea estado;
	
	public PasoTarea() {
		
	}
	
	public Integer getIdPasoTarea() {
		return idPasoTarea;
	}

	public void setIdPasoTarea(Integer idPasoTarea) {
		this.idPasoTarea = idPasoTarea;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoPasoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoPasoTarea estado) {
		this.estado = estado;
	}

}
