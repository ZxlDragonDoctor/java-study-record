package com.example.testdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SnackController {
    @GetMapping("/")
    public String index(){
        return "redirect:index.html";
    }
    @GetMapping("/snack/miantiao")
    public String miantiao(){
        return "mynet/miantiao";
    }
    @GetMapping("/snack/guoyou")
    public String guoyou(){
        return "mynet/guoyou";
    }
    @GetMapping("/snack/gaodian")
    public String gaodian(){

        return "mynet/gaodian";
    }
    // classpath:/templates/mynet/gaodian.html
}
