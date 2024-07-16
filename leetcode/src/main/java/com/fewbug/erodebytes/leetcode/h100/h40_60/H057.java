package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 00:43
 **/
public class H057 {

    /**
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     * <p>
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int target = nums[0];
        int blood = 1;
        for (int i = 1; i < len; i++) {
            if (blood == 0) {
                target = nums[i];
                blood++;
            } else if (nums[i] == target) {
                blood++;
            } else {
                blood--;
            }
        }
        return target;
    }
}
