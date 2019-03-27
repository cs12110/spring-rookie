package com.pkgs.conf.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: 分页插件
 *
 * @author cs12110 create at: 2019/3/6 21:13
 * Since: 1.0.0
 */
@Configuration
public class MybatisConf {

    /**
     * mybatis 分页拦截器
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
