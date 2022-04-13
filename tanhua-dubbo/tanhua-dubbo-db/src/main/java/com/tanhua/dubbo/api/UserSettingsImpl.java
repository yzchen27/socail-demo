package com.tanhua.dubbo.api;

import com.tanhua.dubbo.mappers.SettingsMapper;
import com.tanhua.model.vo.GeneralSettingsVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: social-demo
 * @description: 用户设置服务层
 * @author: YzChen
 * @create: 2022-04-13 10:50
 **/
@DubboService
public class UserSettingsImpl implements UserSettingsApi{

    @Autowired
    private SettingsMapper settingsMapper;

    @Override
    public GeneralSettingsVO findUserGeneralSettingsByUserId(Long id) {
        return settingsMapper.selectGeneralSettingsByUserId(id);
    }
}
