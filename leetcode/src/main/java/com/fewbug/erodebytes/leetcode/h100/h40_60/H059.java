package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 01:41
 **/
public class H059 {

    /**
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    res++;
                    extend(grid, used, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void extend(char[][] grid, boolean[][] used, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        char cur = grid[i][j];
        if (cur != '1') {
            return;
        }
        used[i][j] = true;
        extend(grid, used, i, j - 1, m, n);
        extend(grid, used, i, j + 1, m, n);
        extend(grid, used, i + 1, j, m, n);
        extend(grid, used, i - 1, j, m, n);
    }
}
