package com.pkgs.ctrl.test;

import com.pkgs.mq.provider.MqProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huanghuapeng create at 2019/5/23 20:58
 * @version 1.0.0
 */
@Controller
@RequestMapping("/mq")
public class MqCtrl {

    @Autowired
    private MqProvider mqProvider;

    @RequestMapping("/topic")
    @ResponseBody
    public String topic() {
        mqProvider.sendTopicMessage(5);
        return "SUCCESS";
    }


    @RequestMapping("/queue")
    @ResponseBody
    public String queue() {
        mqProvider.sendQueueMessage(5);

        return "SUCCESS";
    }
}
