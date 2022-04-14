package com.tanhua.server.controller;

import com.tanhua.server.service.TanHuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-14 10:11
 **/
@RestController
@RequestMapping("/tanhua")
public class TanHuaController {

    @Autowired
    private TanHuaService tanHuaService;

    @GetMapping("todayBest")
    public ResponseEntity todayBest(){
        return ResponseEntity.ok(tanHuaService.todayBest());
    }

}
