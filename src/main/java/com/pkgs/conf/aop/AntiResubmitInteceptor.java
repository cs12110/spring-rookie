package com.pkgs.conf.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:14
 * <p>
 * since: 1.0.0
 */
@Component
@Aspect
@Slf4j
public class AntiResubmitInteceptor {

    @Around("@annotation(com.pkgs.conf.anno.AntiResubmit)")
    public Object check(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != attributes) {
            HttpServletRequest request = attributes.getRequest();
            HttpSession session = request.getSession(false);

            if (null == session) {
                log.error("Session is null");
                return "Sorry about that , session is null";
            }

            String sessionId = session.getId();
            String uri = request.getRequestURI();

            String key = sessionId + ":" + uri;
            if (null == session.getAttribute(key)) {
                session.setAttribute(key, 1);
                try {
                    return joinPoint.proceed();
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    session.removeAttribute(key);
                }
            } else {
                log.error("{} resubmit", uri);
            }
        }
        return "Resubmit";
    }
}
