package com.tanhua.dubbo.mappers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tanhua.model.domain.BlackList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.vo.BlackListVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 黑名单 Mapper 接口
 * </p>
 *
 * @author yzchen
 * @since 2022-04-13
 */
public interface BlackListMapper extends BaseMapper<BlackList> {

    @Select("select * from tb_user_info where id in (" +
            "  SELECT black_user_id FROM tb_black_list where user_id=#{userId}" +
            ")")
    /**
     * 分页查询黑名单
     */
    IPage<BlackListVO> pageBlackListByUserId(@Param("page") Page<BlackListVO> bl, @Param("userId") Long userId);
}
