package com.fewbug.erodebytes.leetcode.daily.year25.m01;

import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/15 09:58
 **/
public class Day15 {

    /**
     * 2 <= nums.length <= 2 * 105
     * 1 <= nums[i] <= 109
     * 1 <= k <= 109
     * 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。
     *
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add((long) nums[i]);
        }
        return solution(minHeap, k);
    }

    private int solution(PriorityQueue<Long> minHeap, int k) {
        if (minHeap.size() < 2) {
            return 0;
        }
        Long minOne = minHeap.poll();
        Long minTwo = minHeap.poll();
        if (minOne >= k && minTwo >= k) {
            return 0;
        }
        Long newNumber = Math.min(minOne, minTwo) * 2 + Math.max(minOne, minTwo);
        minHeap.add(newNumber);
        return 1 + solution(minHeap, k);
    }

    public int solution1(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(1L * n);
        }
        int ans = 0;
        while (heap.size() > 1 && heap.peek() < k) {
            long a = heap.poll(), b = heap.poll();
            if (a >= k) {
                break;
            }
            heap.add(a * 2 + b);
            ans++;
        }
        return ans;
    }

}
