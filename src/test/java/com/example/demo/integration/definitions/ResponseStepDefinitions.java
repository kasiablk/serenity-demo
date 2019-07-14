package com.example.demo.integration.definitions;

import com.example.demo.integration.config.CucumberRoot;
import com.example.demo.integration.definitions.steps.LoginSteps;

import com.example.demo.integration.definitions.steps.ResponseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ResponseStepDefinitions extends CucumberRoot {
	@Steps
	private ResponseSteps responseSteps;

	@And("^response body is empty$")
	public void user_receives_empty_response_body() {
		responseSteps.responseIsEmpty();
	}

	@And("^response body is not empty$")
	public void user_receives_not_empty_response_body() {
		responseSteps.responseIsNotEmpty();
	}
	
	@Then("^I receive response status (\\d+)$")
	public void response_has_http_status(Integer httpStatus) {
		responseSteps.responseHttpStatusEquals(httpStatus);
	}
	
}
