package com.pkgs.conf.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 13:56
 * <p>
 * since: 1.0.0
 */
@Configuration
@Aspect
@Slf4j
public class ReqLogInterceptor {

    @Pointcut("execution(* com.pkgs.ctrl..*(..))")
    public void point() {
    }

    @Before("point()")
    public void interceptor(JoinPoint joinPoint) {
        try {

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (null != attributes) {
                HttpServletRequest request = attributes.getRequest();

                StringBuilder builder = new StringBuilder();
                builder.append(" url:").append(request.getRequestURL());
                builder.append(" method:").append(request.getMethod());
                builder.append(" mapping:").append(joinPoint.getSignature());


                log.info(builder.toString());
            }

        } catch (Throwable e) {
            log.error("{}", e);
        }
    }
}
