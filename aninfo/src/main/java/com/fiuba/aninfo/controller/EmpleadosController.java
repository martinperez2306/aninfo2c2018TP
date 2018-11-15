package com.fiuba.aninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.Empleado;
import com.fiuba.aninfo.service.EmpleadoService;

@Controller
public class EmpleadosController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping(value="/hour", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Empleado>> getHour() {
		List<Empleado> proyectos = this.empleadoService.getAllEmpleados();
		ResponseEntity<List<Empleado>> response = new ResponseEntity<List<Empleado>>(proyectos,HttpStatus.OK);
		return response;
	}
}
