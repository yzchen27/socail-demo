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

    @RequestMapping(method = PUT)
    public ResponseEntity updateUserInfo(@RequestBody UserInfo userInfo) {
        Long id = UserHolder.getId();
        userInfo.setId(id);
        userService.updateUserInfo(userInfo);
        return ResponseEntity.ok(null);
    }
}
