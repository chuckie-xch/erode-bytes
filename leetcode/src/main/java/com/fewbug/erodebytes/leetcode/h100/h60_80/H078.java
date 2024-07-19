package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 20:18
 **/
public class H078 {

    /**
     * 提示：
     * <p>
     * 1 <= prices.length <= 5000
     * 0 <= prices[i] <= 1000
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        // 持有股票
        dp[0][0] = -prices[0];
        // 不持有股票，在冻结期
        dp[0][1] = 0;
        // 不持有股票，不在冻结期
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        int ans = Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
        return ans;
    }

}
