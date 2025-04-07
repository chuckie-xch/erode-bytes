package com.fewbug.erodebytes.leetcode.daily.year25.m03;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/11 09:21
 **/
public class Day11 {

    /**
     * 3 <= nums.length <= 105 <br>
     * 1 <= nums[i] <= 105
     * 
     * @param nums
     * @return
     */
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        if (n == 3) {
            return nums[1] > nums[0] && nums[1] < nums[2] ? 2 : 0;
        }
        int[] lMax = new int[n];
        int[] rMin = new int[n];
        int preMax = 0;
        for (int i = 0; i < n - 1; i++) {
            preMax = Math.max(preMax, nums[i]);
            lMax[i + 1] = preMax;
        }
        int preMin = Integer.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            preMin = Math.min(preMin, nums[i]);
            rMin[i - 1] = preMin;
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int x = nums[i];
            if (lMax[i] < x && rMin[i] > x) {
                ans += 2;
            } else if (nums[i - 1] < x && nums[i + 1] > x) {
                ans += 1;
            }
        }

        return ans;
    }

    public int sumOfBeauties2(int[] nums) {
        int n = nums.length;
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        int ans = 0;
        int preMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int x = nums[i];
            if (preMax < x && sufMin[i + 1] > x) {
                ans += 2;
            } else if (nums[i - 1] < x && nums[i + 1] > x) {
                ans += 1;
            }
            preMax = Math.max(preMax, x);
        }

        return ans;
    }
}
