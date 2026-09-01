package com.zxl.schedule.dao.impl;

import com.zxl.schedule.dao.BaseDao;
import com.zxl.schedule.dao.SysScheduleDao;
import com.zxl.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSysSchedule(SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql,sysSchedule.getUid(),sysSchedule.getTitle(),sysSchedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> listQuery() {
        String sql = "select * from sys_schedule";
        List<SysSchedule> sysSchedules =baseQuery(SysSchedule.class,sql);
        return sysSchedules;
    }

    @Override
    public List<SysSchedule> findSchedules(int uid) {
        String sql = "select * from sys_schedule where uid = ?";
        List<SysSchedule> sysScheduls = baseQuery(SysSchedule.class, sql, uid);
        return sysScheduls;
    }

    @Override
    public void addNewSchedule(int uid) {
        String sql = "insert into sys_schedule values(DEFAULT,?,'请输入新的日程',0)";
        baseUpdate(sql, uid);
    }

    @Override
    public void updateSchedule(SysSchedule sysSchedule) {
        String sql = "update sys_schedule set title=?,completed=? where sid=?";
        baseUpdate(sql,sysSchedule.getTitle(),sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public void removeSchedule(String sid) {
        String sql = "delete from sys_schedule where sid=?";
        baseUpdate(sql,sid);
    }
}
