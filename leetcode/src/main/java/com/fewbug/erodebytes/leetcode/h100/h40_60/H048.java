package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 10:50
 **/
public class H048 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * 除了某个元素只出现一次以外，其余每个元素均出现两次。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
