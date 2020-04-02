package com.shaylee.api.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.shaylee"})
public class ShayleeApiConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShayleeApiConsumerApplication.class, args);
    }
}
