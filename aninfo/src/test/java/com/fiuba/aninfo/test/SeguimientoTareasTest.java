package com.fiuba.aninfo.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		features = "classpath:cucumber/seguimientoTareas.feature"
)
public class SeguimientoTareasTest {

}
