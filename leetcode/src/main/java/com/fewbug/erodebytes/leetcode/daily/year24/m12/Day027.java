package com.fewbug.erodebytes.leetcode.daily.year24.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/12/27 09:28
 **/
public class Day027 {

    /**
     * 提示：
     *
     * 1 <= nums.length, queries.length <= 105
     * 1 <= queries[i] <= 105
     * 1 <= nums[i], x <= 104
     * @param nums
     * @param queries
     * @param x
     * @return
     */
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                targetList.add(i);
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i] - 1;
            if (index < targetList.size()) {
                ans[i] = targetList.get(index);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}

