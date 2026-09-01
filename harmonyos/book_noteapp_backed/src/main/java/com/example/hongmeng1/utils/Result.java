package com.example.hongmeng1.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage(), null);
    }

    public static <T> Result<T> fail(Integer code) {
        return new Result<>(code, ResponseCode.ERROR.getMessage(), null);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResponseCode.ERROR.getCode(), message, null);
    }

    public static <T> Result<List<T>> success(List<T> data){
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

}
