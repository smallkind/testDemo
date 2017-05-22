package com.smallkind.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * author: zack.zhou
 * date: 2017/5/22 15:39
 **/
@RestController
public class HelloWorldController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello")
    public String helloWorld(){
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World!";
    }

}
