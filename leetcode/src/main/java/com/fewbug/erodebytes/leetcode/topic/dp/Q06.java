package com.fewbug.erodebytes.leetcode.topic.dp;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/6/11 11:04
 **/
public class Q06 {

    /**
     * 1 <= nums.length <= 105 <br>
     * -104 <= nums[i] <= 104
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            pre = pre > 0 ? pre + x : x;
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
