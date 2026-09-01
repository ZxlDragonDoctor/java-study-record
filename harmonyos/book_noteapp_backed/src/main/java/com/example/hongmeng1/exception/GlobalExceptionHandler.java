package com.example.hongmeng1.exception;


import com.example.hongmeng1.utils.ResponseCode;
import com.example.hongmeng1.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 运行时异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Result<String> runtimeException(RuntimeException e) {

        return Result.fail(ResponseCode.ERROR.getCode(), e.getMessage());
    }

    /**
     * 兜底异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Result<String> exception(Throwable e) {
        return Result.fail(e.getMessage());
    }

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceExceptionHandler.class)
    public Result<String> serviceExceptionHandler(ServiceExceptionHandler e) {

        return Result.fail(e.getResponseCode().getCode(), e.getMessage());
    }
}
