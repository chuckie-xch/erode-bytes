package com.fewbug.erodebytes.taskengine.dataobject;

import com.fewbug.erodebytes.taskengine.enums.StatusType;
import com.fewbug.erodebytes.taskengine.enums.TaskType;
import lombok.Data;

import java.io.Serializable;

/**
 * 任务实例
 *
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 12:27
 **/
@Data
public class TaskInstance extends BaseEntity implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String taskCode;

    private Integer taskDefinitionVersion;

    private String projectCode;

    private String tenantCode;

    private String owner;

    /**
     * 状态类型
     */
    private StatusType statusType;

    /**
     * 运行状态
     */
    private String executionStatus;

    /**
     * 父任务id
     */
    private Long parentId;

    /**
     * 任务类型
     */
    private TaskType taskType;

    /**
     * 工作业务Id
     */
    private String workerBizId;

    /**
     * 主业务Id
     */
    private String masterBizId;

    /**
     * 执行机器
     */
    private String host;

    /**
     * 重试次数
     */
    private Integer retryTimes;

    /**
     * 耗时
     */
    private String duration;

    /**
     * 任务参数
     */
    private String taskParam;

}
