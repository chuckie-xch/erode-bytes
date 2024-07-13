package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 20:37
 **/
public class H028 {

    /**
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 200
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int row = 1; row < m; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int col = 1; col < n; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }

        return dp[m - 1][n - 1];
    }
}
