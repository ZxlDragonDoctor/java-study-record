package com.zxl.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {
    /*
    * 构造器 项目启动 1
    * 初始化 init 构造完毕 1
    * 过滤 doFilter 每次请求 n
    * 销毁 destory 服务关闭 1
    *
    *
    * 与servlet中loadstart...不同
    * */
    public LifeCycleFilter(){
        System.out.println("无参构造器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        System.out.println(filterConfig.getInitParameter("dateTimePatter"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
