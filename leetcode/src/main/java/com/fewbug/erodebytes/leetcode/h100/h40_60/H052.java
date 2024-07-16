package com.fewbug.erodebytes.leetcode.h100.h40_60;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 16:02
 **/
public class H052 {

    /**
     * 提示：
     * <p>
     * 1 <= capacity <= 3000
     * 0 <= key <= 10000
     * 0 <= value <= 105
     * 最多调用 2 * 105 次 get 和 put
     */
    public class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}
