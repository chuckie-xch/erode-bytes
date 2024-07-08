package com.fewbug.erodebytes.taskengine.service;

import com.fewbug.erodebytes.taskengine.domain.TaskCommand;
import com.fewbug.erodebytes.taskengine.domain.TaskResult;

/**
 * @author chunhang.xch
 */
public interface TaskService {

    /**
     * 执行任务
     *
     * @param command
     * @return
     */
    TaskResult executeTask(TaskCommand command);
}
