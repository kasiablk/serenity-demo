package com.example.demo.integration.config;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.integration.config.CucumberSerenityDemoTestConfiguration;

@SpringBootTest(classes = CucumberSerenityDemoTestConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberRoot {

}
