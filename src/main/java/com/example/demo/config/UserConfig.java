package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("!notDefaultProfile")
@PropertySource("classpath:/users/user.properties")
@Configuration
public class UserConfig {
}
