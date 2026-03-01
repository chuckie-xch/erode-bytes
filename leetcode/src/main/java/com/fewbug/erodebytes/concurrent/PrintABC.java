package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 16:54
 **/
public class PrintABC {

    private final Lock lock = new ReentrantLock();

    private final Condition condA = lock.newCondition();
    private final Condition condB = lock.newCondition();
    private final Condition condC = lock.newCondition();

    private volatile char current = 'A';

    public void printA() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (current != 'A') {
                    condA.await();
                }
                System.out.print("A");
                current = 'B';
                condB.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (current != 'B') {
                    condB.await();
                }
                System.out.print("B");
                current = 'C';
                condC.signal();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (current != 'C') {
                    condC.await();
                }
                System.out.print("C");
                current = 'A';
                condA.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC pc = new PrintABC();
        new Thread(pc::printA).start();
        new Thread(pc::printB).start();
        new Thread(pc::printC).start();
    }
}
