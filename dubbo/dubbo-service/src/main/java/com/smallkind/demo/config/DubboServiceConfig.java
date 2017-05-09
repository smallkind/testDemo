package com.smallkind.demo.config;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.smallkind.api.service.HelloWorldServiceApi;
import org.springframework.context.annotation.Bean;

/**
 * Created by zack.zhou on 2017/5/9.
 */
public class DubboServiceConfig extends DubbeBaseConfig{

    @Bean
    public ServiceBean<HelloWorldServiceApi> helloWord(HelloWorldServiceApi helloWorldService) {
        ServiceBean<HelloWorldServiceApi> serviceBean = new ServiceBean<>();
        serviceBean.setInterface(HelloWorldServiceApi.class);
        serviceBean.setRef(helloWorldService);
        return serviceBean;
    }
}
