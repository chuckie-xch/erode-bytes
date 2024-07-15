package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 22:43
 **/
public class H035 {

    /**
     * 提示：
     * <p>
     * 1 <= heights.length <=105
     * 0 <= heights[i] <= 104
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int[] help = new int[len + 2];
        help[0] = 0;
        help[len + 1] = 0;
        System.arraycopy(heights, 0, help, 1, len);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int ans = 0;

        for (int i = 1; i < len + 2; i++) {
            while (help[i] < help[queue.peekLast()]) {
                int height = help[queue.pollLast()];
                ans = Math.max(ans, height * (i - queue.peekLast() - 1));
            }
            queue.addLast(i);
        }

        return ans;
    }

    public int solution(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int[] l = new int[len];
        int[] r = new int[len];
        Arrays.fill(l, -1);
        Arrays.fill(r, len);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && heights[i] < heights[queue.peekLast()]) {
                r[queue.pollLast()] = i;
            }
            queue.addLast(i);
        }

        queue.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!queue.isEmpty() && heights[i] < heights[queue.peekLast()]) {
                l[queue.pollLast()] = i;
            }
            queue.addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int area = heights[i] * (r[i] - l[i] - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
