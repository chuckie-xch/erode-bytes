package com.fewbug.erodebytes.common.dto;

import java.util.Collection;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 00:42
 **/
public class MultiDataDTO<T> {
    private int totalCount;
    private Collection<T> items;

    public MultiDataDTO() {
    }

    public MultiDataDTO(Collection<T> items) {
        this.items = items;
    }

    public MultiDataDTO(int totalCount, Collection<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Collection<T> getItems() {
        return this.items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }
}
