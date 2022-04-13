package com.tanhua.dubbo.api;

/**
 * @program: social-demo
 * @description: 问题设置
 * @author: YzChen
 * @create: 2022-04-13 13:57
 **/
public interface QuestionApi {
    /**
     *  设置陌生人问题
     * @param id
     * @param content
     */
    void setStrangeContent(Long id, String content);
}
