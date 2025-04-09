package com.fewbug.erodebytes.leetcode.topic.prefixsum;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/9 11:05
 **/
public class Q02 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 105 <br>
     * -104 <= nums[i] <= 104
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int s = 0, mn = 0, ans = Integer.MIN_VALUE;
        for (int x : nums) {
            s += x;
            ans = Math.max(ans, s - mn);
            mn = Math.min(mn, s);
        }
        return ans;
    }
}
