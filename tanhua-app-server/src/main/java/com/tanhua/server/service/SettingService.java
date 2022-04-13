package com.tanhua.server.service;

import com.tanhua.dubbo.api.UserSettingsApi;
import com.tanhua.model.domain.Settings;
import com.tanhua.server.config.UserHolder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: social-demo
 * @description: 设置服务层
 * @author: YzChen
 * @create: 2022-04-13 14:19
 **/
@Service
public class SettingService {

    @DubboReference
    private UserSettingsApi userSettingsApi;

    public void settingSwitch(Map map) {
        userSettingsApi.saveSetting(map);
    }
}
