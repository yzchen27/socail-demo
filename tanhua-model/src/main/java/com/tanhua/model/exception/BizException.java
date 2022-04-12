package com.tanhua.model.exception;

import com.tanhua.model.vo.ErrorResult;
import lombok.Data;

/**
 * @program: social-demo
 * @description: 业务异常类
 * @author: YzChen
 * @create: 2022-04-12 16:30
 **/
@Data
public class BizException extends RuntimeException{

    private ErrorResult errorResult;

    public BizException(ErrorResult errorResult){
        super(errorResult.getErrMessage());
        this.errorResult = errorResult;
    }
}
