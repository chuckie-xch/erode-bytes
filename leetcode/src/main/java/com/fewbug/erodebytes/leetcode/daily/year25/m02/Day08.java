package com.fewbug.erodebytes.leetcode.daily.year25.m02;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/8 10:17
 **/
public class Day08 {

    /**
     * 提示：
     * <p>
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(m - 1, n - 1, memo, obstacleGrid);
    }

    private int dfs(int i, int j, int[][] memo, int[][] obstacleGrid) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = dfs(i - 1, j, memo, obstacleGrid) + dfs(i, j - 1, memo, obstacleGrid);
        return memo[i][j];
    }
}
