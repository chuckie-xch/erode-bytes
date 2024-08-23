package com.fewbug.erodebytes.springboot3.sa.token.vo;

import com.fewbug.erodebytes.springboot3.sa.token.facade.dto.OpenApiUserInfoDTO;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/23 01:29
 **/
@Data
public class UserInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1970909738093908090L;

    private String name;

    private String avatar;

    private String userid;

    private String email;

    private String address;

    private String phone;

    public static UserInfoVO from(OpenApiUserInfoDTO userInfoDTO) {
        return Optional.ofNullable(userInfoDTO)
                .map(user -> {
                    UserInfoVO res = new UserInfoVO();
                    res.setUserid(user.getId());
                    res.setName(user.getUsername());
                    res.setAddress(user.getAddress());
                    res.setPhone(user.getPhone());
                    res.setEmail(user.getEmail());
                    return res;
                }).orElse(null);
    }
}
