package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 14:11
 **/
public class H031 {

    /**
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int l = -1, r = nums.length;
        int index = 0;
        while (index < r) {
            if (nums[index] < 1) {
                l++;
                if (index != l) {
                    swap(nums, index, l);
                }
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, --r);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
