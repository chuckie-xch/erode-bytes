package com.fewbug.erodebytes.leetcode.h100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/12 13:21
 **/
public class H018 {

    /**
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l > nums.length - 1 || nums[l] != target) {
            return new int[]{-1, -1};
        }
        r = l;
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        return new int[]{l, r - 1};
    }
}
