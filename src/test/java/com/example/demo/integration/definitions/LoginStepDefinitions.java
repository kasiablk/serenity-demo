package com.example.demo.integration.definitions;

import com.example.demo.config.UserConfig;
import com.example.demo.integration.config.CucumberRoot;
import com.example.demo.integration.definitions.steps.LoginSteps;
import com.example.demo.integration.definitions.steps.ResponseSteps;
import com.example.demo.model.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginStepDefinitions extends CucumberRoot {
    @Steps
    private LoginSteps loginSteps;

    @Autowired
    private User userConfig;

    @Given("^that I am logged in as (.*)$")
    public void user_logs_in(String user) {
        String login = userConfig.getClientLogin(user);
        String password = userConfig.getClientPassword(user);
        loginSteps.login(login, password);

        System.out.println("aaa");
    }
}
