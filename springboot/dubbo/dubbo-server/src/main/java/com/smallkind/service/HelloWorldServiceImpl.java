package com.smallkind.service;

import com.smallkind.api.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



/**
 * @author smallkind
 * @description
 * @create 2017-05-21-21:56
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private final Logger logger = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Override
    public void sayHelloWorld() {
        logger.info("Hello World!");
        System.out.println("Hello World!");
    }
}
