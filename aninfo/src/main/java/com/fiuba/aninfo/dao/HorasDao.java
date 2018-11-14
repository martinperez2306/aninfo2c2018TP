package com.fiuba.aninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.db.TablaHoras;
import com.fiuba.aninfo.model.Horas;

@Component
public class HorasDao {

	@Autowired
	private TablaHoras tablaHoras;
	
	public void insert(Horas horas) {
		this.tablaHoras.insert(horas);
	}
	
	public List<Horas> select(String sql) {
		return this.tablaHoras.select(sql);
	}
}
