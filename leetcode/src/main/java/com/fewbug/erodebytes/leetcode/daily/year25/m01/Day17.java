package com.fewbug.erodebytes.leetcode.daily.year25.m01;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/17 10:18
 **/
public class Day17 {

    /**
     * 1 <= nums.length <= 2 * 105
     * 0 <= nums[i] <= 109
     * 0 <= k <= 109
     *
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bit = new int[32];
        int ans = Integer.MAX_VALUE;
        int r = -1, l = 0, len = nums.length;
        while (r < len) {
            while (check(bit, k) && l <= r) {
                ans = Math.min(ans, r - l + 1);
                for (int i = 0; i <= 30; i++) {
                    bit[i] -= (nums[l] >> i) & 1;
                }
                l++;
            }
            r++;
            if (r < len) {
                for (int i = 0; i <=30; i++) {
                    bit[i] += (nums[r] >> i) & 1;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    private boolean check(int[] bit, int k) {
        for (int i = 30; i >= 0; i--) {
            if (bit[i] > 0 && ((k >> i) & 1) == 0) {
                return true;
            }
            if (bit[i] == 0 && ((k >> i) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}
