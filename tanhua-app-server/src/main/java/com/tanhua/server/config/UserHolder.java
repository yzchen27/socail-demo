package com.tanhua.server.config;

import com.tanhua.model.bo.UserInfoBO;

/**
 * @program: social-demo
 * @description: 用户token信息
 * @author: YzChen
 * @create: 2022-04-12 15:51
 **/
public class UserHolder {

    /**
     * 存放当前线程的信息
     */
    private static final ThreadLocal<UserInfoBO> userInfoBOThreadLocal = new ThreadLocal<>();

    public static UserInfoBO getUser() {
        return userInfoBOThreadLocal.get();
    }

    public static void set(UserInfoBO userInfoBO) {
        userInfoBOThreadLocal.set(userInfoBO);
    }

    /**
     * 获取id
     *
     * @return
     */
    public static Long getId() {
        return userInfoBOThreadLocal.get().getId();
    }

    /**
     * 获取信息
     *
     * @return
     */
    public static String getMobile() {
        return userInfoBOThreadLocal.get().getMobile();
    }

    /**
     * 移除
     */
    public static void remove() {
        userInfoBOThreadLocal.remove();
    }
}
