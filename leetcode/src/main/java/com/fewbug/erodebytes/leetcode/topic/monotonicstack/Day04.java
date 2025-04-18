package com.fewbug.erodebytes.leetcode.topic.monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/15 09:31
 **/
public class Day04 {

    /**
     * 提示:
     *
     * 1 <= nums.length <= 104 <br>
     * -109 <= nums[i] <= 109
     * 
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(nums, 0, arr, i * n, n);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = arr[i];
            while (!st.isEmpty() && i - st.peek() <= n - 1 && x > arr[st.peek()]) {
                int j = st.pop();
                if (j < n) {
                    ans[j] = x;
                }
            }
            st.push(i);
        }
        return ans;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            int x = nums[index];
            while (!st.isEmpty() && x > nums[st.peek()]) {
                int j = st.pop();
                ans[j] = x;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}
