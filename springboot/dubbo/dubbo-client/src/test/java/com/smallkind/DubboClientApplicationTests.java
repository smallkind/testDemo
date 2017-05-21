package com.smallkind;

import com.smallkind.api.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void sayHelloWorldTest(){
		ApplicationContext context = SpringApplication.run(DubboClientApplication.class);
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
		helloWorldService.sayHelloWorld();
	}
}
