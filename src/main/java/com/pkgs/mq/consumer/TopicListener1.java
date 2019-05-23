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
public class TopicListener1 {
    private static final Logger logger = LoggerFactory.getLogger(TopicListener1.class);

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    @SendTo("out.queue")
    public void take(String text) {
        logger.info("take:{}", text);
    }

}
