package com.fiuba.aninfo.model;

import com.fiuba.aninfo.model.PasoTarea.EstadoPasoTarea;

public class Empleado {
	
	private String nombre;
	
	private String dni;
	
	private Backlog backlog;
	
	public Empleado(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
	public void receiveTarea(Tarea tarea) {
		TareaEmpleado tareaEmpleado = new TareaEmpleado();
		tareaEmpleado.setCodigo(tarea.getCodigo());
		tareaEmpleado.setDescripcion(tarea.getDescripcion());
		tareaEmpleado.setNombre(tarea.getNombre());
		tareaEmpleado.setEstado(EstadoTarea.ASIGNADA);
		this.backlog.addTareaEmpleado(tareaEmpleado);
	}
	
	public void addPasoATarea(PasoTarea pasoTarea, Long idTarea) {
		this.backlog.addPasoATarea(pasoTarea,idTarea);
	}
	
	public void updateEstadoTarea(EstadoTarea estado, Long idTarea) {
		this.backlog.updateEstadoTarea(estado,idTarea);
	}
	
	public void updateEstadoPasoTarea(EstadoPasoTarea estado,Long idTarea, Integer idPasoTarea) {
		this.backlog.updateEstadoPasoForTarea(estado, idPasoTarea,idTarea);
	}
	
}
