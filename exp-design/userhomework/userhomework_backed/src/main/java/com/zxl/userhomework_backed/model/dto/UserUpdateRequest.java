package com.zxl.userhomework_backed.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class UserUpdateRequest {
    /**
     *
     */
    private String oldUsername;
    /**
     *
     */
    private String username;

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
}
