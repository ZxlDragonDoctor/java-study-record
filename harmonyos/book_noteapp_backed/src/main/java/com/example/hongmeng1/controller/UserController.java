package com.example.hongmeng1.controller;

import com.example.hongmeng1.Model.dto.UserDTO;
import com.example.hongmeng1.Model.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.hongmeng1.service.UserService;
import com.example.hongmeng1.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

//    @Operation(summary = "用户登录")
//    @Parameters({
//            @Parameter(name = "userVO", description = "用户信息", required = true,
//                    hidden = true,
//                    schema = @Schema(implementation = UserVO.class, type = "object")
//            ),
//            @Parameter(name = "username", description = "用户名", required = true),
//            @Parameter(name = "password", description = "密码", required = true)
//    })
//    @PostMapping("/login")
    @PostMapping("login")
    public Result<UserDTO> login(@RequestBody UserVO userVO) {
        System.out.println(userVO);
        UserDTO userDTO = userService.getLogin(userVO);

        return Result.success(userDTO);
    }

    @Operation(summary = "获取所有用户信息")
    @GetMapping("/getUsers")
    public Result<List<UserDTO>> getUsers() {
        return Result.success(userService.getUsers());
    }


    @PostMapping("/addUser")
    public Result<Void> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return Result.success();
    }

    @Operation(summary = "删除用户")
    @Parameter(name = "username", description = "用户名", required = true)
    @DeleteMapping("/deleteUser")
    public Result<Void> deleteUserByUsername(String username) {
        userService.deleteUserByUsername(username);
        return Result.success();
    }

}

