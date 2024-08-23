package com.fewbug.erodebytes.springboot3.sa.token.facade;

import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.OpenApiUserInfoDTO;

/**
 * sso openapi
 */
public interface OpenApiFacade {

    /**
     * 获取AccessToken
     * @return
     */
     String getAccessToken();

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
   OpenApiUserInfoDTO getUserInfoByUsername(String username);


}
