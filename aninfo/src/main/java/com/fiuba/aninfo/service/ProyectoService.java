package com.fiuba.aninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiuba.aninfo.dao.ProyectoDao;
import com.fiuba.aninfo.model.Proyecto;

@Service
public class ProyectoService {
	
	@Autowired
	private ProyectoDao proyectoDao;
	
	public List<Proyecto> getAllProyectos(){
		return this.proyectoDao.select("");
	}

	public void addProyecto(Proyecto proyecto) {
		this.proyectoDao.insert(proyecto);
	}

	public void deleteProyecto(String codigo) {
		this.proyectoDao.delete(codigo);
	}

}
