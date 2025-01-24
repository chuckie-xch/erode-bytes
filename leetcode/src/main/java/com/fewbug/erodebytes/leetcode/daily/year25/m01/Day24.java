package com.fewbug.erodebytes.leetcode.daily.year25.m01;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/24 09:54
 **/
public class Day24 {


    /**
     * 1 <= prices.length <= 1000
     * 1 <= prices[i] <= 105
     * @param prices
     * @return
     */
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + prices[i - 1];
            int start = (i + 1) / 2;
            for (int j = start; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j - 1] + prices[j - 1]);
            }
        }
        return dp[n];
    }


}
