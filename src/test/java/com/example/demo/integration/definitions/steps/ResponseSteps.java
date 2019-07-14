package com.example.demo.integration.definitions.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ResponseSteps {

	private Logger LOGGER = LoggerFactory.getLogger(ResponseSteps.class);

	@Step
	public void responseIsNotEmpty() {
		assertThat(SerenityRest.then().extract().body().asString(), not(isEmptyOrNullString()));
	}

	@Step
	public void responseIsEmpty() {
		assertThat(SerenityRest.then().extract().body().asString(), isEmptyOrNullString());
	}
	
	@Step
	public void responseHttpStatusEquals(int httpStatus) {
		assertThat(SerenityRest.then().extract().statusCode(), is(equalTo(httpStatus)));
		
	}
	
}
