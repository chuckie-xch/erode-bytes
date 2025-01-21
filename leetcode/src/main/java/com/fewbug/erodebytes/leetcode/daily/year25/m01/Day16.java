package com.fewbug.erodebytes.leetcode.daily.year25.m01;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/16 09:10
 **/
public class Day16 {

    /**
     * 1 <= nums.length <= 50
     * 0 <= nums[i] <= 50
     * 0 <= k < 64
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            for (int j = i; j < nums.length; j++) {
                value = value | nums[j];
                if (value >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }


}
