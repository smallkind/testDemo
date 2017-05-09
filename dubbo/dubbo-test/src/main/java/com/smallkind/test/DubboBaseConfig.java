package com.smallkind.test;

import com.alibaba.dubbo.config.*;
import org.springframework.context.annotation.Bean;

/**
 * Created by zack.zhou on 2017/5/9.
 */
public class DubboBaseConfig {

    @Bean(name = "applicationConfig")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-test");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("N/A");
        return registryConfig;
    }

    @Bean(name = "monitorConfig")
    public MonitorConfig monitorConfig() {
        MonitorConfig mc = new MonitorConfig();
        mc.setProtocol("dubbo");
        return mc;
    }

    @Bean(name = "protocolConfig")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20881);
        return protocolConfig;
    }

    @Bean(name = "consumerConfig")
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(5000);
        consumerConfig.setRetries(3);
        return consumerConfig;
    }
}
