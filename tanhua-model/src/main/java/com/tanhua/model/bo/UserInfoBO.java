package com.tanhua.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: social-demo
 * @description: Jwt解析结果
 * @author: YzChen
 * @create: 2022-04-12 09:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBO implements Serializable {
    private final String UUID = "6fe6e646-de8a-4449-b93c-8f472d1c437b";
    private Long id;
    private String mobile;
    private Date expireTime;
}
