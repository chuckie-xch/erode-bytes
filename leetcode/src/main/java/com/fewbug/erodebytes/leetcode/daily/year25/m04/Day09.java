package com.fewbug.erodebytes.leetcode.daily.year25.m04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/9 14:08
 **/
public class Day09 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 100 <br>
     * 1 <= nums[i] <= 100 <br>
     * 1 <= k <= 100
     * 
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            }
            if (x > k) {
                set.add(x);
            }
        }
        return set.size();
    }
}
