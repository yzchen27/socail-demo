package com.tanhua.dubbo.mappers;

import com.tanhua.model.domain.Settings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanhua.model.vo.GeneralSettingsVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设置表 Mapper 接口
 * </p>
 *
 * @author yzchen
 * @since 2022-04-13
 */
public interface SettingsMapper extends BaseMapper<Settings> {

    /**
     *  通用设置
     * @param id
     * @return
     */
    GeneralSettingsVO selectGeneralSettingsByUserId(@Param("id") Long id);

}
