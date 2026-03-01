package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 使用 CountDownLatch 实现主线程等待N个子线程完成
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 17:22
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println("线程:" + Thread.currentThread().getName() + " 开始工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程:" + Thread.currentThread().getName() + " 工作完成");
                latch.countDown();
            }).start();
        }

        latch.await();

        System.out.println("所有子线程已完成, 主线程继续");
    }
}
