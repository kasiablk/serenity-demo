package com.example.demo.integration.model.request;

import com.example.demo.model.Body;
import io.restassured.http.Method;
import lombok.Data;
import org.jcodings.util.Hash;

import java.util.HashMap;
import java.util.Map;

@Data
public class Request {
    private String url;
    private Method method;
    private Body body;
    private Map<String, String> headers = new HashMap<String,String>();

    public Request(String url, Method method, Body body) {
        this(url, method);
        this.body = body;
    }

    public Request(String url, Method method) {
        this.url = url;
        this.method = method;
        headers.put("someHeader", "headerValue");
    }
}
