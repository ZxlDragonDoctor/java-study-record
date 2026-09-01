package com.zxl.schedule.dao;

import com.zxl.schedule.pojo.SysUser;

public interface SysUserDao {
    int addSysUser(SysUser sysUser);

    SysUser findByname(String username);
}
