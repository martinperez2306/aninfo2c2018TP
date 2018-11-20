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
}
