package com.example.hongmeng1.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.example.hongmeng1.dao.IUserDAO;
import com.example.hongmeng1.Model.dto.UserDTO;
import com.example.hongmeng1.Model.pojo.User;
import com.example.hongmeng1.Model.vo.UserVO;
import com.example.hongmeng1.exception.ServiceExceptionHandler;
import com.example.hongmeng1.service.UserService;
import com.example.hongmeng1.utils.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final IUserDAO userDAO;

    @Autowired
    UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public UserDTO getLogin(UserVO userVO) {
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        if (Objects.isNull(username)) {
            throw new ServiceExceptionHandler(ResponseCode.ERROR, "用户名不能为空");
        }
        User user = userDAO.getUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new ServiceExceptionHandler(ResponseCode.ERROR, "用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new ServiceExceptionHandler(ResponseCode.ERROR, "密码错误");
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userDAO.getUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser(UserDTO userDTO) {
        try {
            if(StringUtils.isAllEmpty(userDTO.getUsername(),userDTO.getPassword())){
                throw new ServiceExceptionHandler(ResponseCode.ERROR,"用户名和密码不能为空");
            }
            if(!userDTO.getPassword().equals(userDTO.getPassword())){
                throw new ServiceExceptionHandler(ResponseCode.ERROR,"用户名和密码不一致");
            }
            User user = userDAO.selectUserByUsername(userDTO.getUsername());
            if (user != null) {
                throw new ServiceExceptionHandler(ResponseCode.ERROR, "用户名已存在");
            }
            userDAO.addUser(userDTO);
        } catch (Exception e) {
            //打印错误日志
            throw e; // 确保事务回滚
        }
    }


    /**
     * 删除用户
     *
     * @param username
     */
    @Transactional
    @Override
    public void deleteUserByUsername(String username) {
        if (Objects.isNull(username)) {
            throw new ServiceExceptionHandler(ResponseCode.ERROR, "用户名不能为空");
        }
        userDAO.deleteUserByUsername(username);
    }



}
