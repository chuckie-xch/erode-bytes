package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 自旋锁，使用CAS实现，支持可重入
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 10:20
 **/
public class ReentrantSpinLock {

    private final AtomicReference<Thread> owner = new AtomicReference<>();

    private int holdCount = 0;

    public void lock() {
        Thread current = Thread.currentThread();

        if (current == owner.get()) {
            holdCount++;
            return;
        }

        while (!owner.compareAndSet(null, current)) {
            LockSupport.parkNanos(1);
        }

        holdCount = 1;
    }

    public void unLock() {
        Thread current = Thread.currentThread();
        if (current != owner.get()) {
            throw new IllegalMonitorStateException();
        }
        holdCount--;
        if (holdCount == 0) {
            owner.set(null);
        }
    }
}
