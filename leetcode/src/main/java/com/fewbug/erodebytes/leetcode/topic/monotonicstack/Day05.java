package com.fewbug.erodebytes.leetcode.topic.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/17 16:51
 **/
public class Day05 {

    /**
     * 1 <= hours.length <= 104 <br>
     * 0 <= hours[i] <= 16
     * 
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] s = new int[n + 1];
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 1; i <= hours.length; i++) {
            int x = hours[i - 1] > 8 ? 1 : -1;
            s[i] = s[i - 1] + x;
            if (s[i] < s[st.peek()]) {
                st.push(i);
            }
        }
        for (int i = n; i >= 0; i--) {
            while (!st.isEmpty() && s[i] > s[st.peek()]) {
                ans = Math.max(ans, i - st.pop());
            }
        }
        return ans;
    }
}
