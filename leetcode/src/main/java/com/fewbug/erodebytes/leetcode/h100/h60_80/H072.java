package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 10:09
 **/
public class H072 {

    /**
     * 提示：
     * <p>
     * 1 <= n <= 104
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
}
