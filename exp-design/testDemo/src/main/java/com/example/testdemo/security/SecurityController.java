package com.example.testdemo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("security")
public class SecurityController {
    @GetMapping("/test")
    public String test(){
        // 获取当前用户信息
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        Object principal = authentication.getPrincipal();
        System.out.println(principal);
        Object credentials = authentication.getCredentials();
        System.out.println(credentials);
        Object details = authentication.getDetails();
        System.out.println(details);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(System.out::println);
        return "health";
    }
}
