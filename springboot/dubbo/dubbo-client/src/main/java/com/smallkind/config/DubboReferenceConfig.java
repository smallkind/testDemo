package com.smallkind.config;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.smallkind.api.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smallkind
 * @description
 * @create 2017-05-21-22:25
 */
@Configuration
public class DubboReferenceConfig extends DubboBaseConfig{

    @Bean("helloWorldService")
    public ReferenceBean<HelloWorldService> helloWorldService() {
        ReferenceBean<HelloWorldService> ref = new ReferenceBean<>();
        ref.setId("helloWorldService");
        ref.setInterface(HelloWorldService.class);
        ref.setTimeout(5000);
        ref.setRetries(3);
        ref.setUrl("dubbo://127.0.0.1:20880");
        return ref;
    }
}
