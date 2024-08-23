package com.fewbug.erodebytes.springboot3.sa.token.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.fewbug.erodebytes.common.dto.SingleResponse;
import com.fewbug.erodebytes.springboot3.sa.token.facade.OpenApiFacade;
import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.OpenApiUserInfoDTO;
import com.fewbug.erodebytes.springboot3.sa.token.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/21 20:30
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OpenApiFacade openApiFacade;

    @GetMapping("/login")
    public SaResult login(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            StpUtil.login(10001);
            return SaResult.ok();
        }
        return SaResult.error("登录失败");
    }

    @GetMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        return "当前回话是否登录：" + StpUtil.isLogin();
    }

    @GetMapping("/getLoginInfo")
    public SingleResponse<UserInfoVO> getLoginInfo() {

        OpenApiUserInfoDTO userInfo = openApiFacade.getUserInfoByUsername(String.valueOf(StpUtil.getLoginId()));
        return SingleResponse.buildSuccess(UserInfoVO.from(userInfo));
    }
}
