package com.fiuba.aninfo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiuba.aninfo.dao.HorasDao;
import com.fiuba.aninfo.model.HorasView;
import com.fiuba.aninfo.model.Horas;

@Service
public class HorasService {
	
	@Autowired
	private HorasDao horasDao;
	
	public void cargarHoras(HorasView cargaDeHoras) {
		Horas horas = new Horas();
//		horas.setCodigoProyecto(cargaDeHoras.getProyecto().getCodigo());
//		horas.setCodigoTarea(cargaDeHoras.getTarea().getCodigo());
//		horas.setDniEmpleado(cargaDeHoras.getEmpleado().getDni());
		horas.setCantidadDeHoras(cargaDeHoras.getCantidadDeHoras());
		Date fecha = new Date();
		fecha.setYear(cargaDeHoras.getAnio());
		fecha.setMonth(cargaDeHoras.getMes());
		fecha.setDate(cargaDeHoras.getDia());
		horas.setFecha(fecha);
		
		horasDao.insert(horas);
	}
	
	public List<Horas> getAllHoras(){
		return this.horasDao.select("");
	}
}
