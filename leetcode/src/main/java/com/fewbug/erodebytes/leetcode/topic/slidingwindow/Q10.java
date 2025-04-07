package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/26 10:14
 **/
public class Q10 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 105 1 <= nums[i] <= 104 1 <= x <= 109
     * 
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1;
        }
        int l = 0;
        int ans = -1, s = 0;
        for (int r = 0; r < nums.length; r++) {
            int cur = nums[r];
            s += cur;
            while (s > target) {
                s -= nums[l];
                l++;
            }
            if (s == target) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans == -1 ? ans : nums.length - ans;
    }
}
