package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 13:43
 **/
public class H025 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }


}
