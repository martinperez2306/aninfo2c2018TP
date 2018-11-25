package com.fiuba.aninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiuba.aninfo.dao.AsignacionesDao;
import com.fiuba.aninfo.model.Asignacion;

@Service
public class AsignacionesService {
	
	@Autowired
	private AsignacionesDao asignacionesDao;

	public List<Asignacion> getAllAsignaciones() {
		return this.asignacionesDao.select("");
	}

	public void addAsignacion(Asignacion asignacion) {
		this.asignacionesDao.insert(asignacion);
		
	}

	public void deleteAsignacion(Long id) {
		Asignacion asignacion = new Asignacion();
		asignacion.setId(id);
		this.asignacionesDao.delete(asignacion);
	}

	public List<Asignacion> getAsignacionesDeEmpleado(String dni) {
		return this.asignacionesDao.select("empleado="+dni);
	}

}
