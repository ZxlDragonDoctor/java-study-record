package com.zxl.schedule.service;

import com.zxl.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {


    List<SysSchedule> findSchedules(int uid);


    void addNewSchedule(int uid);

    void updateSchedule(SysSchedule sysSchedule);

    void removeSchedule(String sid);
}
