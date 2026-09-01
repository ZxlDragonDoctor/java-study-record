package com.example.testdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Component
public class PrintFilterChain {
    @Autowired
    private SecurityFilterChain securityFilterChain;

    @PostConstruct
    public void init() {
        securityFilterChain.getFilters().forEach(
               filter -> {
                   System.out.println(filter.getClass().getSimpleName());
               }
        );
    }
}