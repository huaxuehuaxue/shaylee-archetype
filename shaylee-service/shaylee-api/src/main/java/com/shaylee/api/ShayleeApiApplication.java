package com.shaylee.api;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.shaylee"})
@EnableFeignClients(basePackages = {"com.shaylee"})
public class ShayleeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShayleeApiApplication.class, args);
    }
}
