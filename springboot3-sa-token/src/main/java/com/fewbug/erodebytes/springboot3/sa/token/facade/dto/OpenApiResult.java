package com.fewbug.erodebytes.springboot3.sa.token.facade.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/23 00:42
 **/
@Data
public class OpenApiResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6628229700933906590L;

    private String code;

    private String msg;

    private T result;

    private String requestId;
}
