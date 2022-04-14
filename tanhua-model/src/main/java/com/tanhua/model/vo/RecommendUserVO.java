package com.tanhua.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-14 14:49
 **/
@Data
@Accessors(chain = true)
public class RecommendUserVO {
    private Long id;
    private String avatar;
    private String nickname;
    private String gender;
    private Integer age;
    private String[] tag;
    private Integer fateValue;
}
