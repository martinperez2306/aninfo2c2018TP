package com.fiuba.aninfo.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.fiuba.aninfo.model.Horas;

public class TablaHoras implements TableInterface<Horas>, InitializingBean {
	
	private List<Horas> horasList;

	@Override
	public void insert(Horas horas) {
		if(horas != null) {
			horasList.add(horas);
		}
	}

	@Override
	public List<Horas> select(String sql) {
		if(sql == null || sql.equals("")) {
			return new ArrayList<Horas>(horasList);
		}else {
			return this.selectBySql(sql);
		}
	}

	private List<Horas> selectBySql(String sql) {
		// TODO Generar SQL para saber si filtra por Proyecto, tarea o empleado
		return null;
	}

	@Override
	public void update(Horas element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Horas element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.horasList = new ArrayList<Horas>();
	}

}
