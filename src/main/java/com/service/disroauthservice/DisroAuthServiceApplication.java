package com.service.disroauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class  DisroAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisroAuthServiceApplication.class, args);
    }

}
