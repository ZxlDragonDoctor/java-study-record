package com.example.hongmeng1.Model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
}