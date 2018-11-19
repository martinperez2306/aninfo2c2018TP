package com.fiuba.aninfo.model;

import java.util.ArrayList;
import java.util.List;

import com.fiuba.aninfo.model.PasoTarea.EstadoPasoTarea;

public class Checklist {
	
	private List<PasoTarea> pasos;
	
	private Integer idPasoTaraeSequence;
	
	public Checklist() {
		this.pasos = new ArrayList<PasoTarea>();
		this.idPasoTaraeSequence = 0;
	}
	
	private PasoTarea getPasoById(Integer idPasoTarea) {
		PasoTarea paso = null;
		for (PasoTarea pasoTarea : pasos) {
			if(pasoTarea.getIdPasoTarea().equals(idPasoTarea));
				paso = pasoTarea;
		}
		return paso;
	}
	
	public List<PasoTarea> getPasos() {
		return this.pasos;
	}
	
	public void addPaso(PasoTarea pasoTarea) {
		pasoTarea.setIdPasoTarea(new Integer(this.idPasoTaraeSequence));
		this.pasos.add(pasoTarea);
		this.idPasoTaraeSequence++;
	}
	
	public void addPasos(List<PasoTarea> pasosTarea) {
		for (PasoTarea pasoTarea : pasosTarea) {
			pasoTarea.setIdPasoTarea(new Integer(this.idPasoTaraeSequence));
			this.idPasoTaraeSequence++;
		}
		this.pasos.addAll(pasosTarea);
	}

	public void updateEstadoPasoTarea(EstadoPasoTarea estado, Integer idPasoTarea) {
		PasoTarea paso = this.getPasoById(idPasoTarea);
		if(paso != null)
			paso.setEstado(estado);
	}

}
