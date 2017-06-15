package com.smallkind.controller;

import com.smallkind.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiang.zhou
 * @create 2017-05-01-12:14
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping(value = "helloStarter")
    public String helloStarter(){
        return helloService.sayHello();
    }
}
