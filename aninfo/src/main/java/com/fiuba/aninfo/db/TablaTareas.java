package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Tarea;

@Component
public class TablaTareas implements TableInterface<Tarea>, InitializingBean{

	private Map<String,Tarea> tareas;
	
	@Override
	public void insert(Tarea tarea) {
		
		if(this.tareas.get(tarea.getCodigo()) == null) {
			this.tareas.put(tarea.getCodigo(), tarea);
		}
	}

	@Override
	public List<Tarea> select(String sql) {
		List<Tarea> tareas = new ArrayList<Tarea>();
		if(sql == null || sql.equals("")) {
			tareas.addAll(this.tareas.values());
		}
		else {
			tareas.add(this.tareas.get(sql));
		}
		return tareas;
	}

	@Override
	public void update(Tarea tarea) {
		
		Tarea tareaSeleccionada = this.tareas.get(tarea.getCodigo());
		if(tareaSeleccionada != null) {
			tareaSeleccionada.setDescripcion(tarea.getDescripcion());
			tareaSeleccionada.setNombre(tarea.getNombre());
		}
	}

	@Override
	public void delete(Tarea tarea) {
		
		this.tareas.remove(tarea.getCodigo());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.tareas = new HashMap<String,Tarea>();
		Tarea desarrollo =  new Tarea();
		desarrollo.setCodigo("01");
		desarrollo.setNombre("Desarrollo");
		this.insert(desarrollo);
		Tarea analisisYDisenio = new Tarea();
		analisisYDisenio.setCodigo("02");
		analisisYDisenio.setNombre("Analisis y Diseño");
		this.insert(analisisYDisenio);
		Tarea mantenimiento = new Tarea();
		mantenimiento.setCodigo("04");
		mantenimiento.setNombre("Mantenimiento");
		this.insert(mantenimiento);
		Tarea instalacion = new Tarea();
		instalacion.setCodigo("05");
		instalacion.setNombre("Instalacion");
		this.insert(instalacion);
		Tarea testing = new Tarea();
		testing.setCodigo("06");
		testing.setNombre("Testing");
		this.insert(testing);
	}

}
