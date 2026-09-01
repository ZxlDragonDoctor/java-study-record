package com.example.hongmeng1.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "错误的网关"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时");

    private final Integer code;
    private final String message;
}

