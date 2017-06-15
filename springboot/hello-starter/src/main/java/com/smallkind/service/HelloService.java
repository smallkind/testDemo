package com.smallkind.service;

/**
 * @author smallkind
 * @description
 * @create 2017-06-15-08:36
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
