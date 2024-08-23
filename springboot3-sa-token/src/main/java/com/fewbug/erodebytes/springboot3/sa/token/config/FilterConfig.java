package com.fewbug.erodebytes.springboot3.sa.token.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.fewbug.erodebytes.common.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/21 22:05
 **/
@Configuration
@Slf4j
public class FilterConfig {

    //    @Bean
    public SaServletFilter saTokenWebFilter() {
        return new SaServletFilter().addInclude("/**").addExclude("/favicon.ico")
                // 认证函数: 每次请求执行
                .setAuth(obj -> {
                    log.info("---------- 进入Sa-Token全局认证 -----------");
                    // 登录认证 -- 拦截所有路由，并排除/user/login 用于开放登录
                    SaRouter.match("/**", "/user/login", () -> StpUtil.checkLogin());
                })
                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> {
                    log.info("---------- 进入Sa-Token异常处理 -----------");
                    return JSONUtil.toJsonStr(SingleResponse.buildFailure("401", e.getMessage()));
                })
                // 前置函数：在每次认证函数之前执行（BeforeAuth 不受 includeList 与 excludeList 的限制，所有请求都会进入）
                .setBeforeAuth(r -> {
                    // ---------- 设置一些安全响应头 ----------
                    SaHolder.getResponse()
                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                            .setHeader("X-Frame-Options", "SAMEORIGIN")
                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                            .setHeader("X-XSS-Protection", "1; mode=block")
                            // 禁用浏览器内容嗅探
                            .setHeader("X-Content-Type-Options", "nosniff");
                });
    }
}
