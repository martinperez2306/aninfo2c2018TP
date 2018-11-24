package com.fiuba.aninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiuba.aninfo.dao.EmpleadosDao;
import com.fiuba.aninfo.model.Empleado;

@Service
public class EmpleadoService {
	
	@Autowired
	private EmpleadosDao empleadosDao;

	public List<Empleado> getAllEmpleados() {
		return empleadosDao.select("");
	}

}
