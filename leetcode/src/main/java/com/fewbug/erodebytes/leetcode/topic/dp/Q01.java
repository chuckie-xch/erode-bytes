package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/3 21:53
 **/
public class Q01 {

    /**
     * 1 <= k <= s.length <= 100 <br>
     * s 中只含有小写英文字母。
     * 
     * @param s
     * @param k
     * @return
     */
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int memoDfs[][] = new int[n][n];
        for (int[] row : memoDfs) {
            Arrays.fill(row, -1);
        }

        int memoChange[][] = new int[n][n];
        for (int[] row : memoChange) {
            Arrays.fill(row, -1);
        }
        return dfs(k - 1, n - 1, s.toCharArray(), memoDfs, memoChange);
    }

    private int dfs(int i, int r, char[] arr, int[][] memoDfs, int[][] memoChange) {
        if (memoDfs[i][r] != -1) {
            return memoDfs[i][r];
        }
        if (i == 0) {
            return minChange(arr, 0, r, memoChange);
        }
        int res = Integer.MAX_VALUE;
        for (int l = i; l <= r; l++) {
            res = Math.min(res, minChange(arr, l, r, memoChange) + dfs(i - 1, l - 1, arr, memoDfs, memoChange));
        }
        memoDfs[i][r] = res;
        return res;
    }

    private int minChange(char[] arr, int i, int j, int[][] memoChange) {
        if (memoChange[i][j] != -1) {
            return memoChange[i][j];
        }
        if (i >= j) {
            return 0;
        }
        int res = minChange(arr, i + 1, j - 1, memoChange);
        if (arr[i] != arr[j]) {
            res += 1;
        }
        memoChange[i][j] = res;
        return res;
    }
}
