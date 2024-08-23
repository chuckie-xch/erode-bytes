package com.fewbug.erodebytes.common.dto;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 00:45
 **/
public class Response0 {
    private static final long serialVersionUID = 1L;
    private String code;

    private String message;

    public Response0() {
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

    public String toString() {
        return "Response{code='" + this.code + '\'' + ", message='" + this.message + '\'' + '}';
    }

    public static Response0 buildFailure(String errCode, String errMessage) {
        Response0 response = new Response0();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    public boolean isSuccess() {
        return ResponseCodeEnum.SUCCESS.code.equals(this.code);
    }

    protected void setSuccess() {
        this.code = ResponseCodeEnum.SUCCESS.code;
    }

    public static Response0 buildSuccess() {
        Response0 response = new Response0();
        response.setSuccess();
        return response;
    }
}
