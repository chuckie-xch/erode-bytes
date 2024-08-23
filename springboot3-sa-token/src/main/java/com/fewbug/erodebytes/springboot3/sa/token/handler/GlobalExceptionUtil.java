package com.fewbug.erodebytes.springboot3.sa.token.handler;

import cn.dev33.satoken.exception.SaTokenException;
import cn.hutool.http.HttpStatus;
import com.fewbug.erodebytes.common.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;

/**
 * 异常处理工具类
 *
 * @author chunhang.xch
 * @Descriptions
 * @date 2024/8/22 01:54
 **/
@Slf4j
public class GlobalExceptionUtil {

    /**
     * 根据错误类型获取对应的CommonResult
     *
     * @author chunhang.xch
     * @date 2024/8/22 01:54
     **/
    public static SingleResponse<String> getCommonResult(Exception e) {
        SingleResponse<String> commonResult;
        if (e instanceof HttpMessageNotReadableException) {
            log.error(">>> 参数传递格式异常：", e);
            // 如果是参数传递格式不支持异常 415
            if (e.getMessage().contains("JSON parse error")) {
                //JSON格式转换错误特殊提示
                commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_UNSUPPORTED_TYPE), "参数格式错误");
            } else {
                commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_UNSUPPORTED_TYPE), "请使用JSON方式传参");
            }
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            log.error(">>> 参数传递格式异常：", e);
            // 如果是JSON参数格式错误异常 415
            commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_UNSUPPORTED_TYPE), "参数格式错误");
        }
         else if (e instanceof SaTokenException) {

            // 如果是SaToken相关异常，则由AuthExceptionUtil处理
            return AuthExceptionUtil.getCommonResult(e);
        }  else {
            // 未知异常打印详情
            log.error(">>> 服务器未知异常，请求地址：{}，具体信息：", CommonServletUtil.getRequest().getRequestURL(), e);
            // 未知异常返回服务器异常
            commonResult = SingleResponse.buildFailure("500","未知异常");
        }
        return commonResult;
    }


}
