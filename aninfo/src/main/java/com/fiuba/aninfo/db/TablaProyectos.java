package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Proyecto;

@Component
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
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		if(sql == null || sql.equals("")) {
			proyectos.addAll(this.proyectosList);
		}else {
			for (Proyecto proyecto : this.proyectosList) {
				if(proyecto.getCodigo().equals(sql))
					proyectos.add(proyecto);
			}
		}
		return proyectos;
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
		Proyecto psaSpringERP = new Proyecto();
		psaSpringERP.setCodigo("psaSpringERP");
		Proyecto psaSpringCRM = new Proyecto();
		psaSpringCRM.setCodigo("psaSpringCRM");
		Proyecto psaBussinesAnalytics = new Proyecto();
		psaBussinesAnalytics.setCodigo("psaBussinesAnalytics");
		this.insert(psaSpringERP);
		this.insert(psaSpringCRM);
		this.insert(psaBussinesAnalytics);
	}

}
