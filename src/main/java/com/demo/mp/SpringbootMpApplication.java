package com.demo.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringbootMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMpApplication.class, args);
    }

}
