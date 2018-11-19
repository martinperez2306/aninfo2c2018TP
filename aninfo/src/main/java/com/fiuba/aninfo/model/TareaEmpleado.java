package com.fiuba.aninfo.model;

public class TareaEmpleado {
	
	private Long idTareaEmpleado;
	
	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private EstadoTarea estado;
	
	private Checklist checklist;
	
	public TareaEmpleado() {
		
	}

	public Long getIdTareaEmpleado() {
		return idTareaEmpleado;
	}

	public void setIdTareaEmpleado(Long idTareaEmpleado) {
		this.idTareaEmpleado = idTareaEmpleado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	public Checklist getChecklist() {
		return checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}
	
	public void addPasoTarea(PasoTarea pasoTarea) {
		this.checklist.addPaso(pasoTarea);
	}

	public void updateEstadoPasoTarea(EstadoPasoTarea estado, Integer idPasoTarea) {
		this.checklist.updateEstadoPasoTarea(estado,idPasoTarea);
		
	}
	
}
