package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/8/25 10:01
 **/
public class Q12 {

    /**
     *
     * 1 <= coins.length <= 12 <br>
     * 1 <= coins[i] <= 231 - 1 <br>
     * 0 <= amount <= 104 <br>
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        return dfs(0, coins, memo, amount);
    }

    private int dfs(int i, int[] coins, int memo[], int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int x = coins[j];
            int result = dfs(i, coins, memo, amount - x);
            if (result >= 0 && result<min) {
                min = result + 1;
            }
        }
        memo[amount] = min  == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    public int solution(int[] coins, int amount) {
        return 0;
    }


}
