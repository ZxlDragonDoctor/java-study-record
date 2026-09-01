package com.zxl.schedule.service.impl;

import com.zxl.schedule.dao.SysScheduleDao;
import com.zxl.schedule.dao.impl.SysScheduleDaoImpl;
import com.zxl.schedule.pojo.SysSchedule;
import com.zxl.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao sysScheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findSchedules(int uid) {
        return sysScheduleDao.findSchedules(uid);
    }

    @Override
    public void addNewSchedule(int uid) {
        sysScheduleDao.addNewSchedule(uid);
    }

    @Override
    public void updateSchedule(SysSchedule sysSchedule) {
        sysScheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public void removeSchedule(String sid) {
        sysScheduleDao.removeSchedule(sid);
    }
}
