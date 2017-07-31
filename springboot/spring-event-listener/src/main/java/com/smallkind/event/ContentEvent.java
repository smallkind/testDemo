package com.smallkind.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author smallkind
 * @description
 * @create 2017-07-31-09:16
 */
public class ContentEvent extends ApplicationEvent {

    public ContentEvent(final String content) {
        super(content);
    }
}
