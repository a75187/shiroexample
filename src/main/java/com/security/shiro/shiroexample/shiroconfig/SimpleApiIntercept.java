package com.security.shiro.shiroexample.shiroconfig;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SimpleApiIntercept", urlPatterns = "/*")
public class SimpleApiIntercept implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ShiroHttpServletRequest servletRequest = (ShiroHttpServletRequest) req;
        if(servletRequest.getRequestURL().toString().contains("security") && SecurityUtils.getSubject().getPrincipal()==null){
            throw new RuntimeException("请先登陆!");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
         System.out.println("SimpleApiIntercept"+":初始化");
    }

}
