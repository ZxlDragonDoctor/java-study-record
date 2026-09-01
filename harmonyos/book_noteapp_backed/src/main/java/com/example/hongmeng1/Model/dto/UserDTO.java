package com.example.hongmeng1.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private String username;
    private String password;
    private String nickname;
    private String avatar;

}
