package com.fiuba.aninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.db.TablaEmpleados;
import com.fiuba.aninfo.db.TableInterface;
import com.fiuba.aninfo.model.Empleado;

@Component
public class EmpleadosDao implements TableInterface<Empleado>{

	@Autowired
	private TablaEmpleados tablaEmpleados;

	@Override
	public void insert(Empleado element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> select(String sql) {
		return this.tablaEmpleados.select(sql);
	}

	@Override
	public void update(Empleado element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empleado element) {
		// TODO Auto-generated method stub
		
	}
}
