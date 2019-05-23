package com.pkgs.conf.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro security
 *
 * @author cs12110 create at: 2019/3/5 21:41
 * Since: 1.0.0
 */
@Configuration
@Slf4j
public class ShiroSecurity {


    /**
     * Security manager
     *
     * @return SessionsSecurityManager
     */
    @Bean
    public SessionsSecurityManager sessionsSecurityManager() {
        SessionsSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm());

        return manager;
    }

    /**
     * 实现校权和认证
     *
     * @return Realm
     */
    @Bean
    public Realm realm() {
        return new SysRealm();
    }

    /**
     * 解决springboot注入问题
     *
     * @return DefaultAdvisorAutoProxyCreator
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 定义不要被拦截的路径
     *
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        Map<String, String> filterMap = new HashMap<>(3);
        // /rookie/下的所有请求不被拦截
        filterMap.put("/rookie/**", "anon");
        filterMap.put("/login/**", "anon");
        filterMap.put("/mq/**", "anon");

        // 其他路径需要登录,这个配置一定要放到最后,不然全部会被拦截
        filterMap.put("/**", "user");


        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        factory.setSecurityManager(sessionsSecurityManager());

        factory.setLoginUrl("/login/login.html");
        factory.setUnauthorizedUrl("/home/forbid");
        factory.setFilterChainDefinitionMap(filterMap);


        return factory;
    }


    /**
     * 缓存设置
     *
     * @return CacheManager
     */
    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }
}
