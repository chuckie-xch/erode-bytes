package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 19:52
 **/
public class H054 {

    /**
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int len = nums.length;
        int[][] dp = new int[len][2];
        // 最小值
        dp[0][0] = nums[0];
        // 最大值
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            int preMax = dp[i - 1][1];
            int preMin = dp[i - 1][0];
            int max = Math.max(Math.max(preMin * cur, preMax * cur), cur);
            int min = Math.min(Math.min(preMin * cur, preMax * cur), cur);
            dp[i][0] = min;
            dp[i][1] = max;
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }

}
