package com.fewbug.erodebytes.leetcode.h100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/9 14:31
 **/
public class H001 {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (indexMap.containsKey(rest)) {
                return new int[]{i, indexMap.get(rest)};
            }
            indexMap.put(nums[i], i);
        }
        return new int[0];
    }
}
