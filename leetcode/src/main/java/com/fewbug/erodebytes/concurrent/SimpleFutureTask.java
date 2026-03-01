package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FutureTask简单实现，支持 callable 和 get()
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 11:30
 **/
public class SimpleFutureTask<V> implements Runnable {

    private final Callable<V> callable;

    private volatile V result;

    private volatile Throwable exception;

    private final Lock lock = new ReentrantLock();

    private volatile boolean isDone = false;

    private final Condition done = lock.newCondition();

    public SimpleFutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            exception = e;
        } finally {
            lock.lock();
            try {
                isDone = true;
                done.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }

    public V get() throws InterruptedException, ExecutionException {
        lock.lock();
        try {
            while (!isDone) {
                done.await();
            }
            if (exception != null) {
                throw new ExecutionException(exception);
            }
            return result;
        } finally {
            lock.unlock();
        }
    }
}
