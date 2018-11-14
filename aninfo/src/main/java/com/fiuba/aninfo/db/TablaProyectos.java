package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.fiuba.aninfo.model.Proyecto;

public class TablaProyectos implements TableInterface<Proyecto>, InitializingBean {

	private List<Proyecto> proyectosList;

	@Override
	public void insert(Proyecto proyecto) {
		if(proyecto != null) {
			this.proyectosList.add(proyecto);
		}else {
			throw new RuntimeException("No se puede insertar un proyecto NULL");
		}
	}

	@Override
	public List<Proyecto> select(String sql) {
		return new ArrayList<Proyecto>(this.proyectosList);
	}

	@Override
	public void update(Proyecto element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Proyecto element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.proyectosList = new ArrayList<Proyecto>();
	}

}
