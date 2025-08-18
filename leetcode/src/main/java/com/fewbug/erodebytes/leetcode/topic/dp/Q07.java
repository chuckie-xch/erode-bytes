package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/6/23 09:27
 **/
public class Q07 {

    /**
     * 提示：
     *
     * m == grid.length <br>
     * n == grid[i].length <br>
     * 1 <= m, n <= 200 <br>
     * 0 <= grid[i][j] <= 200 <br>
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(m - 1, n - 1, memo, grid);
    }

    public int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            dp[i + 1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[1][1] = grid[0][0];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }
        return dp[m][n];
    }

    private int dfs(int i, int j, int[][] memo, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i - 1 < 0) {
            int res = dfs(i, j - 1, memo, grid) + grid[i][j];
            return memo[i][j] = res;
        }
        if (j - 1 < 0) {
            int res = dfs(i - 1, j, memo, grid) + grid[i][j];
            return memo[i][j] = res;
        }
        int res = Math.min(dfs(i - 1, j, memo, grid), dfs(i, j - 1, memo, grid)) + grid[i][j];
        return memo[i][j] = res;
    }

}
