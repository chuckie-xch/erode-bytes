package com.fewbug.erodebytes.leetcode.topic.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/14 10:13
 **/
public class Day03 {

    /**
     * 提示：
     *
     * n == position.length == speed.length <br>
     * 1 <= n <= 105 <br>
     * 0 < target <= 106 <br>
     * 0 <= position[i] < target <br>
     * position 中每个值都 不同 <br>
     * 0 < speed[i] <= 106
     * 
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] t = new double[target];
        for (int i = 0; i < n; i++) {
            t[position[i]] = (target - position[i]) / (double)speed[i];
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < target; i++) {
            double x = t[i];
            if (x != 0) {
                while (!st.isEmpty() && x >= t[st.peek()]) {
                    st.pop();
                }
                st.push(i);
            }
        }
        return st.size();
    }
}
