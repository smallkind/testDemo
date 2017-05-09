package com.smallkind.test;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.smallkind.api.service.HelloWorldServiceApi;
import org.springframework.context.annotation.Bean;

/**
 * Created by zack.zhou on 2017/5/9.
 */
public class DubboReferenceConfig extends DubboBaseConfig{

    @Bean("helloWorldService")
    public ReferenceBean<HelloWorldServiceApi> helloWorldService() {
        ReferenceBean<HelloWorldServiceApi> ref = new ReferenceBean<>();
        ref.setId("HelloWorldService");
        ref.setInterface(HelloWorldServiceApi.class);
        ref.setTimeout(5000);
        ref.setRetries(3);
        ref.setUrl("dubbo://127.0.0.1:20881");
        return ref;
    }
}
