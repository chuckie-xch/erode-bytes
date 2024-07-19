package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 10:43
 **/
public class H073 {

    /**
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * 进阶：你能尽量减少完成的操作次数吗？
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = -1;
        int index = 0;
        while (index < len) {
            int cur = nums[index];
            if (cur != 0) {
                swap(nums, index, ++left);
            }
            index++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
