package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 15:35
 **/
public class H033 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracing(res, list, nums, 0);
        return res;
    }

    private void backTracing(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTracing(res, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
