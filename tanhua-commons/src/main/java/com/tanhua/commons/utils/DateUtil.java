package com.tanhua.commons.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @program: social-demo
 * @description: 日期工具类
 * @author: YzChen
 * @create: 2022-04-09 20:27
 **/
public class DateUtil {

    /**
     *  获取过期时间
     * @return
     */
    public static Date getExpire(){
        LocalDateTime expireTime = LocalDateTime.now().plusDays(30L);
        Instant instant = expireTime.toInstant(ZoneOffset.of("+8"));
        return Date.from(instant);
    }
}
