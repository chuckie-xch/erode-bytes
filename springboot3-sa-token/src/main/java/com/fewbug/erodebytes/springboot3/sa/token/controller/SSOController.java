package com.fewbug.erodebytes.springboot3.sa.token.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.fewbug.erodebytes.springboot3.sa.token.config.JwtVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 01:54
 **/
@RestController
@RequestMapping("/auth")
public class SSOController {

    private static final Logger log = LoggerFactory.getLogger(SSOController.class);

    @Autowired
    private JwtVerifier jwtVerifier;

    @GetMapping("/sso")
    public RedirectView sso(@RequestParam("id_token") String idToken, @RequestParam("target_url") String targetUrl) {
        log.info("获取到idToken:{}, targetUrl:{}", idToken, targetUrl);
        if (checkToken(idToken)) {
            JWT jwt = JWTUtil.parseToken(idToken);
            StpUtil.login(jwt.getPayload("sub"));
            return new RedirectView(targetUrl);
        }
        throw new RuntimeException("非法id_token:"+idToken);
    }

    private boolean checkToken(String token) {
        return jwtVerifier.verify(token);
    }

    // eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjE5ODkvYXBpL3YxL2F1dGhvcml6ZS9qd3QvcnAydnMwZjBnN3Btbzdua2h1dG1sejdpcXMyb2c5cjAvc3NvIiwiaWF0IjoxNzI0MzA3MDI3LCJzdWIiOiJjaHVuaGFuZyIsImF1ZCI6WyJycDJ2czBmMGc3cG1vN25raHV0bWx6N2lxczJvZzlyMCJdLCJleHAiOjE3MjQzOTE2Mjd9.dx1Gz9ydxk3KQ_JNfPN75-9gXlILLISIfV5vQpA9KzULnZELwaM9vXQfqxBdMckHcA3yTIXWdXSRMul3N92DRzgZFtjQbJYmv0c6eghmiwxnzDUuan-aiOfnhttHFcRLutw6qbCIQUXrF48_-FpirIX24g3VeWxK1j9k4HblKogCCdzwyV1kPiupy5gyfuZlKRJ4HEWJ1pui2jK3o96nQQ4d3XnVwdRCuia3P8AttelI5VRpXtMf2P2__NLmpUoxlzHsL3LwtgNOMT7CwwVAfLoc9fpETi2CfG2mq44KjwhFVXfs95QZm_ZZsPUeuApwi2iLDNix0jEaHYx6_D9QCA
}
