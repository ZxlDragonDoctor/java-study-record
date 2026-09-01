package com.example.hongmeng1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //是mybatis配置类
@ComponentScan("com.example.hongmeng1.dao")//该注解是是扫描dao
public class MybatisConfiguration {

}
