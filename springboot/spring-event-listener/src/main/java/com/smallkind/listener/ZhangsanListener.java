package com.smallkind.listener;

import com.smallkind.event.ContentEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author smallkind
 * @description
 * @create 2017-07-31-09:20
 */
@Component
public class ZhangsanListener implements ApplicationListener<ContentEvent> {

    @Override
    public void onApplicationEvent(ContentEvent event) {
        System.out.println("张三收到了新的内容：" + event.getSource());
    }
}
