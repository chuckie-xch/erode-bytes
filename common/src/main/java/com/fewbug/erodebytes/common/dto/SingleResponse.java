package com.fewbug.erodebytes.common.dto;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 00:47
 **/
public class SingleResponse<T> extends Response0 {
    private T data;

    public SingleResponse() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse buildSuccess() {
        return buildSuccess((Object) null);
    }

    public static <T> SingleResponse<T> buildSuccess(T data) {
        SingleResponse response = new SingleResponse();
        response.setSuccess();
        response.setData(data);
        return response;
    }

    public static SingleResponse buildFailure(String errCode, String errMessage) {
        SingleResponse response = new SingleResponse();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
}

