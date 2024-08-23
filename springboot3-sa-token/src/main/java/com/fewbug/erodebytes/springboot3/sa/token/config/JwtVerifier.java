package com.fewbug.erodebytes.springboot3.sa.token.config;

import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 15:05
 **/
@Component
@Slf4j
public class JwtVerifier {

    @Autowired
    private CertificateConfig config;


    public Boolean verify(String token) {
        try {
            JWTSigner jwtSigner = JWTSignerUtil.rs256(config.getPublicKey());
            boolean result = JWTUtil.verify(token, jwtSigner);
            return result;
        } catch (Throwable throwable) {
            log.error("验证jwt-token异常,{}", token, throwable);
            return false;
        }
    }

}
