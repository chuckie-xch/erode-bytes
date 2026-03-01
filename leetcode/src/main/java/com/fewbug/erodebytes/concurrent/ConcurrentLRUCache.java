package com.fewbug.erodebytes.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 并发的LRU Cache， 使用ConcurrentHashMap 和 读写锁
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 10:43
 **/
public class ConcurrentLRUCache<K, V> {

    private final int capacity;

    private final Map<K, V> cache = new ConcurrentHashMap<>();

    private final List<K> order = new ArrayList<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public ConcurrentLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        lock.readLock().lock();
        try {
            V value = cache.get(key);
            if (value != null) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    order.remove(key);
                    order.add(key);
                } finally {
                    lock.readLock().lock();
                    lock.writeLock().unlock();
                }
            }
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(K key, V value) {
        lock.writeLock().lock();
        try {
            if (!cache.containsKey(key) && cache.size() >= capacity) {
                K toRemove = order.remove(0);
                cache.remove(toRemove);
            }
            cache.put(key, value);
            order.remove(key);
            order.add(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
