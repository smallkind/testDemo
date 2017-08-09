package com.smallkind.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author smallkind
 * @description
 * @create 2017-08-06-14:37
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/test")
    public String test()
    {
        return "test";
    }
}
