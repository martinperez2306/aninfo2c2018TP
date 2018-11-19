package com.fiuba.aninfo.db;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Tarea;

@Component
public class TablaTareas implements TableInterface<Tarea>, InitializingBean{

	@Override
	public void insert(Tarea element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tarea> select(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tarea element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tarea element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
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
