package com.example.demo.integration.model.request;

import io.restassured.http.Method;

public class ProductFromStore extends Request {
    public ProductFromStore() {
        super("/products/store/{store}", Method.GET);
    }
}
