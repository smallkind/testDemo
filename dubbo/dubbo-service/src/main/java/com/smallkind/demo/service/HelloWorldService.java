package com.smallkind.demo.service;

import com.smallkind.api.service.HelloWorldServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zack.zhou on 2017/5/9.
 */
public class HelloWorldService implements HelloWorldServiceApi {
    private final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    @Override
    public String hello(String name) {
        log.info("hello {}!", name);
        return String.format("hello %s!", name);
    }
}
