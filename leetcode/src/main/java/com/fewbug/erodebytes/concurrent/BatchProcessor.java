package com.fewbug.erodebytes.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * 批量任务处理器，要求： <br>
 * 接收一批 Callable<T> 任务，并行执行。 <br>
 * 支持 超时控制：如果在指定时间内未完成所有任务，则中断所有正在运行的任务。 <br>
 * 支持 部分成功：返回已完成的任务结果，未完成的任务标记为“超时”。 <br>
 * 必须正确处理 中断信号，确保资源可回收。 <br>
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/16 09:18
 **/
public class BatchProcessor<T, R> {

    private final ExecutorService executor;

    private final long timeout;

    private final ExecutionMode mode;

    private final AtomicBoolean isInterrupted = new AtomicBoolean(false);

    private final AtomicInteger completeTasks = new AtomicInteger(0);

    private final Function<List<BatchResult<R>>, R> aggregator;

    private final FailureStrategy failureStrategy;

    public enum ExecutionMode {
        PARALLEL, SEQUENTIAL
    }

    public enum FailureStrategy {
        FAIL_FAST, FAIL_SAFE
    }

    public BatchProcessor(ExecutorService executor, long timeout, ExecutionMode mode, FailureStrategy failureStrategy,
        Function<List<BatchResult<R>>, R> aggregator) {
        this.executor = executor;
        this.timeout = timeout;
        this.mode = mode;
        this.aggregator = aggregator;
        this.failureStrategy = failureStrategy;
    }

    public BatchProcessor(ExecutorService executor, long timeout) {
        this(executor, timeout, ExecutionMode.PARALLEL, FailureStrategy.FAIL_FAST, null);
    }

    /**
     * 结果
     * 
     * @param <R>
     */
    public static class BatchResult<R> {

        private final String taskId;

        private final R result;

        private final long duration;

        private final Throwable error;

        public BatchResult(String taskId, R result, long duration, Throwable error) {
            this.taskId = taskId;
            this.result = result;
            this.duration = duration;
            this.error = error;
        }

        public boolean isSuccess() {
            return error == null;
        }
    }

    public static class BatchProcessingException extends Exception {

        private final List<BatchResult<?>> results;

        public BatchProcessingException(String message, List<BatchResult<?>> results) {
            super(message);
            this.results = results;
        }

        public BatchProcessingException(String message, Throwable cause, List<BatchResult<?>> results) {
            super(message, cause);
            this.results = results;
        }

        public List<BatchResult<?>> getResults() {
            return results;
        }
    }

}
