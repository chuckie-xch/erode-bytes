package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 10:53
 **/
public class H021 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracing(nums, 0, len, res, list);
        return res;
    }

    private void backTracing(int[] nums, int i, int len, List<List<Integer>> res, List<Integer> list) {
        if (i == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < len; j++) {
            if (list.contains(nums[j])) {
                continue;
            }
            list.add(nums[j]);
            backTracing(nums, i + 1, len, res, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> solution1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[len];
        backTracing1(nums, used, 0, len, res, list);
        return res;
    }

    private void backTracing1(int[] nums, boolean[] used, int index, int len, List<List<Integer>> res, List<Integer> list) {
        if (index == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTracing1(nums, used, index + 1, len, res, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
