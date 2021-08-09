package com.yu.ysblog.exeception;

import com.yu.ysblog.util.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author yu
 * @DateTime 2021/8/8 10:10
 */
@ControllerAdvice
@ResponseBody
public class ExeHandler {
    @ExceptionHandler(Exception.class)
    public CommonResponse exeHandler(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return CommonResponse.failResp(e.getMessage(), e.toString());
    }
}
