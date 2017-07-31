package com.smallkind;

import com.smallkind.event.ContentEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEventListenerApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testPublishEvent(){
		applicationContext.publishEvent(new ContentEvent("Hello Event and Listener!"));
	}
}
