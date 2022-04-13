package com.tanhua.server.controller;

import com.tanhua.commons.utils.JwtUtils;
import com.tanhua.model.bo.UserInfoBO;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.vo.UserInfoVO;
import com.tanhua.server.config.UserHolder;
import com.tanhua.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @program: social-demo
 * @description: 用户信息Controller
 * @author: YzChen
 * @create: 2022-04-12 14:51
 **/
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUserInfo(Long userID) {
        UserInfoBO user = UserHolder.getUser();
        UserInfoVO userInfo = userService.findUserInfoById(user, userID);
        return ResponseEntity.ok(userInfo);
    }


    /**
     *  更新用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(method = PUT)
    public ResponseEntity updateUserInfo(@RequestBody UserInfo userInfo) {
        Long id = UserHolder.getId();
        userInfo.setId(id);
        userService.updateUserInfo(userInfo);
        return ResponseEntity.ok(null);
    }

    /**
     *  获取通用设置
     * @return
     */
    @GetMapping("settings")
    public ResponseEntity userSettings(){
        Long id = UserHolder.getId();
        return ResponseEntity.ok(userService.findUserGeneralSettingsByUserId(id));

    }

    /**
     *  设置陌生人问题
     * @return
     */
    @PostMapping("/questions")
    public ResponseEntity setStrangeContent(@RequestBody Map map){
        String content = (String) map.get("content");
        userService.setStrangeContent(content);
        return ResponseEntity.ok(null);
    }
}
