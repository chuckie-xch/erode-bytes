package com.fewbug.erodebytes.springboot3.sa.token.handler;

import cn.dev33.satoken.exception.DisableServiceException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import cn.hutool.http.HttpStatus;
import com.fewbug.erodebytes.common.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AuthExceptionUtil {

    /**
     * 根据错误类型获取对应的Result（只处理SaToken相关异常）
     *
     * @author chunhang.xch
     * @date 2024/8/22 01:54
     **/
    public static SingleResponse<String> getCommonResult(Exception e) {
        SingleResponse<String> commonResult;
        if (e instanceof NotRoleException) {

            // 如果是角色异常 403
            NotRoleException notRoleException = (NotRoleException) e;
            commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "无此角色：" + notRoleException.getRole() +
                    "，接口地址：" + CommonServletUtil.getRequest().getServletPath());
        } else if (e instanceof NotPermissionException) {

            // 如果是权限异常 403
            NotPermissionException notPermissionException = (NotPermissionException) e;
            commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "无此权限：" + notPermissionException.getPermission());
        } else if (e instanceof DisableServiceException) {

            // 如果是被封禁异常 403
            DisableServiceException disableServiceException = (DisableServiceException) e;
            commonResult = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "账号被封禁：" + disableServiceException.getDisableTime() + "秒后解封");
        } else if (e instanceof SaTokenException) {

            // 如果是SaToken异常 直接返回
            SaTokenException saTokenException = (SaTokenException) e;
            commonResult = SingleResponse.buildFailure("500",saTokenException.getMessage());
        } else {
            // 未知异常才打印
            log.error(">>> 服务器未知异常，请求地址：{}，具体信息：", CommonServletUtil.getRequest().getRequestURL(), e);
            // 未知异常返回服务器异常（此处不可能执行进入，因为本方法处理的一定是SaToken的异常，此处仅为安全性考虑）
            commonResult = SingleResponse.buildFailure("500","未知异常");
        }
        return commonResult;
    }
}
