package com.example.hongmeng1.exception;

import com.example.hongmeng1.utils.ResponseCode;
import lombok.Getter;

@Getter
public class ServiceExceptionHandler extends RuntimeException {

    private final ResponseCode responseCode;

    public ServiceExceptionHandler(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}