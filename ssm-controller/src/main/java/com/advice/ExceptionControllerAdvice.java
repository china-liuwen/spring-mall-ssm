package com.advice;

import com.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice {
    /**
     * 这两个注解：
     * 运行时异常
     * 响应到主体里
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVO handleRuntime(RuntimeException re){
        re.printStackTrace();
        ResponseVO vo = ResponseVO.newBuilder().code("500").message("失败").build();
        return vo;
    }
}
