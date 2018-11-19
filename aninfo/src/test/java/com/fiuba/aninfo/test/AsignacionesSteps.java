package com.fiuba.aninfo.test;

import java.util.List;

import org.junit.Assert;

import com.fiuba.aninfo.db.TablaAsignaciones;
import com.fiuba.aninfo.db.TablaEmpleados;
import com.fiuba.aninfo.db.TablaProyectos;
import com.fiuba.aninfo.db.TablaTareas;
import com.fiuba.aninfo.model.Asignacion;
import com.fiuba.aninfo.model.Empleado;
import com.fiuba.aninfo.model.Proyecto;
import com.fiuba.aninfo.model.Tarea;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AsignacionesSteps {
	
	private TablaEmpleados tablaEmpleados;
	private TablaProyectos tablaProyectos;
	private TablaTareas tablaTareas;
	private TablaAsignaciones tablaAsignaciones;
	
	@Before
	public void initDataBase() {
		try {
			this.tablaEmpleados = new TablaEmpleados();
			this.tablaEmpleados.afterPropertiesSet();
			this.tablaProyectos = new TablaProyectos();
			this.tablaProyectos.afterPropertiesSet();
			this.tablaTareas = new TablaTareas();
			this.tablaTareas.afterPropertiesSet();
			this.tablaAsignaciones = new TablaAsignaciones();
			this.tablaAsignaciones.afterPropertiesSet();
			}catch(Exception e) {
			throw new RuntimeException("Error al crear la base de datos",e);
		}
	}
	
	@Given("^un gerente de operaciones$")
	public void un_gerente_de_operaciones() throws Exception {
	    System.out.println("Gerente de Operaciones usa la aplicacion");
	}

	@When("^quiere distribuir las tareas$")
	public void quiere_distribuir_las_tareas() throws Exception {
	    List<Tarea> tareas = this.tablaTareas.select("");
	    System.out.println("Se puede asignar las siguientes tareas");
	    for (Tarea tarea : tareas) {
			System.out.println("Tarea: ["+tarea.getNombre()+"]");
		}
	}

	@Then("^elige para cada tarea un desarrollador que la tendra asignada\\.$")
	public void elige_para_cada_tarea_un_desarrollador_que_la_tendra_asignada() throws Exception {
	    List<Empleado> empleados = this.tablaEmpleados.select("");
	    System.out.println("Se puede asignar las tareas a los siguientes empleados");
	    for (Empleado empleado : empleados) {
	    	System.out.println("Tarea: ["+empleado.getNombre()+"]");
		}
	}

	@When("^asigna la tarea desarrollo con codigo \"([^\"]*)\" al desarrollador \"([^\"]*)\" para el proyecto \"([^\"]*)\"$")
	public void asigna_la_tarea_desarrollo_con_codigo_al_desarrollador_para_el_proyecto(String arg1, String arg2, String arg3) throws Exception {
	    List<Tarea> tareaAAsignar = this.tablaTareas.select(arg1);
	    if(tareaAAsignar.isEmpty())
	    	throw new RuntimeException("No existe tarea con codigo ["+arg1+"]");
	    List<Empleado> empleadoAsignado = this.tablaEmpleados.select(arg2);
	    if(empleadoAsignado.isEmpty())
	    	throw new RuntimeException("No existe empleado con dni ["+arg2+"]");
	    List<Proyecto> proyectos = this.tablaProyectos.select(arg3);
	    if(proyectos.isEmpty())
	    	throw new RuntimeException("No existe proyecto con codigo ["+arg3+"]");
	    Asignacion asignacion = new Asignacion();
	    asignacion.setCodigoTarea(tareaAAsignar.get(0).getCodigo());
	    asignacion.setDniEmpleado(empleadoAsignado.get(0).getDni());
	    asignacion.setCodigoProyecto(proyectos.get(0).getCodigo());
	    tablaAsignaciones.insert(asignacion);
	}

	@Then("^queda registrada la asginacion de la tarea que luego sera mostrada al empleado \"([^\"]*)\"$")
	public void queda_registrada_la_asginacion_de_la_tarea_que_luego_sera_mostrada_al_empleado(String arg1) throws Exception {
	    List<Asignacion> asignaciones = this.tablaAsignaciones.select("");
	    Assert.assertTrue(!asignaciones.isEmpty());
	    Asignacion asignacion = asignaciones.get(0);
	    Assert.assertTrue(asignacion.getDniEmpleado().equals(arg1));
	    List<Tarea> tareasAsignadas = this.tablaTareas.select("");
	    Assert.assertTrue(!tareasAsignadas.isEmpty());
	    Tarea tarea = tareasAsignadas.get(0);
	    System.out.println("El empleado ["+arg1+"] tiene asignada la tarea ["+tarea.getNombre()+"]");
	}

	@When("^re asigna una tarea al desarrollador \"([^\"]*)\" con codigo \"([^\"]*)\" reemplazando el codigo \"([^\"]*)\" para \"([^\"]*)\"$")
	public void re_asigna_una_tarea_al_desarrollador_con_codigo_reemplazando_el_codigo_a_para(String arg1, String arg2, String arg3, String arg4) throws Exception {
	    this.asigna_la_tarea_desarrollo_con_codigo_al_desarrollador_para_el_proyecto(arg3, arg1, arg4);
		Asignacion asignacion = this.tablaAsignaciones.select("").get(0);
	    Assert.assertTrue(asignacion.getDniEmpleado().equals(arg1));
	    Assert.assertTrue(asignacion.getCodigoTarea().equals(arg3));
	    Assert.assertTrue(asignacion.getCodigoProyecto().equals(arg4));
	    asignacion.setCodigoTarea(arg2);
	}

	@Then("^se ven impactados los cambios en la asignacion y se le informa a \"([^\"]*)\" sobre los cambios en la tarea \"([^\"]*)\"$")
	public void se_ven_impactados_los_cambios_en_la_asignacion_y_se_le_informa_al_desarrollador_sobre_los_cambios_en_la_tarea(String arg1, String arg2) throws Exception {
	    Asignacion asignacion = this.tablaAsignaciones.select("").get(0);
	    Assert.assertTrue(asignacion.getDniEmpleado().equals(arg1));
	    Assert.assertTrue(asignacion.getCodigoTarea().equals(arg2));
	    Tarea tarea = this.tablaTareas.select(arg2).get(0);
	    System.out.println("["+arg1+"] ahora tiene asignada ["+tarea.getNombre()+"]");
	}

	@When("^re asigna una tarea al desarrollador \"([^\"]*)\" que le habia asignado a \"([^\"]*)\"$")
	public void re_asigna_una_tarea_al_desarrollador_que_le_habia_asignado_a(String arg1, String arg2) throws Exception {
	    this.asigna_la_tarea_desarrollo_con_codigo_al_desarrollador_para_el_proyecto("01", arg2, "psaSpringCRM");
		Asignacion asignacion = this.tablaAsignaciones.select("").get(0);
	    Assert.assertTrue(asignacion.getDniEmpleado().equals(arg2));
	    asignacion.setDniEmpleado(arg1);
	    Tarea tarea = this.tablaTareas.select(asignacion.getCodigoTarea()).get(0);
	    System.out.println("["+arg2+"] ya no tiene la tarea ["+tarea.getNombre()+"]");
	    System.out.println("["+arg1+"] ahora tiene asignada la tarea ["+tarea.getNombre()+"]");
	}

	@Then("^el desarrollador \"([^\"]*)\" ya no tiene tareas asignadas$")
	public void el_desarrollador_ya_no_tiene_tareas_asignadas(String arg1) throws Exception {
	    Asignacion asignacion = this.tablaAsignaciones.select("").get(0);
	    Assert.assertTrue(!asignacion.getDniEmpleado().equals(arg1));
	}


}
