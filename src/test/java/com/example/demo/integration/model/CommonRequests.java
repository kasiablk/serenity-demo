package com.example.demo.integration.model;

import com.example.demo.Constants;
import com.example.demo.integration.model.request.Request;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CommonRequests {

    @Step("Calling endpoint")
    public ResponseBodyExtractionOptions callEndpoint(Request request, Object... params) {
        RequestSpecification requestSpecification = SerenityRest.given();

        if (request.getMethod() != Method.GET) {
            requestSpecification.body(request.getBody());
        }
        return callProperMethod(request, requestSpecification, params);
    }

    public void callEndpointWithNotAllowedHeader(Request request, Object... params) {
        RequestSpecification requestSpecification = SerenityRest.given()
                .config(Constants.OVERRIDE_SOME_HEADER)
                .header("someHeader", "someValue")
                .headers(request.getHeaders())
                .relaxedHTTPSValidation()
                .body(Constants.EXAMPLE_BODY);

        callProperMethod(request, requestSpecification, params);
    }

    private ResponseBodyExtractionOptions callProperMethod(Request request, RequestSpecification requestSpecification, Object... params) {
        Response response = null;
        switch (request.getMethod()) {
            case GET:
                response = requestSpecification.get(request.getUrl(), params);
                break;
            case POST:
                response = requestSpecification.post(request.getUrl(), params);
                break;
            case PUT:
                response = requestSpecification.put(request.getUrl(), params);
                break;
            case PATCH:
                response = requestSpecification.patch(request.getUrl(), params);
                break;
        }
        return response;
    }

    private ResponseBodyExtractionOptions callInvalidMethod(Request request, RequestSpecification requestSpecification, Object... params) {
        Response response = null;
        switch (request.getMethod()) {
            case GET:
                response = requestSpecification.post(request.getUrl(), params);
                break;
            case POST:
                response = requestSpecification.patch(request.getUrl(), params);
                break;
            case PUT:
                response = requestSpecification.post(request.getUrl(), params);
                break;
            case PATCH:
                response = requestSpecification.post(request.getUrl(), params);
                break;
        }
        return response;
    }

}
