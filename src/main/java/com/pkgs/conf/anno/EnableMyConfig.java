package com.pkgs.conf.anno;

import com.pkgs.conf.enable.MyEnable;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author huanghuapeng create at 2019/5/9 20:00
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyEnable.class)
public @interface EnableMyConfig {
}
