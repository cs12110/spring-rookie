package com.pkgs.conf.cmd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/22 17:02
 * <p>
 * since: 1.0.0
 */
@Component
@Slf4j
public class SimpleCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info("this is simple command line runner");
    }
}
