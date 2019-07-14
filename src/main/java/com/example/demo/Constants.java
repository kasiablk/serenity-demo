package com.example.demo;

import io.restassured.config.RestAssuredConfig;

import static io.restassured.config.HeaderConfig.headerConfig;

public class Constants {
    public static final RestAssuredConfig OVERRIDE_SOME_HEADER = RestAssuredConfig.config().headerConfig(headerConfig()
            .overwriteHeadersWithName("SOME_NAME"));
    public static final String EXAMPLE_BODY = "some body";
}
