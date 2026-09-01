package com.example.hongmeng1.service;

import com.example.hongmeng1.Model.dto.UserDTO;
import com.example.hongmeng1.Model.vo.UserVO;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @param userVO
     * @return
     */
    UserDTO getLogin(UserVO userVO);

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<UserDTO> getUsers();

    /**
     * 添加用户
     *
     * @param userDTO
     * @return
     */
    void addUser(UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param username
     */
    void deleteUserByUsername(String username);

}