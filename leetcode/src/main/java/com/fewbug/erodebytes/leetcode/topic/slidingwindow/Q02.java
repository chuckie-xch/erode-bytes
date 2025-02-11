package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/11 10:38
 **/
public class Q02 {

    /**
     * n == nums.length
     * 1 <= k <= n <= 105
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
        return maxSum / (k * 1.0);
    }
}
