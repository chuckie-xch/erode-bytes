package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 20:22
 **/
public class H027 {

    /**
     * 提示：
     * <p>
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
