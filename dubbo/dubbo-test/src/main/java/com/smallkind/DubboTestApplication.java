package com.smallkind;

import com.smallkind.api.service.HelloWorldServiceApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DubboTestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DubboTestApplication.class, args);
		HelloWorldServiceApi api = (HelloWorldServiceApi) context.getBean("HelloWorldService");

		String response = api.hello("hello world");
		System.out.println(response);
	}
}
