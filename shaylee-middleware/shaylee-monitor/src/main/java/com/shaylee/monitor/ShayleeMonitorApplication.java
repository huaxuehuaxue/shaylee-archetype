package com.shaylee.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAdminServer
@SpringCloudApplication
@ComponentScan(basePackages = {"com.shaylee"})
public class ShayleeMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShayleeMonitorApplication.class, args);
    }
}
