package com.example.mybatistest.mappers;

import com.example.mybatistest.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
   List<User> findAllUsers();
   User findUserById(Integer id);
   int saveUser(User user);
   int updateUser(User user);
   int deleteUser(Integer id);

}
