package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 23:37
 **/
public class H064 {

    /**
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 1 && m == 1) {
            return matrix[0][0] == '0' ? 0 : 1;
        }
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int row = 0; row < n; row++) {
            dp[row][0] = matrix[row][0] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[row][0]);
        }
        for (int col = 0; col < m; col++) {
            dp[0][col] = matrix[0][col] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[0][col]);
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[row][col] == '1') {
                    if (matrix[row - 1][col] == '0' || matrix[row][col - 1] == '0') {
                        dp[row][col] = 1;
                    } else {
                        int min = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
                        dp[row][col] = min + 1;
                    }
                    ans = Math.max(ans, dp[row][col]);
                }
            }
        }

        return ans * ans;
    }
}
