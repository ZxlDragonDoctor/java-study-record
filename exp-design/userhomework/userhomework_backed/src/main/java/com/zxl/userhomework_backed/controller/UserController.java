package com.zxl.userhomework_backed.controller;

import cn.hutool.core.bean.BeanUtil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxl.userhomework_backed.common.BaseResponse;
import com.zxl.userhomework_backed.common.ResultUtils;
import com.zxl.userhomework_backed.exception.BusinessException;
import com.zxl.userhomework_backed.exception.ErrorCode;
import com.zxl.userhomework_backed.exception.ThrowUtils;
import com.zxl.userhomework_backed.model.dto.UserLoginRequest;
import com.zxl.userhomework_backed.model.dto.UserRegisterRequest;
import com.zxl.userhomework_backed.model.dto.UserUpdateRequest;
import com.zxl.userhomework_backed.model.pojo.Users;
import com.zxl.userhomework_backed.model.vo.LoginUserVo;
import com.zxl.userhomework_backed.service.UsersService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UsersService usersService;

    /**
     * 健康检查
     */
    @GetMapping
    public String health() {
        return "health";
    }

    /**
     * 注冊
     *
     * @param request
     * @return
     */
    @PostMapping("register")
    public BaseResponse<Long> register(@RequestBody UserRegisterRequest request) {
        ThrowUtils.throwIf(request == null, ErrorCode.PARAMS_ERROR);
        String username = request.getUsername();
        String userPassword = request.getPassword();
        String checkPassword = request.getCheckPassword();
        long result = usersService.userRegister(username, userPassword, checkPassword);
        return ResultUtils.success(result);
    }

    /**
     * 登录
     * httpSession保存当前用户信息
     *
     * @param request
     * @return
     */
    @PostMapping("login")
    public BaseResponse<LoginUserVo> login(@RequestBody UserLoginRequest request) {
        ThrowUtils.throwIf(request == null, ErrorCode.PARAMS_ERROR);
        String username = request.getUsername();
        String userPassword = request.getPassword();
        LoginUserVo loginUserVo = usersService.userLogin(username, userPassword);
        return ResultUtils.success(loginUserVo);
    }

    /**
     * 更新用户信息
     */
    @PostMapping("update")
    public BaseResponse<LoginUserVo> updateUsers(@RequestBody @Valid UserUpdateRequest request) {
        ThrowUtils.throwIf(request == null, ErrorCode.PARAMS_ERROR);
        Users users = new Users();
        BeanUtil.copyProperties(request, users);
        LoginUserVo loginUserVo = usersService.updateUsers(users,request.getOldUsername());
        return ResultUtils.success(loginUserVo);
    }
    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("info")
    public BaseResponse<LoginUserVo> getUsersByUsername(String username){
        ThrowUtils.throwIf(username == null, ErrorCode.PARAMS_ERROR);
        QueryWrapper<Users> loginUserVoQueryWrapper = new QueryWrapper<>();
        loginUserVoQueryWrapper.eq("username",username);
        Users users = usersService.getBaseMapper().selectOne(loginUserVoQueryWrapper);
        if(users==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户不存在");
        }
        LoginUserVo loginUserVo = usersService.getLoginUserVo(users);
        // 更新登录时间
        users.setLastLogin(new Date());
        usersService.getBaseMapper().updateById(users);
        return ResultUtils.success(loginUserVo);
    }
}
