package com.tanhua.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设置表
 * </p>
 *
 * @author yzchen
 * @since 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_settings")
public class Settings extends BasePojo  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    /**
     * 推送喜欢通知
     */
    private Boolean likeNotification;

    /**
     * 推送评论通知
     */
    private Boolean pinglunNotification;

    /**
     * 推送公告通知
     */
    private Boolean gonggaoNotification;


}
