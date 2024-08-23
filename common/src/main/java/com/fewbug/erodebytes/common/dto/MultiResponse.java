package com.fewbug.erodebytes.common.dto;

import java.util.Collection;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 00:43
 **/
public class MultiResponse<T> extends Response0 {
    private MultiDataDTO<T> data;

    public MultiResponse() {
    }

    public MultiDataDTO<T> getData() {
        return this.data;
    }

    public void setData(MultiDataDTO<T> data) {
        this.data = data;
    }

    public static MultiResponse buildSuccess() {
        return buildSuccess((Collection)null);
    }

    public static <T> MultiResponse<T> buildSuccess(Collection<T> items) {
        int totalCount = items == null ? 0 : items.size();
        return buildSuccess(items, totalCount);
    }

    public static <T> MultiResponse<T> buildSuccess(Collection<T> items, int totalCount) {
        MultiResponse response = new MultiResponse();
        response.setSuccess();
        response.setData(new MultiDataDTO(totalCount, items));
        return response;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
}

