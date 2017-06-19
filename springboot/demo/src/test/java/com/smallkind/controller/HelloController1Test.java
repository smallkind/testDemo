package com.smallkind.controller;

import com.smallkind.HelloStarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author smallkind
 * @description
 * @create 2017-06-19-08:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloStarterApplication.class)
@WebIntegrationTest
public class HelloController1Test {

    @Test(expected = HttpClientErrorException.class)
    public void helloTest(){
        try {
            RestTemplate rest = new RestTemplate();
            System.out.println(rest.getForObject("http://localhost:8080/hello",String.class));
        }catch (HttpClientErrorException e){
            throw e;
        }

    }
}
