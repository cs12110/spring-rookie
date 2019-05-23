package com.pkgs.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author cs12110 create at 2019/5/9 20:31
 * @version 1.0.0
 */
public class SysEvent extends ApplicationEvent {
    /**
     * 事件
     *
     * @param source 可以传入事件特定的值
     */
    public SysEvent(Object source) {
        super(source);
    }
}
