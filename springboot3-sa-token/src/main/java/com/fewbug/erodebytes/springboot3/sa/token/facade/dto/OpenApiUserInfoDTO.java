package com.fewbug.erodebytes.springboot3.sa.token.facade.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/23 00:15
 **/
@Data
public class OpenApiUserInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4269433125446959727L;

    private String id;
    private String username;
    private String email;
    private String phone;
    private String avatar;
    private String status;
    private String fullName;
    private String nickName;
    private String address;
    private String idCard;
    private String remark;
    private String custom;

}
