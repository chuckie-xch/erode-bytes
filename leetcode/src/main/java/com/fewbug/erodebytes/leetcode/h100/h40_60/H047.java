package com.fewbug.erodebytes.leetcode.h100.h40_60;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 10:26
 **/
public class H047 {

    /**
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return len;
        }
        Arrays.sort(nums);
        int ans = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                ans = Math.max(ans, count);
            } else if (nums[i] - nums[i - 1] > 1) {
                count = 1;
            }
        }
        return ans;
    }
}
