package com.fiuba.aninfo.db;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Empleado;
import com.fiuba.aninfo.model.Proyecto;
import com.fiuba.aninfo.model.Tarea;

@Component
public class BaseDeDatos implements InitializingBean{
	
	private TableInterface<Empleado> empleados;
	private TableInterface<Proyecto> proyectos;
	private TableInterface<Tarea> tareas;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		empleados = new TablaEmpleados();
		 proyectos = new TablaProyectos();
		 tareas = new TablaTareas();
	}

}
