package com.fewbug.erodebytes.leetcode.topic.binarysearch;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/17 09:30
 **/
public class Q03 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 2000 <br>
     * -2000 <= nums[i] <= 2000 <br>
     * nums 按 非递减顺序 排列。 <br>
     * 
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        int lowerBound = lowerBound(nums);
        int higherBound = higherBound(nums);
        int n = nums.length;
        return Math.max(n - lowerBound, higherBound + 1);
    }

    private int higherBound(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int lowerBound(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
