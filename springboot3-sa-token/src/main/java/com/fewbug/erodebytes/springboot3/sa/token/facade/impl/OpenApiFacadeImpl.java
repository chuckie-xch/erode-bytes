package com.fewbug.erodebytes.springboot3.sa.token.facade.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fewbug.erodebytes.springboot3.sa.token.facade.OpenApiFacade;
import com.fewbug.erodebytes.springboot3.sa.token.facade.constant.OpenApiConstant;
import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.AccessTokenDTO;
import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.OpenApiResult;
import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.OpenApiUserInfoDTO;
import com.fewbug.erodebytes.springboot3.sa.token.facade.exception.OpenApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 22:34
 **/
@Service
@Slf4j
public class OpenApiFacadeImpl implements OpenApiFacade {

    @Value("${sso.openapi.baseUri}")
    private String baseUri;

    @Value("${sso.app.client.id}")
    private String clientId;

    @Value("${sso.app.client.secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;

    public OpenApiFacadeImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Cacheable(cacheNames = "openapi", key = "#{'topiam:accessToken'}",  sync = true)
    @Override
    public String getAccessToken() {
        final String apiUri = baseUri + OpenApiConstant.GET_ACCESS_TOKEN;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUri);
//                .queryParam("client_id", clientId)
//                .queryParam("client_secret", clientSecret);
        JSONObject json = JSONUtil.createObj().set("client_id", clientId).set("client_secret", clientSecret);
        ResponseEntity<AccessTokenDTO> response = restTemplate.postForEntity(builder.toUriString(),json, AccessTokenDTO.class);

        // 使用 Optional.ofNullable 来处理可能为 null 的值
        return Optional.ofNullable(response.getBody())
                .filter(body -> "0".equals(body.getCode()))
                .map(AccessTokenDTO::getAccessToken)
                .orElseThrow(() -> {
                    log.error("获取accessToken失败, response:{}", response.getBody());
                    return new OpenApiException(response.getBody() == null ? "No response body" : response.getBody().getMsg());
                });
    }


    @Cacheable(cacheNames = "openapi", key = "'topiam:userInfo:' + #username", sync = true)
    @Override
    public OpenApiUserInfoDTO getUserInfoByUsername(String username) {
        String userId = getUserId(username);
        OpenApiUserInfoDTO userInfoDTO = getUserInfoById(userId);
        return userInfoDTO;
    }

    private OpenApiUserInfoDTO getUserInfoById(String userId) {
        String apiUri = baseUri + OpenApiConstant.GET_USERINFO;

        // 使用 UriComponentsBuilder 构建 URI
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUri).pathSegment(userId); // 替换 {id}
        // 创建 HttpHeaders 对象
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-TOPIAM-access-token", getAccessToken());

        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<OpenApiResult<OpenApiUserInfoDTO>> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<OpenApiResult<OpenApiUserInfoDTO>>() {});

        return Optional.ofNullable(response.getBody())
                .filter(body -> "0".equals(body.getCode()))
                .map(OpenApiResult::getResult)
                .orElseThrow(() -> {
                    log.error("调用openapi获取userInfo失败, response:{}", response.getBody());
                    return new OpenApiException(response.getBody() == null ? "No response body" : response.getBody().getMsg());
                });
    }

    private String getUserId(String username) {
        final String apiUri = baseUri + OpenApiConstant.GET_USER_ID;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUri)
                .queryParam("username", username);
        // 创建 HttpHeaders 对象
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-TOPIAM-access-token", getAccessToken());

        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<OpenApiResult<String>> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<OpenApiResult<String>>() {});

        return Optional.ofNullable(response.getBody())
                .filter(body -> "0".equals(body.getCode()))
                .map(OpenApiResult::getResult)
                .orElseThrow(() -> {
                    log.error("调用openapi获取userid失败, response:{}", response.getBody());
                    return new OpenApiException(response.getBody() == null ? "No response body" : response.getBody().getMsg());
                });

    }

    @CacheEvict(cacheNames = "openapi", key = "#{'topiam:accessToken'}")
    public void invalidateAccessToken() {
        // 当 accessToken 失效时调用此方法
        log.info("Clearing the cached accessToken, key:{}", "openapi:topiam:accessToken");
    }


}
