package com.tanhua.server.service;

import com.tanhua.dubbo.api.RecommendUserApi;
import com.tanhua.dubbo.api.UserInfoApi;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.mongo.RecommendUser;
import com.tanhua.model.vo.TodayBest;
import com.tanhua.server.config.UserHolder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-14 10:19
 **/
@Service
public class TanHuaService {

    @DubboReference
    private RecommendUserApi recommendUserApi;

    @DubboReference
    private UserInfoApi userInfoApi;

    public TodayBest todayBest(){
        Long id = UserHolder.getId();
        UserInfo userInfo = userInfoApi.findUserInfoByUserId(id);
        RecommendUser recommendUser = recommendUserApi.queryWithMaxScore(id);
        return TodayBest.init(userInfo, recommendUser);
    }
}
