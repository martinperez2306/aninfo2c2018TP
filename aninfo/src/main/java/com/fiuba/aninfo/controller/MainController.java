package com.fiuba.aninfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/cargaHoras",method = RequestMethod.GET)
	public String cargaHoras() {
		return "cargaHoras";
	}
	
	@RequestMapping(value="/asignaciones",method = RequestMethod.GET)
	public String asignaciones() {
		return "asignaciones";
	}
}
