package com.pkgs.mq.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author huanghuapeng create at 2019/5/23 20:42
 * @version 1.0.0
 */
@Component
public class MqProvider {

    private static Logger logger = LoggerFactory.getLogger(MqProvider.class);

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;


    public void sendQueueMessage(int times) {
        for (int index = 0; index < times; index++) {
            template.convertAndSend(queue, "queue" + index);
        }

        System.out.println("Send message is done now");
    }


    public void sendTopicMessage(int times) {
        for (int index = 0; index < times; index++) {
            template.convertAndSend(topic, "topic" + index);
        }
        System.out.println("Send message is done now");
    }


    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg) {
        logger.info("Consumer from out.queue:{}", msg);
    }
}
