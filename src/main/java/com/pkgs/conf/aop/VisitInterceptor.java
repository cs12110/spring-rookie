package com.pkgs.conf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author cs12110 create at 2019-04-11 22:20
 * <p>
 * @since 1.0.0
 */
@Aspect
@Component
public class VisitInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(VisitInterceptor.class);

    @Before("execution(public * com.pkgs.ctrl..*(..))")
    public void log(JoinPoint point) {
        try {
            Signature signature = point.getSignature();
            Class declaringType = signature.getDeclaringType();
            String name = signature.getName();

            logger.info("{}#{}", declaringType.getName(), name);

            //throw new IllegalArgumentException("just test");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
