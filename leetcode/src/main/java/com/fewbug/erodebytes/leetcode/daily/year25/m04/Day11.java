package com.fewbug.erodebytes.leetcode.daily.year25.m04;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/11 10:10
 **/
public class Day11 {

    private int[][][] memo;
    private char[] lowS, highS;
    private int n, m, diffLh;

    /**
     * 提示：
     *
     * 1 <= low <= high <= 104
     * 
     * @param low
     * @param high
     * @return
     */
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            char[] s = Integer.toString(i).toCharArray();
            int n = s.length;
            if (n % 2 != 0) {
                continue;
            }
            int diff = 0;
            for (int j = 0; j < n / 2; j++) {
                diff += s[j];
            }
            for (int j = n / 2; j < n; j++) {
                diff -= s[j];
            }
            if (diff == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int solution2(int low, int high) {
        lowS = String.valueOf(low).toCharArray();
        highS = String.valueOf(high).toCharArray();
        n = highS.length;
        m = n / 2;
        diffLh = n - lowS.length;

        memo = new int[n][diffLh + 1][m * 18 + 1];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, -1, m * 9, true, true);
    }

    private int dfs(int i, int start, int diff, boolean limitLow, boolean limitHigh) {
        if (i == n) {
            return diff == m * 9 ? 1 : 0;
        }
        if (start != -1 && !limitLow && !limitHigh && memo[i][start][diff] != -1) {
            return memo[i][start][diff];
        }
        int lo = limitLow && i >= diffLh ? lowS[i - diffLh] - '0' : 0;
        int hi = limitHigh ? highS[i] - '0' : 9;

        if (start < 0 && (n - i) % 2 > 0) {
            return lo > 0 ? 0 : dfs(i + 1, start, diff, true, false);
        }
        int res = 0;
        boolean isLeft = start < 0 || i < (start + n) / 2;
        for (int d = lo; d <= hi; d++) {
            res += dfs(i + 1, start < 0 && d > 0 ? i : start, diff + (isLeft ? d : -d), limitLow && d == lo,
                limitHigh && d == hi);
        }

        if (start != -1 && !limitLow && !limitHigh) {
            memo[i][start][diff] = res;
        }
        return res;
    }
}
