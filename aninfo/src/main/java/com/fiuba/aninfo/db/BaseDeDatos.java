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
	
	private void initDataBase() {
		this.initProyectos();
		this.initEmpleados();
		this.initTareas();
	}
	
	private void initTareas() {
		Tarea desarrollo =  new Tarea();
		desarrollo.setCodigo("01");
		desarrollo.setNombre("Desarrollo");
		this.tareas.insert(desarrollo);
		Tarea analisisYDisenio = new Tarea();
		analisisYDisenio.setCodigo("02");
		analisisYDisenio.setNombre("Analisis y Diseño");
		this.tareas.insert(analisisYDisenio);
		Tarea mantenimiento = new Tarea();
		mantenimiento.setCodigo("04");
		mantenimiento.setNombre("Mantenimiento");
		this.tareas.insert(mantenimiento);
		Tarea instalacion = new Tarea();
		instalacion.setCodigo("05");
		instalacion.setNombre("Instalacion");
		this.tareas.insert(instalacion);
		Tarea testing = new Tarea();
		testing.setCodigo("06");
		testing.setNombre("Testing");
		this.tareas.insert(testing);
	}

	private void initEmpleados() {
		Empleado retchegaray = new Empleado();
		retchegaray.setDni("38233456");
		retchegaray.setNombre("Rodrigo Etchegaray");
		Empleado nlongo = new Empleado();
		nlongo.setDni("38901123");
		nlongo.setNombre("Nicolas Longo");
		Empleado rcotarelo = new Empleado();
		rcotarelo.setDni("39123456");
		rcotarelo.setNombre("Rodrigo Cotarelo");
		Empleado mperez = new Empleado();
		mperez.setDni("39183413");
		mperez.setNombre("Martin Perez");
		this.empleados.insert(mperez);
		this.empleados.insert(nlongo);
		this.empleados.insert(rcotarelo);
		this.empleados.insert(retchegaray);
	}

	private void initProyectos() {
		Proyecto psaSpringERP = new Proyecto();
		psaSpringERP.setCodigo("psaSpringERP");
		Proyecto psaSpringCRM = new Proyecto();
		psaSpringCRM.setCodigo("psaSpringCRM");
		Proyecto psaBussinesAnalytics = new Proyecto();
		psaBussinesAnalytics.setCodigo("psaBussinesAnalytics");
		this.proyectos.insert(psaSpringERP);
		this.proyectos.insert(psaSpringCRM);
		this.proyectos.insert(psaBussinesAnalytics);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		empleados = new TablaEmpleados();
		proyectos = new TablaProyectos();
		tareas = new TablaTareas();
		this.initDataBase();
	}

}
