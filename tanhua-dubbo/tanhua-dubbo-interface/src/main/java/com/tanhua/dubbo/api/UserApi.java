package com.tanhua.dubbo.api;

import com.tanhua.model.domain.User;

/**
 * @author yzchen
 */
public interface UserApi {

    /**
     * 根据手机查找用户
     * @param mobile
     * @return
     */
    User findByMobile(String mobile);

    /**
     *  保存用户
     * @param user
     * @return
     */
    Long save(User user);
}
