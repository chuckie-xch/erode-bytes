package com.fewbug.erodebytes.leetcode.daily.year25.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/6 09:07
 **/
public class Day06 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[nums.length]);
        boolean[] used = new boolean[nums.length];
        dfs(ans, path, nums, nums.length, used, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int length, boolean[] used, int i) {
        if (i == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < length; j++) {
            if (used[j] || (j > 0 && nums[j] == nums[j - 1] && !used[j - 1])) {
                continue;
            }
            path.set(i, nums[j]);
            used[j] = true;
            dfs(ans, path, nums, length, used, i + 1);
            used[j] = false;
        }
    }
}
