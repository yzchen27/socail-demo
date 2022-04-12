package com.tanhua.dubbo.api;

import com.tanhua.model.bo.UserInfoBO;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.vo.UserInfoVO;

/**
 * @program: social-demo
 * @description: 用户信息
 * @author: YzChen
 * @create: 2022-04-12 10:25
 **/
public interface UserInfoApi {

    /**
     *  用户首次登录信息
     * @param userInfoVO
     * @param userInfoBO
     */
    void save(UserInfoVO userInfoVO, UserInfoBO userInfoBO);

    /**
     *  根据id查找用户信息
     * @param userID
     * @return
     */
    UserInfoVO findUserInfoById(Long userID);
}
