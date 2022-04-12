package com.tanhua.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: social-demo
 * @description: 用户基本信息VO
 * @author: YzChen
 * @create: 2022-04-12 10:20
 **/
@Data
public class UserInfoVO implements Serializable {
    private final String UUID = "5f3c1852-18c8-45db-b15d-27dddc4bfc47";
    private String gender;
    private String nickname;
    private String birthday;
    private String city;
    private String avatar;
}
