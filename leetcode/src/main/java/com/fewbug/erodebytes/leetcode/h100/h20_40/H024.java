package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 13:08
 **/
public class H024 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int solution1(int[] nums) {
        int len = nums.length;
        int pre = nums[0], ans = pre;
        for (int i = 1; i < len; i++) {
            int cur = pre > 0 ? pre + nums[i] : nums[i];
            ans = Math.max(ans, cur);
            pre = cur;
        }
        return ans;
    }
}
