package com.pkgs.conf.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huanghuapeng create at 2019/5/23 20:32
 * @version 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "mqconf")
@Data
public class ActiveMqConf {

    private String user;
    private String password;
    private String brokerUrl;


    private String topicName;
    private String queueName;

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }
}
