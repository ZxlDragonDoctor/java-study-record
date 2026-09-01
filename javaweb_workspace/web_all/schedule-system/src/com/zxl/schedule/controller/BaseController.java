package com.zxl.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length-1];
        //****反射获取方法
        Class<? extends BaseController> aClass = this.getClass();
        try {
            Method method = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp); //调用当前对象方法

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
