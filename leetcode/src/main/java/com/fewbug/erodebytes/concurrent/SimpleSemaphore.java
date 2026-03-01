package com.fewbug.erodebytes.concurrent;

/**
 * 简化版的信号量，支持acquire() 和 release()
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 14:10
 **/
public class SimpleSemaphore {

    private volatile int permits;

    private final Object lock = new Object();

    public SimpleSemaphore(int permits) {
        this.permits = permits;
    }

    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (permits <= 0) {
                lock.wait();
            }
            permits--;
        }
    }

    public void release() {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }
}
