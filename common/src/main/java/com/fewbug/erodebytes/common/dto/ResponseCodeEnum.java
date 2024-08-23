package com.fewbug.erodebytes.common.dto;

public enum ResponseCodeEnum {

    SUCCESS("200");

    public final String code;

    private ResponseCodeEnum(String code) {
        this.code = code;
    }
}
