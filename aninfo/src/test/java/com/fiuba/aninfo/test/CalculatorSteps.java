package com.fiuba.aninfo.test;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {
	
private Integer total;
	
	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Exception {
		total = 0;
	}

	@When("^I add (\\d+) and (\\d+)$")
	public void i_add_and(int arg1, int arg2) throws Exception {
	    total = arg1 + arg2;
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int arg1) throws Exception {
		Assert.assertEquals(arg1, total.intValue());
	}


}
