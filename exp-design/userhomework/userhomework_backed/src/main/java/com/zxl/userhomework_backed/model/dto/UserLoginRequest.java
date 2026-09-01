package com.zxl.userhomework_backed.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {
    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
}
