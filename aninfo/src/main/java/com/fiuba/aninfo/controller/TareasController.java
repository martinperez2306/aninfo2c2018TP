package com.fiuba.aninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.Tarea;
import com.fiuba.aninfo.service.TareaService;

@Controller
public class TareasController {
	
	@Autowired
	private TareaService tareaService;
	
	@RequestMapping(value="/tasks", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Tarea>> getEmpleados() {
		List<Tarea> tareas = this.tareaService.getAllTareas();
		ResponseEntity<List<Tarea>> response = new ResponseEntity<List<Tarea>>(tareas,HttpStatus.OK);
		return response;
	}

}
