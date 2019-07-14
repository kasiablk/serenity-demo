package com.example.demo.model;

import lombok.Data;
import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Map;

@Data
@Configuration
public class User {
    @Value("#{${login}}")
    private Map<String, String> logins;

    @Value("#{${password}}")
    private Map<String, String> passwords;

    public String getClientLogin(String user) {
        return this.getLogins().get(getUserName(user));
    }

    public String getClientPassword(String user) {
        return this.getPasswords().get(getUserName(user));
    }

    private String getUserName(String user) {
        return StringUtils.containsWhitespace(user) ? CaseUtils.toCamelCase(user, false) : user;
    }
}
