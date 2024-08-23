package com.fewbug.erodebytes.common.dto;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 00:11
 **/
public class Response<T> {

    public static final String SUCCESS_CODE = "200";
    private String code;

    private String message;

    private T data;

    public Response() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static final <T> Response<T> success(T data) {
        Response<T> response = new Response();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        return response;
    }

    public static Response buildSuccess() {
        return buildSuccess((Object) null);
    }

    public static <T> Response<T> buildSuccess(T data) {
        Response response = new Response();
        response.setSuccess();
        response.setData(data);
        return response;
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    protected void setSuccess() {
        this.code = ResponseCodeEnum.SUCCESS.code;
    }
}
