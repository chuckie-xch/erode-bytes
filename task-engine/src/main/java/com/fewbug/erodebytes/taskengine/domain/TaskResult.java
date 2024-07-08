package com.fewbug.erodebytes.taskengine.domain;

import com.fewbug.erodebytes.taskengine.dataobject.TaskInstance;
import lombok.Builder;
import lombok.Data;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 17:09
 **/
@Data
@Builder
public class TaskResult {

    private TaskInstance taskInstance;

    private Boolean success;

}
