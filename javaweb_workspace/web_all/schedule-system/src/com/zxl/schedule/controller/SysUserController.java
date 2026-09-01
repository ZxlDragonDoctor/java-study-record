package com.zxl.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxl.schedule.common.Result;
import com.zxl.schedule.common.ResultCodeEnum;
import com.zxl.schedule.pojo.SysUser;
import com.zxl.schedule.service.SysUserService;
import com.zxl.schedule.service.impl.SysUserServiceImpl;
import com.zxl.schedule.util.MD5Util;
import com.zxl.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*") //不同的请求
public class SysUserController extends BaseController {
    private final SysUserService userService = new SysUserServiceImpl();
    protected void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SysUser name = userService.findByName(username);
        Result result = Result.ok(null);
        if(null != name){
            result= Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //将对象状态转换为JSON串
//        ObjectMapper objectMapper = new ObjectMapper();
//        String info = objectMapper.writeValueAsString(result);
//        System.out.println(info);
//        resp.setContentType("application/json;charSet=UTF-8"); //告诉游览器这是一个JSON串
//        resp.getWriter().write(info);

        WebUtil.writeJson(resp,result); //封装后

    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");
//        SysUser sysUser = new SysUser(null, username, userPwd);
//        int rows = userService.regist(sysUser);
//        if(rows>0){
//            resp.sendRedirect("/registSuccess.html");
//        }else {
//            resp.sendRedirect("/registFail.html");
//        }
        SysUser registUser = WebUtil.readJson(req, SysUser.class);
        Result result = Result.ok(null);
        int row = userService.regist(registUser);
        if(row>0){
            result.build(null,ResultCodeEnum.SUCCESS);
        }else {
            result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");
//        SysUser loginUser =  userService.findByName("username");
//        if(null==loginUser){
//            resp.sendRedirect("/loginUsernameError.html");
//        }else if(!(MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd()))){
//            resp.sendRedirect("/loginUsernameError.html");
//        }else{
//            //登录成功
//            HttpSession session = req.getSession();
//            session.setAttribute("sysUser",loginUser); //将登录用户信息放入session
//
//            resp.sendRedirect("/showSchedule.html");
//        }
        SysUser loginUser = WebUtil.readJson(req, SysUser.class);
        SysUser dataUser = userService.findByName(loginUser.getUsername());
        Result result = null;
        if(dataUser==null){
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }else if(!MD5Util.encrypt(loginUser.getUserPwd()).equals(dataUser.getUserPwd())) {
            result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else {
            Map m = new HashMap();
            dataUser.setUserPwd("");
            m.put("loginUser",dataUser);
            result = Result.build(m,ResultCodeEnum.SUCCESS);
        }
        WebUtil.writeJson(resp,result);
    }
}
