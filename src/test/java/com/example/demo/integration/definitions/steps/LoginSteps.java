package com.example.demo.integration.definitions.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import net.serenitybdd.core.steps.ScenarioActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LoginSteps extends ScenarioActor {

	private Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
	
	@Step
	public void login(String user, String password) {
		LOGGER.info("User: " + user + " was succesfully logged in with password: " + password);

	}
}
