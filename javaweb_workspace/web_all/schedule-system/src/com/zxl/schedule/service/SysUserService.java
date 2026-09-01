  package com.zxl.schedule.service;

import com.zxl.schedule.pojo.SysUser;

public interface SysUserService {
    /*
    * 注册用户的方法
    *
    * */

    int regist(SysUser sysUser);

    SysUser findByName(String username);

}
