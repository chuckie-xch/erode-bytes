package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/18 16:13
 **/
public class H069 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int newLen = len - k + 1;
        int[] ans = new int[newLen];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            while (!deque.isEmpty() && cur > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                if (i >= k) {
                    if (deque.peekFirst() == i - k) {
                        deque.pollFirst();
                    }
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
