package com.tanhua.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: social-demo
 * @description: 黑名单VO
 * @author: YzChen
 * @create: 2022-04-13 17:08
 **/
@Data
public class BlackListVO implements Serializable {
    private static final long serialVersionUID = -7465229301485905891L;
    private String avatar;
    private String nickname;
    private String gender;
    private Integer age;
}
