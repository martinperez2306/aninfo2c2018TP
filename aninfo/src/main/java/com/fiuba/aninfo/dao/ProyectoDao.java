package com.fiuba.aninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.db.TablaProyectos;
import com.fiuba.aninfo.model.Proyecto;

@Component
public class ProyectoDao {
	
	@Autowired
	private TablaProyectos tablaProyectos;

	public List<Proyecto> select(String sql) {
		return this.tablaProyectos.select(sql);
	}

}
