package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/12 10:41
 **/
public class H017 {

    /**
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     * <p>
     * 0,1,2,4,5,6,7;
     * 3;
     * 4,5,6,7,0,1,2;
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // 左侧有序判断左侧
                if (target >= nums[left] && target < nums[mid]) {
                    return binarySearch(nums, target, left, mid);
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    return binarySearch(nums, target, mid, right);
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
