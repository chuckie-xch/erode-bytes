package com.fewbug.erodebytes.springboot3.sa.token.facade.exception;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/23 00:37
 **/
public class OpenApiException extends RuntimeException{

    public OpenApiException() {
    }

    public OpenApiException(String message) {
        super(message);
    }

    public OpenApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenApiException(Throwable cause) {
        super(cause);
    }

    public OpenApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
