package com.zxl.schedule.dao;

import com.zxl.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    /*
    *  @param schedule
    *  @return
    * */
    public int addSysSchedule(SysSchedule sysSchedule);
    List<SysSchedule> listQuery();

    List<SysSchedule> findSchedules(int uid);

    void addNewSchedule(int uid);

    void updateSchedule(SysSchedule sysSchedule);

    void removeSchedule(String sid);
}
