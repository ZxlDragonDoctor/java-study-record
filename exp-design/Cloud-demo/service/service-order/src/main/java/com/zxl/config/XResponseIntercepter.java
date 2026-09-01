package com.zxl.config;

import feign.InvocationContext;
import feign.ResponseInterceptor;
import org.springframework.stereotype.Component;

/**
 * 配置openfeign的响应拦截器
 */
@Component
public class XResponseIntercepter implements ResponseInterceptor {
    @Override
    public Object intercept(InvocationContext invocationContext, Chain chain) throws Exception {
        return null;
    }

    @Override
    public ResponseInterceptor andThen(ResponseInterceptor nextInterceptor) {
        return ResponseInterceptor.super.andThen(nextInterceptor);
    }

    @Override
    public Chain apply(Chain chain) {
        return ResponseInterceptor.super.apply(chain);
    }
}
