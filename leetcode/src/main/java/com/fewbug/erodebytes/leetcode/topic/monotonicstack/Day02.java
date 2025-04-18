package com.fewbug.erodebytes.leetcode.topic.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/11 11:09
 **/
public class Day02 {

    /**
     * 提示：
     *
     * 1 <= prices.length <= 500 <br>
     * 1 <= prices[i] <= 10^3
     * 
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = prices[i];
            while (!st.isEmpty() && x <= prices[st.peek()]) {
                Integer j = st.pop();
                ans[j] = prices[j] - x;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            Integer index = st.pop();
            ans[index] = prices[index];
        }
        return ans;
    }

    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = prices[i];
            while (!st.isEmpty() && x < prices[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - prices[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}
