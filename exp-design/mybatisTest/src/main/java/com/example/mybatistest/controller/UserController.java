package com.example.mybatistest.controller;

import com.example.mybatistest.pojo.User;
import com.example.mybatistest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController("user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/findAllUses")
    public List<User> findAllUsers() {
        List<User> allUsers = userService.findAllUsers(1,2);
        System.out.println("获取数据:"+ allUsers);
        return allUsers;
    }
}
