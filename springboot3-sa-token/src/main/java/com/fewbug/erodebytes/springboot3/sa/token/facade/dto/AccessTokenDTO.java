package com.fewbug.erodebytes.springboot3.sa.token.facade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 22:41
 **/
@Data
public class AccessTokenDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5854920693028842103L;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expiresIn;

    private String code;

    private String msg;
}
