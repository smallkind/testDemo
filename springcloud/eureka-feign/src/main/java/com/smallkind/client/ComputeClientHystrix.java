package com.smallkind.client;

import org.springframework.stereotype.Component;

/**
 * @author smallkind
 * @description
 * @create 2017-05-23-15:14
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(Integer a, Integer b) {
        return -9999;
    }
}
