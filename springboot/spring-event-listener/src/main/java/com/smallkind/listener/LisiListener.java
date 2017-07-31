package com.smallkind.listener;

import com.smallkind.event.ContentEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author smallkind
 * @description 无序监听器，类似于AOP机制，顺序是无法确定的
 * @create 2017-07-31-09:18
 */
@Component
public class LisiListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContentEvent) {
            System.out.println("李四收到了新的内容：" + applicationEvent.getSource());
        }
    }
}
