package com.fewbug.erodebytes.concurrent;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 10:35
 **/
public class DeadLockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1 : get lock1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                synchronized (lock2) {
                    System.out.println("T1 : get lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2 : get lock2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                synchronized (lock1) {
                    System.out.println("T2 : get lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
