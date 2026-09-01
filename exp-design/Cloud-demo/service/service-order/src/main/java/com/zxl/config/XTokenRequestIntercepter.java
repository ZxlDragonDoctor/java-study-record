package com.zxl.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 配置openfeign的请求拦截器
 */
@Component
public class XTokenRequestIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}