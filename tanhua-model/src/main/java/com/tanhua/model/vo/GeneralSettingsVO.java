package com.tanhua.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: social-demo
 * @description: 设置通用类
 * @author: YzChen
 * @create: 2022-04-13 10:29
 **/
@Data
public class GeneralSettingsVO implements Serializable {
    private static final long serialVersionUID = 7100411132791831563L;
    private Long id;
    // 陌生问题
    private String strangerQuestion;
    private String phone;
    // 推送喜欢通知
    private String likeNotification;
    // 推送评论通知
    private String pinglunNotification;
    // 推送公告通知
    private String gonggaoNotification;
}
