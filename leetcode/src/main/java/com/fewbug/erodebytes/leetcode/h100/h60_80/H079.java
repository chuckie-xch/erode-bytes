package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 21:35
 **/
public class H079 {

    private int ans = 0;

    /**
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * 0 <= nums[i] <= 100
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[len];
        process(nums, 0, list, used);

        return ans;
    }


    public int solution(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] help = new int[len + 2];
        System.arraycopy(nums, 0, help, 1, len);
        help[0] = 1;
        help[len + 1] = 1;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 0; i < len + 2; i++) {
            for (int j = 0; j < len + 2; j++) {
                dp[i][j] = -1;
            }
        }

        solve(help, dp, 0, len + 1);

        return dp[0][len + 1];
    }

    private int solve(int[] help, int[][] dp, int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = help[i] * help[left] * help[right];
            sum += solve(help, dp, left, i) + solve(help, dp, i, right);
            dp[left][right] = Math.max(sum, dp[left][right]);
        }
        return dp[left][right];
    }

    private void process(int[] nums, int count, List<Integer> list, boolean[] used) {
        if (count == nums.length) {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            ans = Math.max(ans, sum);
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int cur = nums[i];
            int lIndex = i - 1;

            while (lIndex >= 0 && used[lIndex]) {
                lIndex--;
            }
            int left = lIndex == -1 ? 1 : nums[lIndex];

            int rIndex = i + 1;
            while (rIndex < nums.length && used[rIndex]) {
                rIndex++;
            }
            int right = rIndex == nums.length ? 1 : nums[rIndex];

            int res = cur * left * right;

            used[i] = true;
            list.add(res);
            process(nums, count + 1, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
