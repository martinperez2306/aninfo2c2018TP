package com.fiuba.aninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.db.TablaAsignaciones;
import com.fiuba.aninfo.model.Asignacion;

@Component
public class AsignacionesDao {
	
	@Autowired
	private TablaAsignaciones tablaAsignaciones;

	public List<Asignacion> select(String sql) {
		return this.tablaAsignaciones.select(sql);
	}

	public void insert(Asignacion asignacion) {
		this.tablaAsignaciones.insert(asignacion);
	}

	public void delete(Asignacion asignacion) {
		this.tablaAsignaciones.delete(asignacion);
	}
	
	

}
