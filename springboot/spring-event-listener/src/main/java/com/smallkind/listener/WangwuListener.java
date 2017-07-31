package com.smallkind.listener;

import com.smallkind.event.ContentEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author smallkind
 * @description
 * @create 2017-07-31-09:21
 */
@Component
public class WangwuListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == ContentEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == String.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("王五在孙六之前收到新的内容：" + applicationEvent.getSource());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
