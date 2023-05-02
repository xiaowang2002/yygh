package com.atwzs.yygh.common.exception;

import com.atwzs.yygh.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Author WangZhisheng
 * @Date 10:07 2023/4/19
 * @Version 11.0.15
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody      //保证以json格式输出
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
    * @description: 自定义异常
    **/
    @ExceptionHandler(YyghException.class)
    @ResponseBody      //以json格式输出
    public Result error(YyghException e) {
        e.printStackTrace();
        return Result.fail();
    }

}
