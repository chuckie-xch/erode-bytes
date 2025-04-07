package com.fewbug.erodebytes.leetcode.topic.binarysearch;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/12 11:11
 **/
public class Q01 {

    /**
     * 你可以假设 nums 中的所有元素是不重复的。 <br>
     * n 将在 [1, 10000]之间。 <br>
     * nums 的每个元素都将在 [-9999, 9999]之间。<br>
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int solution1(int[] nums, int target) {
        int i = lowerBound(nums, target);
        return i < nums.length && nums[i] == target ? i : -1;
    }

    private int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int lowerBound2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


}
