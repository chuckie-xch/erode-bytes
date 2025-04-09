package com.fewbug.erodebytes.leetcode.daily.year25.m04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/8 10:19
 **/
public class Day08 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 100 <br>
     * 1 <= nums[i] <= 100
     * 
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!seen.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }
}
