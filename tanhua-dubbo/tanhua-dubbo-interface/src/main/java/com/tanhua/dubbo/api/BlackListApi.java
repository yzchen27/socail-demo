package com.tanhua.dubbo.api;

import com.tanhua.model.bo.PageResult;

/**
 * @program: social-demo
 * @description: 黑名单api
 * @author: YzChen
 * @create: 2022-04-13 14:49
 **/
public interface BlackListApi {

    /**
     *  查找黑名单
     * @return
     */
    PageResult findBlackListByUserId(Long userId, int page, int size);

    /**
     *  移除黑名单
     * @param uid
     * @param id
     */
    void deleteByUserId(Long uid, Long id);
}
