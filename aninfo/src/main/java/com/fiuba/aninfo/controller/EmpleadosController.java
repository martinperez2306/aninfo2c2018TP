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
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Empleado>> getEmpleados() {
		List<Empleado> empleados = this.empleadoService.getAllEmpleados();
		ResponseEntity<List<Empleado>> response = new ResponseEntity<List<Empleado>>(empleados,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/employees/desarrolladores", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Empleado>> getDesarrolladores() {
		List<Empleado> empleados = this.empleadoService.getDesarrolladores();
		ResponseEntity<List<Empleado>> response = new ResponseEntity<List<Empleado>>(empleados,HttpStatus.OK);
		return response;
	}
}
