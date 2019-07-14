package com.example.demo.integration.definitions.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import com.example.demo.integration.model.CommonRequests;
import com.example.demo.integration.model.request.ProductById;
import com.example.demo.integration.model.request.ProductFromStore;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.util.Arrays;

import com.example.demo.model.Product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProductApiSteps {
    @Steps
    private CommonRequests commonRequests;

    @Step
    public void getProductsByStoreId(String store) {
        commonRequests.callEndpoint(new ProductFromStore(), store);
    }

    @Step
    public void getProductById(int productId) {
        commonRequests.callEndpoint(new ProductById(), productId);
    }

    @Step
    public void responseContainsProductNamed(String productName) {
        Product[] products = SerenityRest.then().extract().body().as(Product[].class);
        assertThat(Arrays.asList(products), hasItem(hasProperty("name", equalTo(productName))));
    }

    @Step
    public void responseContainsNumberOfProducts(int numberOfProducts) {
        Product[] products = SerenityRest.then().extract().body().as(Product[].class);
        assertThat(Arrays.asList(products), hasSize(numberOfProducts));
    }
}
