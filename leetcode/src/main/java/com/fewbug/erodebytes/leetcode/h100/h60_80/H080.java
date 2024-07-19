package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 22:55
 **/
public class H080 {

    /**
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        process(coins, dp, amount);
        return dp[amount];
    }

    private int process(int[] coins, int[] dp, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int cur = coins[i];
            int result = process(coins, dp, amount - cur);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }
}
