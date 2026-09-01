//package com.zxl.schedule.filter;
//
//import com.zxl.schedule.pojo.SysUser;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter("/showSchedule.html")
//public class MyFilter_login implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        HttpSession session = request.getSession();
//        Object sysUser = (SysUser)session.getAttribute("sysUser");
//
//        //过滤无用户的访问
//        if(null==sysUser){
//            response.sendRedirect("/login.html");
//        }else {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//
//    }
//}
