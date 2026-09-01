package com.zxl.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向三大域存放数据
        req.setAttribute("request","request");

        HttpSession session = req.getSession();
        session.setAttribute("request","request");

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("request","request");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servletSession");
        requestDispatcher.forward(req,resp);
    }
}
