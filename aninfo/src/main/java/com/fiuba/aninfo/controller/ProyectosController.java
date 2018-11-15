package com.fiuba.aninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.Proyecto;
import com.fiuba.aninfo.service.ProyectoService;

@Controller
public class ProyectosController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@RequestMapping(value="/hour", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Proyecto>> getHour() {
		List<Proyecto> proyectos = this.proyectoService.getAllProyectos();
		ResponseEntity<List<Proyecto>> response = new ResponseEntity<List<Proyecto>>(proyectos,HttpStatus.OK);
		return response;
	}
}
