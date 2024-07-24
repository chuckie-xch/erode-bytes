package com.fewbug.erodebytes.leetcode.h100.h80_100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/24 15:21
 **/
public class H087 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        if (len == 2) {
            return nums[0] == nums[1];
        }
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        boolean odd = sum % 2 == 0;
        if (!odd) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        } else if (maxNum == target) {
            return true;
        }

        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            for (int j = 1; j <= target; j++) {
                if (cur <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][target];
    }
}
