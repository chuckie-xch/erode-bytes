package com.fewbug.erodebytes.leetcode.topic.dp;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/8/19 15:54
 **/
public class Q10 {

    /**
     * 提示:
     *
     * 1 <= nums.length <= 2 * 104 <br>
     * -10 <= nums[i] <= 10 <br>
     * nums 的任何子数组的乘积都 保证 是一个 32-位 整数 <br>
     * 
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int preMax = nums[0];
        int preMin = nums[0];
        int ans = preMax;
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            int max = Math.max(x, Math.max(x * preMax, x * preMin));
            int min = Math.min(x, Math.min(x * preMax, x * preMin));
            ans = Math.max(ans, max);
            preMax = max;
            preMin = min;
        }
        return ans;
    }
}
