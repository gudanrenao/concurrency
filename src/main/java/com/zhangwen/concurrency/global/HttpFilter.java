package com.zhangwen.concurrency.global;

import com.zhangwen.concurrency.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhangwen
 * @since 2018/10/13 23:23
 */
@Slf4j
public class HttpFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("threadId is {},request action is {}",Thread.currentThread().getId(),request.getRequestURI());
        RequestHolder.add("threadId=" + Thread.currentThread().getId() + ",action=" + request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
