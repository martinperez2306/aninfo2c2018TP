package com.fiuba.aninfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/cargaHoras/{dni}", method = RequestMethod.GET)
	public String cargaHoras(@PathVariable(value = "dni") String dni) {
		return "cargaHoras";
	}

	@RequestMapping(value = "/operaciones/{dni}", method = RequestMethod.GET)
	public String operaciones(@PathVariable(value = "dni") String dni) {
		return "operaciones";
	}

	@RequestMapping(value = "/operaciones/{dni}/{proyecto}", method = RequestMethod.GET)
	public String tareas(@PathVariable(value = "dni") String dni, @PathVariable(value = "proyecto") String proyecto) {
		return "tareas";
	}

	@RequestMapping(value = "/operaciones/{dni}/{proyecto}/{tarea}", method = RequestMethod.GET)
	public String asignaciones(@PathVariable(value = "dni") String dni,
			@PathVariable(value = "proyecto") String proyecto,
			@PathVariable(value = "tarea") String tarea) {
		return "asignaciones";
	}

}
