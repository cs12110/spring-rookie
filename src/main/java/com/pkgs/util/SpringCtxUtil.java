package com.pkgs.util;

import org.springframework.context.ApplicationContext;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 13:27
 * <p>
 * since: 1.0.0
 */
public class SpringCtxUtil {

    private static ApplicationContext context;

    public static void init(ApplicationContext ctx) {
        context = ctx;
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T getBean(Class<T> clazz) {
        Object bean = context.getBean(clazz.getName());
        return (T) bean;
    }
}
