package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/17 09:24
 **/
public class Q04 {

    /**
     * n == nums.length
     * 1 <= n <= 105
     * 0 <= nums[i], k <= 105
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (i < k * 2) {
                continue;
            }
            ans[i - k] = (int) (sum / (k * 2 + 1));
            sum -= nums[i - 2 * k];
        }
        return ans;
    }
}
