package com.tanhua.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.tanhua.model.domain.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author yzchen
 * @since 2022-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo extends BasePojo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户标签：多个用逗号分隔
     */
    private String tags;

    /**
     * 性别，1-男，2-女，3-未知
     */
    private String gender;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 学历
     */
    private String education;

    /**
     * 居住城市
     */
    private String city;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 封面图片
     */
    private String coverPic;

    /**
     * 行业
     */
    private String profession;

    /**
     * 收入
     */
    private String income;

    /**
     * 0：未婚，1：已婚
     */
    private Integer marriage;


}
