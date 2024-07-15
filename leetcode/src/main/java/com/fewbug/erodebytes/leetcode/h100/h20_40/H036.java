package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/15 11:45
 **/
public class H036 {

    /**
     * 提示：
     * <p>
     * rows == matrix.length
     * cols == matrix[0].length
     * 1 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            ans = Math.max(ans, getMaxArea(height));
        }
        return ans;
    }

    private int getMaxArea(int[] height) {
        int len = height.length;
        if (len == 1) {
            return height[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int ans = 0;
        int[] help = new int[len + 2];
        help[0] = 0;
        help[len + 1] = 0;
        System.arraycopy(height, 0, help, 1, len);
        for (int i = 1; i < len + 2; i++) {
            while (help[i] < help[deque.peekLast()]) {
                int h = help[deque.pollLast()];
                ans = Math.max(ans, h * (i - deque.peekLast() - 1));
            }
            deque.addLast(i);
        }
        return ans;
    }
}
