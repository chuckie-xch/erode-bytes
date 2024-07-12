package com.fewbug.erodebytes.leetcode.h100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/12 13:51
 **/
public class H019 {

    /**
     * 提示：
     * <p>
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * candidates 的所有元素 互不相同
     * 1 <= target <= 40
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int maxIndex = binarySearchMoraThan(candidates, target) - 1;
        if (maxIndex < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracing(candidates, res, list, 0, maxIndex, target, 0);
        return res;
    }

    private void backTracing(int[] candidates, List<List<Integer>> res, List<Integer> list, int index, int maxIndex, int target, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= maxIndex && sum <= target; i++) {
            list.add(candidates[i]);
            backTracing(candidates, res, list, i, maxIndex, target, sum + candidates[i]);
            list.remove(list.size() - 1);
        }

    }

    private int binarySearchMoraThan(int[] candidates, int target) {
        int l = 0, r = candidates.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target >= candidates[mid]) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }
}
