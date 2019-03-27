package com.pkgs.conf.web;

import com.pkgs.conf.filter.FirstFilter;
import com.pkgs.conf.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/19 8:23
 * <p>
 * since: 1.0.0
 */
@Configuration
public class FilterConf {

    @Bean
    public FilterRegistrationBean firstFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();

        // order: 值越小,优先级越高
        registrationBean.setFilter(new FirstFilter());
        registrationBean.setOrder(10);

        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean secondFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();

        // order: 值越小,优先级越高
        registrationBean.setFilter(new SecondFilter());
        registrationBean.setOrder(20);

        return registrationBean;
    }
}
