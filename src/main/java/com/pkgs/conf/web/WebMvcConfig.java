package com.pkgs.conf.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 16:25
 * <p>
 * since: 1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置js和css的位置
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/web/static/");
        registry.addResourceHandler("/simple/**").addResourceLocations("classpath:/web/simple/");
        registry.addResourceHandler("/login/**").addResourceLocations("classpath:/web/login/");
    }
}
