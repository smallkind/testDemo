package com.smallkind.controller;

import com.smallkind.test.BaseTest;
import org.junit.Test;

/**
 * @author smallkind
 * @description
 * @create 2017-06-21-14:30
 */
public class HelloConTroller2Test extends BaseTest<HelloController>{


    @Test
    public void helloTest() throws Exception{
        System.out.println(getRequest("/hello"));
    }


}
