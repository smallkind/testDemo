package com.smallkind;

import com.smallkind.api.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DubboClientApplication.class, args);
		ApplicationContext context = SpringApplication.run(DubboClientApplication.class);
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
		helloWorldService.sayHelloWorld();
	}
}
