package com.fewbug.erodebytes.taskengine.enums;

import lombok.Getter;

/**
 * 执行状态
 *
 * @author chunhang.xch
 */
@Getter
public enum StatusType {

    WAITING("WAITING", "等待执行"),
    RUNNING("RUNNING", "执行中"),
    FAILED("FAILED", "执行失败"),
    SUCCESS("SUCCESS", "执行成功"),
    FINISH("FINISH", "已完成"),
    ;

    private String code;
    private String desc;

    StatusType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
