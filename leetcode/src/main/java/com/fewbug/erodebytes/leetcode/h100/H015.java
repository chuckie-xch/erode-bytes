package com.fewbug.erodebytes.leetcode.h100;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/11 16:51
 **/
public class H015 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverseArr(nums, i + 1, len - 1);

    }

    private static void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 6, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
