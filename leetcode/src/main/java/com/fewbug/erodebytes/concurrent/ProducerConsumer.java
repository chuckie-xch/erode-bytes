package com.fewbug.erodebytes.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 10:27
 **/
public class ProducerConsumer<T> {

    private final Queue<T> queue = new LinkedList<>();

    private final int capacity;

    private final Lock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public void produce(T item) throws InterruptedException{
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.offer(item);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T consume()  throws InterruptedException{
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            T item = queue.poll();
            notFull.signal();
            return item;
        }finally {
            lock.unlock();
        }
    }
}
