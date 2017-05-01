package com.smallkind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiang.zhou
 * @create 2017-05-01-12:14
 */
@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello world!";
    }
}
