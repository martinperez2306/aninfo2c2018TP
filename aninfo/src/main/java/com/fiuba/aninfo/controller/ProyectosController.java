package com.fiuba.aninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.Proyecto;
import com.fiuba.aninfo.service.ProyectoService;

@Controller
public class ProyectosController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@RequestMapping(value="/projects", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Proyecto>> getProyjects() {
		List<Proyecto> proyectos = this.proyectoService.getAllProyectos();
		ResponseEntity<List<Proyecto>> response = new ResponseEntity<List<Proyecto>>(proyectos,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/projects", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addProyect(@RequestBody Proyecto proyecto) {
		this.proyectoService.addProyecto(proyecto);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/projects/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<String> deleteProyecto(@PathVariable(value = "codigo") String codigo) {
		this.proyectoService.deleteProyecto(codigo);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		return response;
	}
}
