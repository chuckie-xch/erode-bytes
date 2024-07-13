package com.fewbug.erodebytes.leetcode.h100.h1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 16:50
 **/
public class H008 {

    /**
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int a = nums[i];
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    res.add(Arrays.asList(a, b, c));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
