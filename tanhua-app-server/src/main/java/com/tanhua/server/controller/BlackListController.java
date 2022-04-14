package com.tanhua.server.controller;

import com.tanhua.model.bo.PageResult;
import com.tanhua.server.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

/**
 * @program: social-demo
 * @description: 黑名单控制层
 * @author: YzChen
 * @create: 2022-04-13 14:44
 **/
@RestController
@RequestMapping("/users/blacklist")
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    @GetMapping("")
    public ResponseEntity getBlackList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "pageSize", defaultValue = "10") @Max(20) int size) {
        PageResult pr = blackListService.findBlackListByUserId(page, size);

        return ResponseEntity.ok(pr);
    }

    @DeleteMapping("{uid}")
    public ResponseEntity deleteUserById(@PathVariable Long uid){
        blackListService.deleteUserById(uid);
        return ResponseEntity.ok(null);
    }
}
