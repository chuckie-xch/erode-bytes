package com.fewbug.erodebytes.taskengine.service;

import com.alibaba.fastjson2.JSONObject;
import com.fewbug.erodebytes.taskengine.dataobject.TaskInstance;
import com.fewbug.erodebytes.taskengine.domain.TaskCommand;
import com.fewbug.erodebytes.taskengine.domain.TaskContext;
import com.fewbug.erodebytes.taskengine.domain.TaskResult;
import com.fewbug.erodebytes.taskengine.enums.StatusType;
import com.fewbug.erodebytes.taskengine.mapper.TaskInstanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 21:25
 **/
public abstract class BaseTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTask.class);

    @Autowired
    private TaskInstanceMapper taskInstanceMapper;


    public TaskResult executeTask(TaskCommand command) {

        TaskInstance taskInstance = createTaskInstance(command);

        TaskContext context = initParam(command);

        if (isSkip(command)) {
            markSkipTaskInstance(taskInstance, context);
            return TaskResult.builder().taskInstance(taskInstance).build();
        }

        try {
            List<TaskInstance> workerTasks = doSplit(command, taskInstance);
            newTasks(workerTasks);

            if (command.isParallel()) {
                handleParallelExecution(workerTasks, context, taskInstance);
            } else {
                handleSequentialExecution(workerTasks, context, taskInstance);
            }

        } catch (Throwable e) {
            LOGGER.error("execute task error, taskContext:{}", JSONObject.toJSONString(context), e);
        } finally {
            markErrorTaskInstance(taskInstance, command);
        }

        return TaskResult.builder().taskInstance(taskInstance).build();


    }

    private void handleSequentialExecution(List<TaskInstance> workerTasks, TaskContext context, TaskInstance taskInstance) {
        boolean success = true;
        for (TaskInstance worker : workerTasks) {
            TaskResult taskResult = doWork(worker, context);
            updateInstance(worker, context, taskResult.getSuccess());
            if (!taskResult.getSuccess()) {
                success = false;
            }
        }
        finishMasterTask(taskInstance, success);
    }

    private void handleParallelExecution(List<TaskInstance> workerTasks, TaskContext context, TaskInstance taskInstance) throws InterruptedException, ExecutionException {
        List<CompletableFuture> futures = new ArrayList<>();
        List<TaskResult> results = new ArrayList<>();
        for (TaskInstance worker : workerTasks) {
            CompletableFuture<TaskResult> future = CompletableFuture.supplyAsync(() -> doWork(worker, context)).whenComplete((result, throwable) -> {
                if (throwable != null) {
                    LOGGER.error("Task execution failed", throwable);
                    updateInstance(worker, context, false);
                } else if (result != null) {
                    results.add(result);
                    updateInstance(worker, context, result.getSuccess());
                }
            });
            futures.add(future);
        }
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        combinedFuture.get();

        boolean success = true;
        for (TaskResult taskResult : results) {
            if (!taskResult.getSuccess()) {
                success = false;
            }
        }
        finishMasterTask(taskInstance, success);
    }

    private void updateInstance(TaskInstance worker, TaskContext context, boolean success) {
        // todo
    }

    private void finishMasterTask(TaskInstance taskInstance, boolean success) {
        // todo
    }

    private void newTasks(List<TaskInstance> workerTasks) {
        // todo
    }

    protected abstract TaskResult doWork(TaskInstance worker, TaskContext context);

    protected abstract List<TaskInstance> doSplit(TaskCommand command, TaskInstance taskInstance);

    private void markSkipTaskInstance(TaskInstance taskInstance, TaskContext context) {
        taskInstance.setStatusType(StatusType.FAILED);
        taskInstanceMapper.updateTaskInstance(taskInstance);
    }

    private void markErrorTaskInstance(TaskInstance taskInstance, TaskCommand command) {
        taskInstance.setStatusType(StatusType.FAILED);
        taskInstanceMapper.updateTaskInstance(taskInstance);
    }

    private TaskInstance createTaskInstance(TaskCommand command) {
        return taskInstanceMapper.newTaskInstance(command);
    }

    protected abstract void doSkipAction(TaskCommand command);

    protected abstract boolean isSkip(TaskCommand command);

    protected abstract TaskContext initParam(TaskCommand command);

}
