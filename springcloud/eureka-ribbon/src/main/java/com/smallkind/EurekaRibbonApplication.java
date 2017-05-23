package com.smallkind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker //@EnableCircuitBreaker注解开启断路器功能
@EnableDiscoveryClient //通过@EnableDiscoveryClient注解来添加发现服务能力
@SpringBootApplication
public class EurekaRibbonApplication {

    //创建RestTemplate实例，并通过@LoadBalanced注解开启均衡负载能力
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonApplication.class, args);
    }

}
