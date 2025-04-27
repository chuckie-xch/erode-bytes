package com.fewbug.erodebytes.leetcode.topic.dp;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/27 11:20
 **/
public class Q03 {


    /**
     * 提示：
     *
     * 1 <= nums.length <= 100 <br>
     * 0 <= nums[i] <= 400
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }



}
