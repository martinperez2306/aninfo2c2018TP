package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Asignacion;

@Component
public class TablaAsignaciones implements TableInterface<Asignacion>, InitializingBean{

	private List<Asignacion> asignaciones;
	
	private Long idSequence;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.asignaciones = new ArrayList<Asignacion>();
		this.idSequence = 0L;
	}

	@Override
	public void insert(Asignacion asignacion) {
		
		if(asignacion != null) {
			Long nueviId = idSequence.longValue();
			asignacion.setId(nueviId);
			this.asignaciones.add(asignacion);
		}
	}

	@Override
	public List<Asignacion> select(String sql) {
		List<Asignacion> asingaciones = new ArrayList<Asignacion>();
		if(sql == null || sql.equals("")) {
			asingaciones.addAll(this.asignaciones);
		}
		else {
			for (Asignacion asignacion : this.asignaciones) {
				if(asignacion.getId().equals(Long.parseLong(sql))) {
					asignaciones.add(asignacion);
				}
			}
		}
		return asignaciones;
	}

	@Override
	public void update(Asignacion asignacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Asignacion asignacion) {
		Asignacion asignacionABorrar = null;
		for (Asignacion asignacionExistente : asignaciones) {
			if(asignacionExistente.getId().equals(asignacion.getId()))
				asignacionABorrar = asignacionExistente;
		}
		this.asignaciones.remove(asignacionABorrar);
	}

}
