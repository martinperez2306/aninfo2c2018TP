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

import com.fiuba.aninfo.model.Asignacion;
import com.fiuba.aninfo.service.AsignacionesService;

@Controller
public class AsignacionesController {
	
	@Autowired
	private AsignacionesService asignacionesService;
	
	@RequestMapping(value="/asignaciones", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Asignacion>> getAsignaciones() {
		List<Asignacion> asignaciones = this.asignacionesService.getAllAsignaciones();
		ResponseEntity<List<Asignacion>> response = new ResponseEntity<List<Asignacion>>(asignaciones,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/asignaciones", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addProyect(@RequestBody Asignacion asignacion) {
		this.asignacionesService.addAsignacion(asignacion);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/asignaciones/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<String> deleteProyecto(@PathVariable(value = "id") Long id) {
		this.asignacionesService.deleteAsignacion(id);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		return response;
	}

}
