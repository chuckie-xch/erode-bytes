package com.fewbug.erodebytes.taskengine.dataobject;

import lombok.Data;

/**
 * 任务定义
 *
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 12:00
 **/
@Data
public class TaskDefinition extends BaseEntity {

    private Long id;

    private String name;

    private String description;

    private String code;

    private Integer version;

    private Integer failRetryTimes;

    private Integer failRetryInterval;

    private String projectCode;

    private String tenantCode;

    private String owner;

    private Integer status;


}
