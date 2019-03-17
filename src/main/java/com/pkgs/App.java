package com.pkgs;

import com.pkgs.util.SpringCtxUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;




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

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        SpringCtxUtil.init(context);

        log.info("Good luck, rookie");
    }
}
