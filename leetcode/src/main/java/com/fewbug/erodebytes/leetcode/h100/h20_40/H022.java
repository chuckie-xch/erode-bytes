package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 11:25
 **/
public class H022 {

    /**
     * 提示：
     * <p>
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n / 2; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - row][col];
                matrix[n - 1 - row][col] = temp;
            }
        }

        for (int col = 0; col < m; col++) {
            for (int row = col + 1; row < n; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}
