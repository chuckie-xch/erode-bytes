package com.fewbug.erodebytes.leetcode.daily.year25.m02;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/7 09:18
 **/
public class Day07 {

    /**
     * 1 <= n <= 20
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0;
        int di = 0;
        for (int val = 1; val <= n * n; val++) {
            ans[i][j] = val;
            int x = i + dirs[di][0];
            int y = j + dirs[di][1];
            if (x < 0 || x >= n || y < 0 || y >= n || ans[x][y] != 0) {
                di = (di + 1) % 4;
            }
            i += dirs[di][0];
            j += dirs[di][1];
        }
        return ans;
    }
}
