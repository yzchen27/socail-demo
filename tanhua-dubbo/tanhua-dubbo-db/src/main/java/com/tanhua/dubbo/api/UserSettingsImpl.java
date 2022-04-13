package com.tanhua.dubbo.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanhua.dubbo.mappers.SettingsMapper;
import com.tanhua.model.domain.Settings;
import com.tanhua.model.vo.GeneralSettingsVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

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

    @Override
    public void saveSetting(Map map) {
        boolean likeNotification = (Boolean) map.get("likeNotification");
        boolean pinglunNotification = (Boolean) map.get("pinglunNotification");
        boolean gonggaoNotification = (Boolean)  map.get("gonggaoNotification");
        Long id = (Long) map.get("id");
        //1、获取当前用户id
        //2、根据用户id，查询用户的通知设置
        Settings settings = settingsMapper.selectOne(new QueryWrapper<Settings>().lambda().eq(Settings::getUserId, id));
        //3、判断
        if(settings == null) {
            //保存
            settings = new Settings();
            settings.setUserId(id);
            settings.setPinglunNotification(pinglunNotification);
            settings.setLikeNotification(likeNotification);
            settings.setGonggaoNotification(gonggaoNotification);
            settingsMapper.insert(settings);
        }else {
            settings.setPinglunNotification(pinglunNotification);
            settings.setLikeNotification(likeNotification);
            settings.setGonggaoNotification(gonggaoNotification);
            settingsMapper.updateById(settings);
        }
    }
}
