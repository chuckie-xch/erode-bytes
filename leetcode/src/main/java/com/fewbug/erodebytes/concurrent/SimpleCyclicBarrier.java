package com.fewbug.erodebytes.concurrent;

/**
 * 简化版的CyclicBarrier,支持await()和reset()
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 14:00
 **/
public class SimpleCyclicBarrier {

    private final int parties;

    private int count;

    private final Object lock = new Object();

    public SimpleCyclicBarrier(int parties) {
        this.parties = parties;
        this.count = parties;
    }

    public void await() throws InterruptedException {
        synchronized (lock) {
            count--;
            if (count == 0) {
                lock.notifyAll();
                count = parties;
            } else {
                while (count > 0) {
                    lock.wait();
                }
            }
        }
    }

    public void reset() {
        synchronized (lock) {
            count = parties;
            lock.notifyAll();
        }
    }

}
