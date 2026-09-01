package com.zxl.schedule.test;

import com.zxl.schedule.dao.SysScheduleDao;
import com.zxl.schedule.dao.impl.SysScheduleDaoImpl;
import com.zxl.schedule.pojo.SysSchedule;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSysScheduleDao {
    private  final SysScheduleDao sysSchedule=new SysScheduleDaoImpl();
    @Test
    public void addSchedule(){
        int rows = sysSchedule.addSysSchedule(new SysSchedule(null,2,"学习",1));
        System.out.println(rows);
    }
    @Test
    public  void findAll(){
        List<SysSchedule> sysSchedules = sysSchedule.listQuery();
        sysSchedules.forEach(System.out::println);
    }
}
