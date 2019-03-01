package com.pkgs.conf.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 15:53
 * <p>
 * since: 1.0.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AntiResubmit {

    String desc() default "";
}
