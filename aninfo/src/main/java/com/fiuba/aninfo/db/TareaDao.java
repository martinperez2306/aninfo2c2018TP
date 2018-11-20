package com.fiuba.aninfo.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiuba.aninfo.model.Tarea;

@Component
public class TareaDao {
	
	@Autowired
	private TablaTareas tablaTareas;

	public List<Tarea> select(String sql) {
		return this.tablaTareas.select(sql);
	}

}
