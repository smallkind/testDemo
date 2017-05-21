package com.smallkind.config;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.smallkind.api.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smallkind
 * @description
 * @create 2017-05-21-22:05
 */
@Configuration
public class DubboServiceConfig extends DubboBaseConfig{

    @Bean
    public ServiceBean<HelloWorldService> getHelloWorldServiceBean(HelloWorldService helloWorldService){
        ServiceBean<HelloWorldService> serviceServiceBean = new ServiceBean<>();
        serviceServiceBean.setInterface(HelloWorldService.class);
        serviceServiceBean.setRef(helloWorldService);
        return serviceServiceBean;
    }
}
