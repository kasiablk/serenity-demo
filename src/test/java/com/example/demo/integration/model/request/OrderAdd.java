package com.example.demo.integration.model.request;

import com.example.demo.model.Body;
import io.restassured.http.Method;

public class OrderAdd extends Request {
    public OrderAdd(Body body) {
        super("/order/add", Method.POST, body);
    }
}
