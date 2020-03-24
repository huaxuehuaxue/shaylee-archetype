package com.shaylee.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.shaylee"})
public class ShayleeMQConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShayleeMQConsumerApplication.class, args);
    }

}
