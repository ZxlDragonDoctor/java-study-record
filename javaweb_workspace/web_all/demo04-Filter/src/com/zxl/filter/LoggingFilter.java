package com.zxl.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//日志过滤器
@WebFilter(value = "/servlet1",servletNames = "servlet1")
public class LoggingFilter implements Filter {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数格式化
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

//        System.out.println("loggingFilter before doFilter invoked");
        String requestURI = request.getRequestURI();
        String dataTime = dateFormat.format(new Date());
        String beforeLogin = requestURI+"在"+dataTime+"被访问了";
        System.out.println(beforeLogin);

        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long end = System.currentTimeMillis();

//        System.out.println("loggingFilter after doFilter invoked");
        String afterLogging =requestURI+"资源在"+dataTime+"的请求耗时："+(end-start)+"毫秒";
        System.out.println(afterLogging);


    }
}
