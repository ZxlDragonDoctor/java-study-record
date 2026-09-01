package com.example.hongmeng1.dao;

import com.example.hongmeng1.Model.dto.UserDTO;
import com.example.hongmeng1.Model.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface IUserDAO {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<User> getUsers();

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

    User selectUserByUsername(String username);
}
