package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 17:30
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int partyCount = 5;
        CyclicBarrier barrier = new CyclicBarrier(partyCount, () -> {
            System.out.println("所有线程已经就位，开始行动！");
        });
        for (int i = 0; i < partyCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "准备中...");
                try {
                    Thread.sleep((long)(Math.random() * 2000));
                    System.out.println(Thread.currentThread().getName() + " 到达屏障");
                    barrier.await();
                } catch (Exception e) {
                    // log.error(...)
                }
            }).start();
        }
    }
}
