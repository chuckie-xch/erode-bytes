package com.fewbug.erodebytes.leetcode.h100.h40_60;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 18:29
 **/
public class H052_More {

    class LRUCache {

        private int capacity;
        private Map<Integer, Node> map = new HashMap<>();
        private Node dummy = new Node(0, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy.pre = dummy;
            dummy.next = dummy;
        }

        public int get(int key) {
            Node node = getNode(key);
            return node == null ? -1 : node.value;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            Node newNode = new Node(key, value);
            addFirst(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                Node lastNode = dummy.pre;
                map.remove(lastNode.key);
                remove(lastNode);
            }
        }

        private Node getNode(int key) {
            Node node = map.get(key);
            if (node != null) {
                remove(node);
                addFirst(node);
                return node;
            }
            return null;
        }

        private void addFirst(Node node) {
            node.pre = dummy;
            node.next = dummy.next;
            node.next.pre = node;
            node.pre.next = node;
        }

        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
