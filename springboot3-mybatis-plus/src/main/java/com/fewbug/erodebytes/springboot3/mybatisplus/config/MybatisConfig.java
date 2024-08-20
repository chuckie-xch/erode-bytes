package com.fewbug.erodebytes.springboot3.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/20 22:18
 **/
@MapperScan("com.fewbug.erodebytes.springboot3.mybatisplus.dal.mapper")
@Configuration
public class MybatisConfig {

    /**
     * 自定义配置
     *
     * @return
     */
    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
        return plusProperties -> {
            GlobalConfig.DbConfig dbConfig = plusProperties.getGlobalConfig().getDbConfig();
            dbConfig.setIdType(IdType.AUTO);
        };
    }

    /**
     * 插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        /**
         * 分页插件
         */
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        /**
         * 非法SQL拦截器
         */
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        return interceptor;
    }
}
