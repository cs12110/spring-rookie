package com.pkgs.conf.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();

                Map<String, Object> map = new HashMap<>(3);
                map.put("url", request.getRequestURL());
                map.put("method", request.getMethod());
                map.put("mapping", signature.getMethod());

                log.info(JSON.toJSONString(map));
            }

        } catch (Throwable e) {
            log.error("{}", e.getMessage());
        }
    }
}
