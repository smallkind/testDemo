package com.smallkind.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author smallkind
 * @description
 * @create 2017-05-21-22:03
 */
public class DubboBaseConfig {

    @Value("${dubbo.port}")
    private Integer port;

    @Value("${dubbo.application.name}")
    private String applicationName;

    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddress);
        return registryConfig;
    }

    @Bean
    public ApplicationConfig application() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    @Bean(name = "protocolConfig")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(port);
        return protocolConfig;
    }

    @Bean
    public ProviderConfig provider(ProtocolConfig protocol) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setProtocol(protocol);
        providerConfig.setRetries(3);
        providerConfig.setTimeout(5000);
        return providerConfig;
    }
}
