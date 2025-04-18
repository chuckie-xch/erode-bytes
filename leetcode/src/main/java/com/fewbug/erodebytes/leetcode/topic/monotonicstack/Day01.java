package com.fewbug.erodebytes.leetcode.topic.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/10 11:20
 **/
public class Day01 {

    /**
     * 提示：
     *
     * 1 <= temperatures.length <= 105 <br>
     * 30 <= temperatures[i] <= 100
     * 
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int x = temperatures[i];
            while (!st.isEmpty() && x >= temperatures[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = temperatures[i];
            while (!st.isEmpty() && x > temperatures[st.peek()]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        return ans;
    }
}
