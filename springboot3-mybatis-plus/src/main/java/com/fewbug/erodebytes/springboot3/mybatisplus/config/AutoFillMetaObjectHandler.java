package com.fewbug.erodebytes.springboot3.mybatisplus.config;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/20 22:50
 **/
@Component
@Slf4j
public class AutoFillMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        this.strictInsertFill(metaObject, "creatorId", String.class, "loginUser_" + RandomUtil.randomString(6));
        this.strictInsertFill(metaObject, "modifierId", String.class, "loginUser_" + RandomUtil.randomString(6));
        this.strictInsertFill(metaObject, "gmtCreate", Date.class, new Date());
        this.strictInsertFill(metaObject, "gmtModified", Date.class, new Date());
        this.strictInsertFill(metaObject, "isDeleted", Boolean.class, Boolean.FALSE);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        this.strictUpdateFill(metaObject, "modifierId", String.class, "loginUser_" + RandomUtil.randomString(6));
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }
}
