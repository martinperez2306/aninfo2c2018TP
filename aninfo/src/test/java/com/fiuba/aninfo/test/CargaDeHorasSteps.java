package com.fiuba.aninfo.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;

import com.fiuba.aninfo.db.TablaEmpleados;
import com.fiuba.aninfo.db.TablaHoras;
import com.fiuba.aninfo.model.Empleado;
import com.fiuba.aninfo.model.Horas;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CargaDeHorasSteps {
	
	private TablaHoras tablaHoras;
	private TablaEmpleados tablaEmpleados;
	
	private Empleado empleadoTest;
	
	@Before
	public void initBaseDeDatos() {
		try {
			tablaHoras = new TablaHoras();
			tablaHoras.afterPropertiesSet();
			tablaEmpleados = new TablaEmpleados();
			tablaEmpleados.afterPropertiesSet();
		}catch(Exception e) {
			throw new RuntimeException("Erorr al crear la base de datos");
		}
		
	}
	
	@Given("^el desarrollador \"([^\"]*)\"$")
	public void el_desarrollador(String arg1) throws Exception {
		List<Empleado> empleados = tablaEmpleados.select(arg1);
		if(empleados.size() == 0)
			throw new RuntimeException("No existe el empelado ["+arg1+"]");
		empleadoTest = empleados.get(0);
	}

	@When("^carga las horas de su trabajo siendo (\\d+) horas en \"([^\"]*)\" y (\\d+) horas en \"([^\"]*)\"$")
	public void carga_las_horas_de_su_trabajo_siendo_horas_en_y_horas_en(int arg1, String arg2, int arg3, String arg4) throws Exception {
		Horas horas1 = new Horas();
		horas1.setId(1L);
		horas1.setDniEmpleado(empleadoTest.getDni());
		horas1.setCodigoProyecto(arg2);
		horas1.setCantidadDeHoras(arg1);
		
		Horas horas2 = new Horas();
		horas2.setId(2L);
		horas2.setDniEmpleado(empleadoTest.getDni());
		horas2.setCodigoProyecto(arg4);
		horas2.setCantidadDeHoras(arg3);
		
		this.tablaHoras.insert(horas1);
		this.tablaHoras.insert(horas2);
	}

	@Then("^ha cargado un total de (\\d+) horas reflejando el trabajo en cada proyecto$")
	public void ha_cargado_un_total_de_horas_reflejando_el_trabajo_en_cada_proyecto(int arg1) throws Exception {
	    Integer totalDeHoras = 0;
	    for (Horas horas : tablaHoras.select("")) {
	    	if(horas.getDniEmpleado().equals(empleadoTest.getDni())){
	    		totalDeHoras += horas.getCantidadDeHoras();
	    	}
		}
	    Assert.assertTrue(totalDeHoras.equals(arg1));
	}

	@When("^carga (\\d+) horas en \"([^\"]*)\" y (\\d+) en \"([^\"]*)\" pero su jornada laboral es de (\\d+) horas$")
	public void carga_horas_en_y_en_pero_su_jornada_laboral_es_de_horas(int arg1, String arg2, int arg3, String arg4, int arg5) throws Exception {
		Date date = new Date();
		Horas horas1 = new Horas();
		horas1.setId(1L);
		horas1.setDniEmpleado(empleadoTest.getDni());
		horas1.setCodigoProyecto(arg2);
		horas1.setCantidadDeHoras(arg1);
		horas1.setFecha(date);
		Horas horas2 = new Horas();
		horas2.setId(2L);
		horas2.setDniEmpleado(empleadoTest.getDni());
		horas2.setCodigoProyecto(arg4);
		horas2.setCantidadDeHoras(arg3);
		horas2.setFecha(date);
		this.tablaHoras.insert(horas1);
		this.tablaHoras.insert(horas2);
	}

	@Then("^le avisa que no puede cargar mas horas$")
	public void le_avisa_que_no_puede_cargar_mas_horas() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	

}
