package com.pkgs.conf.enable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghuapeng create at 2019/5/9 20:01
 * @version 1.0.0
 */
@Configuration
public class MyEnable {

    private static Logger logger = LoggerFactory.getLogger(MyEnable.class);


    @Bean(name = "myFuckingMap")
    public Map<String, Object> initMap() {

        logger.info("1");

        Map<String, Object> map = new HashMap<>(2);
        map.put("class", MyEnable.class.getName());
        map.put("method", "initMap()");

        logger.info("2");

        return map;
    }

}
