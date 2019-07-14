package com.example.demo.integration.model.request;

import io.restassured.http.Method;

public class ProductById extends Request {
    public ProductById() {
        super("/product/id/{productId}", Method.GET);
    }
}
