package com.smallkind.server;

import com.smallkind.HelloWorldService;
import org.apache.thrift.TException;

/**
 * @author smallkind
 * @description
 * @create 2017-06-15-15:09
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface{

    @Override
    public String sayHello(String userName) throws TException {
        return "Hello " + userName;
    }

}
