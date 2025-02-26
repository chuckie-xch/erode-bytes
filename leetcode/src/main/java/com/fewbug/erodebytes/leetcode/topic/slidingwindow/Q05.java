package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/18 10:23
 **/
public class Q05 {

    /**
     * 1 <= k <= nums.length <= 105
     * 1 <= nums[i] <= 105
     *
     * @param nums
     * @param k
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0, sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            if (i + 1 < k) {
                continue;
            }
            if (map.size() == k) {
                ans = Math.max(ans, sum);
            }
            sum -= nums[i - k + 1];
            if (map.merge(nums[i - k + 1], -1, Integer::sum) == 0) {
                map.remove(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
