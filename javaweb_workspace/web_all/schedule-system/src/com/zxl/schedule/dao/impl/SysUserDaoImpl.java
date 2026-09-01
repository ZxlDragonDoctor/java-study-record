package com.zxl.schedule.dao.impl;

import com.zxl.schedule.dao.BaseDao;
import com.zxl.schedule.dao.SysUserDao;
import com.zxl.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByname(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username=?";
        List<SysUser> sysUsers = baseQuery(SysUser.class, sql,username);
        return null!=sysUsers && !sysUsers.isEmpty() ?sysUsers.get(0):null;
    }
}
