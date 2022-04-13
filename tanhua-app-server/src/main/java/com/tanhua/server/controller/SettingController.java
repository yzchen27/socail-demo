package com.tanhua.server.controller;

import com.tanhua.server.config.UserHolder;
import com.tanhua.server.service.SettingService;
import com.tanhua.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: social-demo
 * @description: 设置控制层
 * @author: YzChen
 * @create: 2022-04-13 14:18
 **/
@RestController
@RequestMapping("/users")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PostMapping("/notifications/setting")
    public ResponseEntity settingSwitch(@RequestBody Map map){
        map.put("id", UserHolder.getId());
        settingService.settingSwitch(map);
        return ResponseEntity.ok(null);
    }
}
