package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/28 17:11
 **/
public class Q04 {

    private int[][] memo;

    /**
     * 提示：
     *
     * 1 <= nums.length <= 20 <br>
     * 0 <= nums[i] <= 1000 <br>
     * 0 <= sum(nums[i]) <= 1000 <br>
     * -1000 <= target <= 1000 <br>
     * 
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int newTarget = s / 2;
        memo = new int[n][newTarget + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, newTarget, nums);
    }

    private int dfs(int i, int rest, int[] nums) {
        if (i < 0) {
            return rest == 0 ? 1 : 0;
        }
        if (memo[i][rest] != -1) {
            return memo[i][rest];
        }
        if (rest < nums[i]) {
            return memo[i][rest] = dfs(i - 1, rest, nums);
        }
        return memo[i][rest] = dfs(i - 1, rest, nums) + dfs(i - 1, rest - nums[i], nums);
    }
}
