package com.zxl.schedule.controller;

import com.zxl.schedule.common.Result;
import com.zxl.schedule.pojo.SysSchedule;
import com.zxl.schedule.service.SysScheduleService;
import com.zxl.schedule.service.impl.SysScheduleServiceImpl;
import com.zxl.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private final SysScheduleService sysScheduleService = new SysScheduleServiceImpl();
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid= Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> sysScheduleList =  sysScheduleService.findSchedules(uid);
        Map m = new HashMap();
        m.put("itemList",sysScheduleList);
        Result result = Result.ok(m);
        WebUtil.writeJson(resp,result);
    }
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid= Integer.parseInt(req.getParameter("uid"));
        sysScheduleService.addNewSchedule(uid);
        WebUtil.writeJson(resp,Result.ok(null));
    }


    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        sysScheduleService.updateSchedule(sysSchedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }


    protected void removeItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        sysScheduleService.removeSchedule(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
