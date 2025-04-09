package com.fewbug.erodebytes.leetcode.daily.year25.m04;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/7 23:05
 **/
public class Day07 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 200 <br>
     * 1 <= nums[i] <= 100
     * 
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        if (s % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int[][] memo = new int[n][s / 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, s / 2, nums, memo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] memo) {
        if (i < 0) {
            return j == 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean ans = j >= nums[i] && dfs(i - 1, j - nums[i], nums, memo) || dfs(i - 1, j, nums, memo);
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
