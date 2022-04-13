package com.tanhua.server.service;

import com.tanhua.dubbo.api.BlackListApi;
import com.tanhua.model.bo.PageResult;
import com.tanhua.server.config.UserHolder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @program: social-demo
 * @description: 黑名单服务层
 * @author: YzChen
 * @create: 2022-04-13 14:45
 **/
@Service
public class BlackListService {
    @DubboReference
    private BlackListApi blackListApi;

    public PageResult findBlackListByUserId(int page, int size) {
        return blackListApi.findBlackListByUserId(UserHolder.getId(), page, size);
    }

    public void deleteUserById(Long uid) {
        blackListApi.deleteByUserId(uid, UserHolder.getId());
    }
}
