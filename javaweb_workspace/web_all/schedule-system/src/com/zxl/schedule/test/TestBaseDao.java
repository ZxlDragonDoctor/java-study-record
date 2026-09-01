package com.zxl.schedule.test;

import com.zxl.schedule.dao.BaseDao;

import com.zxl.schedule.pojo.SysUser;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBaseDao {
    private final BaseDao baseDao =new BaseDao();;

    @Test
    public void testBaoQueryObject(){

        String sql="select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class,sql);
        System.out.println(count);
    }
    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUser = baseDao.baseQuery(SysUser.class, sql);
        sysUser.forEach(System.out::println);
    }
    @Test
    public void testBaseUpdata(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql,1,"学习java",0);
        System.out.println(rows);

    }


}
