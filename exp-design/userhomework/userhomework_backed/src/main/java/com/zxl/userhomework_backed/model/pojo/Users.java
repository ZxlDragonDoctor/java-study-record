package com.zxl.userhomework_backed.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
    @Email(message = "无效的邮箱")
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