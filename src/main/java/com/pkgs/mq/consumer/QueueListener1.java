package com.pkgs.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author huanghuapeng create at 2019/5/23 20:45
 * @version 1.0.0
 */
@Component
public class QueueListener1 {
    private static final Logger logger = LoggerFactory.getLogger(QueueListener1.class);

    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String take(String text) {
        logger.info("take:{}", text);

        return "ql1-: " + text;
    }

}
