package com.fewbug.erodebytes.taskengine.service.impl;

import com.fewbug.erodebytes.taskengine.dataobject.TaskInstance;
import com.fewbug.erodebytes.taskengine.domain.TaskCommand;
import com.fewbug.erodebytes.taskengine.domain.TaskContext;
import com.fewbug.erodebytes.taskengine.domain.TaskResult;
import com.fewbug.erodebytes.taskengine.service.BaseTask;
import com.fewbug.erodebytes.taskengine.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 17:09
 **/
@Service
public class TaskServiceImpl extends BaseTask implements TaskService {


    @Override
    protected TaskResult doWork(TaskInstance worker, TaskContext context) {
        return null;
    }

    @Override
    protected List<TaskInstance> doSplit(TaskCommand command, TaskInstance taskInstance) {
        return List.of();
    }

    @Override
    protected void doSkipAction(TaskCommand command) {

    }

    @Override
    protected boolean isSkip(TaskCommand command) {
        return false;
    }

    @Override
    protected TaskContext initParam(TaskCommand command) {
        return null;
    }
}
