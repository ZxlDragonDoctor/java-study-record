package com.zxl.userhomework_backed.service;

import com.zxl.userhomework_backed.model.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.userhomework_backed.model.vo.LoginUserVo;

/**
* @author 朱小龙
* @description 针对表【users】的数据库操作Service
* @createDate 2025-04-15 17:43:21
*/
public interface UsersService extends IService<Users> {

    long userRegister(String username, String userPassword, String checkPassword);

    LoginUserVo userLogin(String username, String userPassword);
    /**
     *MD5数据加密
     * @param userPassword
     * @return
     */

    String getEncryptPassword(String userPassword);


    LoginUserVo getLoginUserVo(Users user);


    LoginUserVo updateUsers(Users users, String oldUsername);
}
