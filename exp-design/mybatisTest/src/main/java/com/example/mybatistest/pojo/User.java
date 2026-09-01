package com.example.mybatistest.pojo;


import com.alibaba.druid.support.monitor.annotation.MTable;
import lombok.Data;

import java.util.Date;


/**
 * user实体类
 */
@Data
public class User {
    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String passwordHash;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String fullName;

    /**
     * 
     */
    private String phoneNumber;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 
     */
    private Date updatedAt;

    /**
     * 
     */
    private Integer isActive;

    /**
     * 
     */
    private Date lastLogin;
}