package com.fewbug.erodebytes.leetcode.daily.year25.m01;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/22 09:34
 **/
public class Day21 {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] memo = new int[n][k + 1];
        return dfs(n - 1, k, piles, memo);
    }

    public int dfs(int i, int j, List<List<Integer>> piles, int[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = dfs(i - 1, j, piles, memo);
        int totalValue = 0;
        for (int w = 0; w < Math.min(piles.get(i).size(), j); w++) {
            totalValue += piles.get(i).get(w);
            res = Math.max(res, dfs(i - 1, j - w - 1, piles, memo) + totalValue);
        }
        memo[i][j] = res;
        return res;
    }
}
