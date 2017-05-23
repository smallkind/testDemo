package com.smallkind;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//通过@EnableDiscoveryClient注解，激活Eureka中的DiscoveryClient实现，实现Controller中对服务信息的输出
@EnableDiscoveryClient
@SpringBootApplication
public class ComputerServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputerServiceApplication.class).web(true).run(args);

    }
}
