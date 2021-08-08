package com.yu.ysblog.exeception;

import com.yu.ysblog.util.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author yu
 * @DateTime 2021/8/8 10:10
 */
@ControllerAdvice
public class ExeHandler {
    @ExceptionHandler(Exception.class)
    public CommonResponse exeHandler(Exception e) {
        e.printStackTrace();
        return CommonResponse.failResp(e.getMessage(), e.toString());
    }
}
