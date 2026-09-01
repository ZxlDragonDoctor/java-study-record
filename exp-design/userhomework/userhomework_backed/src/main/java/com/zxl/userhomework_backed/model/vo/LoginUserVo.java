package com.zxl.userhomework_backed.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUserVo implements Serializable {
    /**
     *
     */
    private String username;

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
    private Integer isActive;

    /**
     *
     */
    private Date lastLogin;
}
