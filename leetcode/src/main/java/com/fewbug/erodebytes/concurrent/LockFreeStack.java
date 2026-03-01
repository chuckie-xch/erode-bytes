package com.fewbug.erodebytes.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 无锁栈，使用 CAS，要注意 ABA 的问题
 * 
 * @author chunhang.xch
 * @Description
 * @date 2025/9/15 14:26
 **/
public class LockFreeStack<E> {

    private final AtomicStampedReference<Node<E>> top = new AtomicStampedReference<>(null, 0);

    public void push(E item) {
        Node<E> oldTop;
        Node<E> newTop;
        int[] stamp = new int[1];
        do {
            oldTop = top.get(stamp);
            newTop = new Node<>(item, oldTop);
        } while (!top.compareAndSet(oldTop, newTop, stamp[0], stamp[0] + 1));
    }

    public E pop() {
        Node<E> oldTop;
        Node<E> newTop;
        int[] stamp = new int[1];
        do {
            oldTop = top.get(stamp);
            if (oldTop == null) {
                throw new RuntimeException("stack is empty");
            }
            newTop = oldTop.next;
        } while (!top.compareAndSet(oldTop, newTop, stamp[0], stamp[0] + 1));
        return oldTop.item;
    }

    class Node<E> {
        final E item;
        final Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
