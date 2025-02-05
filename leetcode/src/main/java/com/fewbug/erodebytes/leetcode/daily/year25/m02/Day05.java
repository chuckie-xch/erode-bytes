package com.fewbug.erodebytes.leetcode.daily.year25.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/5 09:29
 **/
public class Day05 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 0, nums, nums.length);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int i, int[] nums, int length) {
        if (i == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int x = nums[i];
        path.add(nums[i]);
        dfs(ans, path, i + 1, nums, length);
        path.remove(path.size() - 1);
        i++;
        while (i < length && nums[i] == x) {
            i++;
        }
        dfs(ans, path, i, nums, length);
    }


}
