package com.pkgs;

import com.pkgs.conf.mq.ActiveMqConf;
import com.pkgs.entity.rookie.MyEntity;
import com.pkgs.listener.SysEvent;
import com.pkgs.mq.provider.MqProvider;
import com.pkgs.util.SpringCtxUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import javax.annotation.PostConstruct;


/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 11:50
 * <p>
 * since: 1.0.0
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.pkgs.mapper")
@Slf4j
public class App {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        SpringCtxUtil.init(context);

        log.info("Good luck, rookie");
    }

    @Autowired
    private MyEntity entity;


    @Autowired
    private MqProvider provider;

    @PostConstruct
    public void init() {
        log.info(entity.toString());
        /*
         * sys event
         */
        // applicationContext.publishEvent(new SysEvent("1"));
        //applicationContext.publishEvent(new SysEvent("2"));


        //provider.sendQueueMessage(3);
        //provider.sendTopicMessage(5);
    }
}
