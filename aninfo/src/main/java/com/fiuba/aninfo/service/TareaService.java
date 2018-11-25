package com.fiuba.aninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiuba.aninfo.db.TareaDao;
import com.fiuba.aninfo.model.Tarea;

@Service
public class TareaService {
	
	@Autowired
	private TareaDao tareaDao;
	
	public List<Tarea> getAllTareas(){
		return this.tareaDao.select("");
	}

	public void addTarea(Tarea tarea) {
		this.tareaDao.insert(tarea);
	}

	public void deleteTarea(String codigo) {
		Tarea tarea = new Tarea();
		tarea.setCodigo(codigo);
		this.tareaDao.delete(tarea);
	}

	public Tarea getTarea(String codigo) {
		return this.tareaDao.select(codigo).get(0);
	}
}
