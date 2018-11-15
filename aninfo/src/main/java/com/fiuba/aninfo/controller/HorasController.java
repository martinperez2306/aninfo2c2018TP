package com.fiuba.aninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiuba.aninfo.model.CargaDeHoras;
import com.fiuba.aninfo.model.Horas;
import com.fiuba.aninfo.service.HorasService;

@Controller
public class HorasController {
	
	@Autowired
	private HorasService horasService;

	@RequestMapping(value="/hours", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addHour(@RequestBody CargaDeHoras cargaDeHoras) {
		ResponseEntity<String> response = new ResponseEntity<String>("Horas cargadas",HttpStatus.OK);
		this.horasService.cargarHoras(cargaDeHoras);
		return response;
	}
	
	@RequestMapping(value="/hours", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Horas>> getHour() {
		List<Horas> horas = this.horasService.getAllHoras();
		ResponseEntity<List<Horas>> response = new ResponseEntity<List<Horas>>(horas,HttpStatus.OK);
		return response;
	}
}
