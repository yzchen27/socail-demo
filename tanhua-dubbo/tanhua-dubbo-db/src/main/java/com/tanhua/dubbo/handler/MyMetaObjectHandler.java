package com.tanhua.dubbo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     *  更新字段
     */
    private final String UPDATE_FIELD = "updated";

    /**
     *  创建字段
     */
    private final String CREATE_FIELD = "created";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 从字段获取注解信息 创建时间
        Object created = getFieldValByName(CREATE_FIELD, metaObject);
        if (Objects.isNull(created)){
            setFieldValByName(CREATE_FIELD, new Date(), metaObject);
        }
        // 更新时间
        setFieldValByName(UPDATE_FIELD, new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间
        setFieldValByName(UPDATE_FIELD, new Date(), metaObject);
    }
}
