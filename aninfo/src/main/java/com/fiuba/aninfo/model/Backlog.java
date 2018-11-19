package com.fiuba.aninfo.model;

import java.util.ArrayList;
import java.util.List;

public class Backlog {
	
	private List<TareaEmpleado> tareasDelEmpleado;
	private Long idTareaSequence;
	
	public Backlog() {
		this.tareasDelEmpleado = new ArrayList<TareaEmpleado>();
		idTareaSequence = 0L;
	}
	
	private TareaEmpleado getTareaByID(Long idTarea) {
		TareaEmpleado tarea = null;
		for (TareaEmpleado tareaEmpleado : tareasDelEmpleado) {
			if(tareaEmpleado.getIdTareaEmpleado().equals(idTarea))
				tarea = tareaEmpleado;
		}
		return tarea;
	}

	public List<TareaEmpleado> getTareasDelEmpleado() {
		return tareasDelEmpleado;
	}
	
	public void addTareaEmpleado(TareaEmpleado tareaEmpleado) {
		tareaEmpleado.setIdTareaEmpleado(new Long(this.idTareaSequence.longValue()));
		this.tareasDelEmpleado.add(tareaEmpleado);
		idTareaSequence++;
	}
	
	public void addTareasEmpleado(List<TareaEmpleado> tareas) {
		this.tareasDelEmpleado.addAll(tareas);
	}

	public void addPasoATarea(PasoTarea pasoTarea, Long idTarea) {
		TareaEmpleado tarea = null;
		for (TareaEmpleado tareaEmpleado : tareasDelEmpleado) {
			if(tareaEmpleado.getIdTareaEmpleado().equals(idTarea))
				tarea = tareaEmpleado;
		}
		if(tarea != null)
			tarea.addPasoTarea(pasoTarea);
		
	}

	public void updateEstadoTarea(EstadoTarea estado, Long idTarea) {
		TareaEmpleado tarea = this.getTareaByID(idTarea);
		if(tarea != null)
			tarea.setEstado(estado);
		
	}

	public void updateEstadoPasoForTarea(EstadoPasoTarea estado, Integer idPasoTarea, Long idTarea) {
		TareaEmpleado tarea = this.getTareaByID(idTarea);
		tarea.updateEstadoPasoTarea(estado,idPasoTarea);
	}

}
