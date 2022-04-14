package com.tanhua.dubbo.api;

import com.tanhua.model.mongo.RecommendUser;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-14 09:56
 **/
public interface RecommendUserApi {
    /**
     *  查询今日佳人
     * @param toUserId
     * @return
     */
    RecommendUser queryWithMaxScore(Long toUserId);
}
