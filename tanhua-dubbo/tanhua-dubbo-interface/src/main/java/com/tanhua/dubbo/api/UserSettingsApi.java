package com.tanhua.dubbo.api;

import com.tanhua.model.vo.GeneralSettingsVO;

import java.util.Map;

/**
 * @program: social-demo
 * @description: 用户设置api
 * @author: YzChen
 * @create: 2022-04-13 10:47
 **/
public interface UserSettingsApi {

    /**
     *  查询用户设置api
     * @param id
     * @return
     */
    GeneralSettingsVO findUserGeneralSettingsByUserId(Long id);

    /**
     *  保存用户设置
     * @param map
     */
    void saveSetting(Map map);
}
