package com.smallkind;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputerServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputerServiceApplication.class).web(true).run(args);

    }
}
