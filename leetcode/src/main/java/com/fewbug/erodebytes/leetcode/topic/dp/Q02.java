package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/21 09:53
 **/
public class Q02 {
    int[] memo;

    /**
     * 提示：
     *
     * 2 <= cost.length <= 1000 <br>
     * 0 <= cost[i] <= 999
     * 
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, cost);
    }

    public int solution(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }

    public int solution2(int[] cost) {
        int n = cost.length;
        int f0 = 0, f1 = 0;
        for (int i = 2; i <= n; i++) {
            int newF = Math.min(f1 + cost[i - 1], f0 + cost[i - 2]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    private int dfs(int i, int[] cost) {
        if (i == 0 || i == 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.min(dfs(i - 1, cost) + cost[i - 1], dfs(i - 2, cost) + cost[i - 2]);
        return memo[i];
    }
}
