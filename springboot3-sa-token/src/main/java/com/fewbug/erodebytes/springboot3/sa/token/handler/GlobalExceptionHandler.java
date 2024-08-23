package com.fewbug.erodebytes.springboot3.sa.token.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpStatus;
import com.fewbug.erodebytes.common.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author chunhang.xch
 * @Descriptions
 * @date 2024/8/22 01:54
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${sso.login.uri}")
    private String loginUri;

    @ResponseBody
    @ExceptionHandler(NotLoginException.class)
    public SingleResponse handleNotLogin(NotLoginException exception) {
        SingleResponse res = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_UNAUTHORIZED), exception.getMessage());
        res.setData(MapUtil.builder("redirectUri", loginUri).map());
        return res;
    }

    /**
     * 不同异常返回不同结果
     *
     * @author chunhang.xch
     * @date 2024/8/22 01:54
     **/
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public SingleResponse<String> handleException(Exception e) {
        return GlobalExceptionUtil.getCommonResult(e);
    }
}
