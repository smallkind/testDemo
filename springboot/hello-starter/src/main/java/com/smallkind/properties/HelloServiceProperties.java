package com.smallkind.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author smallkind
 * @description
 * @create 2017-06-14-12:44
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";

    private String msg = MSG;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
