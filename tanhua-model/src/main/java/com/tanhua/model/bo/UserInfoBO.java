package com.tanhua.model.bo;

import lombok.Data;

import java.util.Date;

/**
 * @program: social-demo
 * @description: Jwt解析结果
 * @author: YzChen
 * @create: 2022-04-12 09:40
 **/
@Data
public class UserInfoBO {
    private Long id;
    private String mobile;
    private Date expireTime;

    public UserInfoBO(Long id, String mobile, Date expireTime) {
        this.id = id;
        this.mobile = mobile;
        this.expireTime = expireTime;
    }
}
