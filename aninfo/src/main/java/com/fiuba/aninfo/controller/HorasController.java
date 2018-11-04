package com.fiuba.aninfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.CargaDeHoras;

@Controller
public class HorasController {

	@RequestMapping(value="/hour", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addHour(@RequestBody CargaDeHoras cargaDeHoras) {
		ResponseEntity<String> response = new ResponseEntity<String>("Horas cargadas",HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/hour", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getHour() {
		ResponseEntity<String> response = new ResponseEntity<String>("Buena tincho",HttpStatus.OK);
		return response;
	}
}
