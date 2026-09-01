package com.zxl.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet({"/username"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        String str = req.getParameter("username");
//        System.out.println(str);
//        String ans = "注册成功";
//        if("zxl".equals(str)){
//            ans = "注册失败，登录名已重复";
//        }
//
//        String s = req.getCharacterEncoding();
//        System.out.println("请求体字符集;"+ s);
//        String s1 = resp.getCharacterEncoding();
//        System.out.println("响求体字符集;"+ s1);
        resp.setContentType("text/html"); //设置响应体类型  //在tomcat中conf/web.xml中找对应的类型

        PrintWriter writer = resp.getWriter();
        writer.write("你好");

//        ServletContext servletContext =  getServletContext();
//        String path =  servletContext.getRealPath("uphold");
//        System.out.println(path);
//
//        String contextpath = servletContext.getContextPath();
//        System.out.println(contextpath);
    }
}
