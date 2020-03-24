package com.shaylee.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.shaylee"})
public class ShayleeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShayleeApiApplication.class, args);
    }
}
