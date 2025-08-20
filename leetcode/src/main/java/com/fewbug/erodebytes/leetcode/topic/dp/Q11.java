package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/8/20 09:14
 **/
public class Q11 {

    /**
     * 提示：
     * 
     * 1 <= nums.length <= 100 <br>
     * 0 <= nums[i] <= 1000 <br>
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int res1 = dfs(nums, 0, n - 2, memo);
        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int res2 = dfs(nums, 1, n - 1, memo1);
        return Math.max(res1, res2);
    }

    private int dfs(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return nums[start];
        }

        if (memo[start] != -1) {
            return memo[start];
        }
        int x = nums[start];
        int choose = x + dfs(nums, start + 2, end, memo);
        int noChoose = dfs(nums, start + 1, end, memo);
        return memo[start] = Math.max(choose, noChoose);
    }

    public int solution(int[] nums) {
        int n = nums.length;
        return Math.max(dfs1(nums, 1, n - 1), nums[0] + dfs1(nums, 2, n - 2));
    }

    private int dfs1(int[] nums, int start, int end) {
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i <= end; i++) {
            int x = nums[i];
            int newF = Math.max(f0 + x, f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

}
