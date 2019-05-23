package com.pkgs.listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听SysEvent事件
 *
 * @author cs12110 create at 2019/5/9 20:32
 * @version 1.0.0
 */
@Component
public class SysEventListener implements ApplicationListener<SysEvent> {

    private static Logger logger = LoggerFactory.getLogger(SysEventListener.class);

    @Override
    public void onApplicationEvent(SysEvent sysEvent) {
        try {
            logger.info("{}", JSON.toJSONString(sysEvent.getSource()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
