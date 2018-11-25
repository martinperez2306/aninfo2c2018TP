package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Empleado;
import com.fiuba.aninfo.model.Rol;

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
		}else if(sql.equals("desarrolladores")) {
			List<Empleado> empleados = new ArrayList<Empleado>();
			for (Empleado empleado : this.empleados.values()) {
				if(empleado.getRolEmpleado().getRol().equals("desarrollador"))
					empleados.add(empleado);
			}
			return empleados;
		}else {
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
		Rol rolRetchegaray = new Rol();
		rolRetchegaray.setRol("Desarrollador");
		rolRetchegaray.setUrl("cargaHoras");
		retchegaray.setRolEmpleado(rolRetchegaray);
		
		Empleado nlongo = new Empleado();
		nlongo.setDni("nlongo");
		nlongo.setNombre("Nicolas Longo");
		Rol rolNlongo = new Rol();
		rolNlongo.setRol("Desarrollador");
		rolNlongo.setUrl("cargaHoras");
		nlongo.setRolEmpleado(rolNlongo);
		
		Empleado rcotarelo = new Empleado();
		rcotarelo.setDni("rcotarelo");
		rcotarelo.setNombre("Rodrigo Cotarelo");
		Rol rolRcotarelo = new Rol();
		rolRcotarelo.setRol("Desarrollador");
		rolRcotarelo.setUrl("cargaHoras");
		rcotarelo.setRolEmpleado(rolRcotarelo);
		
		Empleado mperez = new Empleado();
		mperez.setDni("mperez");
		mperez.setNombre("Martin Perez");
		Rol rolMperez = new Rol();
		rolMperez.setRol("Desarrollador");
		rolMperez.setUrl("cargaHoras");
		mperez.setRolEmpleado(rolMperez);
		
		Empleado gbenedetti = new Empleado();
		gbenedetti.setNombre("Guido De Benedetti");
		gbenedetti.setDni("gbenedetti");
		Rol rolGbenedetti = new Rol();
		rolGbenedetti.setRol("Gerente de Operaciones");
		rolGbenedetti.setUrl("operaciones");
		gbenedetti.setRolEmpleado(rolGbenedetti);
		
		this.insert(mperez);
		this.insert(nlongo);
		this.insert(rcotarelo);
		this.insert(retchegaray);
		this.insert(gbenedetti);
	}

}
