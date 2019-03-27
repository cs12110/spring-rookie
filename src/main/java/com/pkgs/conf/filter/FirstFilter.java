package com.pkgs.conf.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/19 8:22
 * <p>
 * since: 1.0.0
 */
@Slf4j
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("First filter before");

        chain.doFilter(request, response);

        log.info("First filter after");
    }

    @Override
    public void destroy() {
        log.info("First filter destroy");
    }
}
