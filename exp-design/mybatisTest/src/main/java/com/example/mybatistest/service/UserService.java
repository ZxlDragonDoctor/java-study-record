package com.example.mybatistest.service;

import com.example.mybatistest.mappers.UserMapper;
import com.example.mybatistest.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
    public List<User> findAllUsers(int pageNUm,int pageSize) {
        PageHelper.startPage(pageNUm, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.findAllUsers());
        long total = pageInfo.getTotal();
        System.out.println("数据总条数："+total);
        int pages = pageInfo.getPages();
        System.out.println("总页数："+pages);
        int pageNum = pageInfo.getPageNum();
        System.out.println("当前页码："+pageNum);
        int pageSize1 = pageInfo.getPageSize();
        System.out.println("每一页页大小："+pageSize1);
        // 后去数据集合
        pageInfo.getList().forEach(s-> System.out.println("数据"+ s));
        return pageInfo.getList();
    }
}
