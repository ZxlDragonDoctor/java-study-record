package com.zxl.userhomework_backed.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.userhomework_backed.exception.BusinessException;
import com.zxl.userhomework_backed.exception.ErrorCode;
import com.zxl.userhomework_backed.model.pojo.Users;
import com.zxl.userhomework_backed.model.vo.LoginUserVo;
import com.zxl.userhomework_backed.service.UsersService;
import com.zxl.userhomework_backed.mapper.UsersMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
* @author 朱小龙
* @description 针对表【users】的数据库操作Service实现
* @createDate 2025-04-15 17:43:21
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    @Override
    public long userRegister(String username, String userPassword, String checkPassword) {
        System.out.println(username+","+userPassword);
        // 1. 校验
        if (StrUtil.hasBlank(username, userPassword, checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (username.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码过短");
        }
        if (!userPassword.equals(checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");
        }
        // 2. 检查是否重复
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long count = this.baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
        }
        // 3. 加密
        String encryptPassword = getEncryptPassword(userPassword);
        // 4. 插入数据
        Users user = new Users();
        user.setUsername(username);
        user.setPasswordHash(encryptPassword);
        boolean saveResult = this.save(user); //默认主键回显
        if (!saveResult) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "注册失败，数据库错误");
        }
        return user.getUserId();
    }
    @Override
    public String getEncryptPassword(String userPassword) {
        // 混淆密码
        final String SALT = "zxl";
        return DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
    }
    

    @Override
    public LoginUserVo userLogin(String username, String userPassword) {
        // 1. 校验
        if (StrUtil.hasBlank(username, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (username.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");
        }
        if (userPassword.length() < 8 ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码过短");
        }
        //2.根据用户名查询数据库返回user
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Users users = this.baseMapper.selectOne(queryWrapper);
        //3.判断用户名和密码是否相同
        String encryptPassword = getEncryptPassword(userPassword);
        if(users==null || !users.getPasswordHash().equals(encryptPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户名或者密码有误");
        }
        //4.返归视图对象
        return getLoginUserVo(users);
    }
    @Override
    public LoginUserVo getLoginUserVo(Users user){
        if(user == null){
            return null;
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtil.copyProperties(user,loginUserVo);
        return loginUserVo;
    }

    @Override
    public LoginUserVo updateUsers(Users users, String oldUsername) {
        if (users.getUsername().length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");
        }
        if(users.getPhoneNumber().length()!=11){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "手机号格式有误");
        }
        QueryWrapper<Users> emailQueryWrapper = new QueryWrapper<>();
        emailQueryWrapper.eq("email",users.getEmail());
        emailQueryWrapper.ne("username",oldUsername); //排除当前用户
        if(this.baseMapper.selectCount(emailQueryWrapper)>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"邮箱已被注册");
        }
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        usersQueryWrapper.eq("username",oldUsername);
        int l = this.baseMapper.update(users, usersQueryWrapper);
        if(l<1){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户不存在");
        }
        return getLoginUserVo(users);
    }
}




