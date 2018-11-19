package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Empleado;

@Component
public class TablaEmpleados implements TableInterface<Empleado>, InitializingBean{

	
	private Map<String,Empleado> empleados;
	@Override
	public void insert(Empleado empleado) {
		if(empleados.get(empleado.getDni()) == null) {
			this.empleados.put(empleado.getDni(),empleado);
		}
	}

	@Override
	public List<Empleado> select(String sql) {
		if(sql == null || sql.equals("")) {
			return new ArrayList<Empleado>(empleados.values());
		}
		else {
			List<Empleado> empleados = new ArrayList<Empleado>();
			for (Empleado empleado : this.empleados.values()) {
				if(empleado.getDni().equals(sql))
					empleados.add(empleado);
			}
			return empleados;
		}
	}

	@Override
	public void update(Empleado element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empleado empleado) {
		
		this.empleados.remove(empleado.getDni());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.empleados = new HashMap<String,Empleado>();
		Empleado retchegaray = new Empleado();
		retchegaray.setDni("retchegaray");
		retchegaray.setNombre("Rodrigo Etchegaray");
		Empleado nlongo = new Empleado();
		nlongo.setDni("nlongo");
		nlongo.setNombre("Nicolas Longo");
		Empleado rcotarelo = new Empleado();
		rcotarelo.setDni("rcotarelo");
		rcotarelo.setNombre("Rodrigo Cotarelo");
		Empleado mperez = new Empleado();
		mperez.setDni("mperez");
		mperez.setNombre("Martin Perez");
		this.insert(mperez);
		this.insert(nlongo);
		this.insert(rcotarelo);
		this.insert(retchegaray);		
	}

}
