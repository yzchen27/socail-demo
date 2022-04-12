package com.tanhua.server.config.handler;

import cn.hutool.http.HttpStatus;
import com.tanhua.model.exception.BizException;
import com.tanhua.model.vo.ErrorResult;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: social-demo
 * @description: 全局异常捕获
 * @author: YzChen
 * @create: 2022-04-12 16:33
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  业务异常处理
     * @param biz
     * @return
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity handleBizException(BizException biz){
        biz.printStackTrace();
        ErrorResult errorResult = biz.getErrorResult();
        Integer errCode = Integer.parseInt(errorResult.getErrCode());
        return ResponseEntity.status(errCode).body(errorResult);
    }

    /**
     *  jwt异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({ExpiredJwtException.class, SignatureException.class})
    public ResponseEntity handleTokenException(Exception e){
        ErrorResult errorResult = ErrorResult.notAuth();
        Integer errCode = Integer.parseInt(errorResult.getErrCode());
        return ResponseEntity.status(errCode).body(errorResult);
    }

    /**
     *  未知异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.HTTP_INTERNAL_ERROR).body(ErrorResult.error());
    }


}
