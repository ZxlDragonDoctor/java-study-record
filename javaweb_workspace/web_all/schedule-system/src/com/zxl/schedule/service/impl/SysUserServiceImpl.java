package com.zxl.schedule.service.impl;

import com.zxl.schedule.dao.SysUserDao;
import com.zxl.schedule.dao.impl.SysUserDaoImpl;
import com.zxl.schedule.pojo.SysUser;
import com.zxl.schedule.service.SysUserService;
import com.zxl.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByName(String username) {
        return userDao.findByname(username);
    }
}
