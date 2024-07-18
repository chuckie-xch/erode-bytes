package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/18 23:56
 **/
public class H070 {

    /**
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            }
            if (cur < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
