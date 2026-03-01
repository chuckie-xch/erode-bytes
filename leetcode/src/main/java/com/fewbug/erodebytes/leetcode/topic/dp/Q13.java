package com.fewbug.erodebytes.leetcode.topic.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/8/28 13:59
 **/
public class Q13 {

    /**
     * 提示：
     *
     * 1 <= power.length <= 105 <br>
     * 1 <= power[i] <= 109 <br>
     * 
     * @param power
     * @return
     */
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : power) {
            Integer cnt = cntMap.getOrDefault(x, 0);
            cntMap.put(x, cnt + 1);
        }
        int index = 0;
        int n = cntMap.size();
        int[] a = new int[n];
        for (int x : cntMap.keySet()) {
            a[index++] = x;
        }
        Arrays.sort(a);

        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(cntMap, memo, a, n - 1);
    }

    public long dfs(Map<Integer, Integer> cntMap, long[] memo, int[] a, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int x = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] >= x - 2) {
            j--;
        }
        return memo[i] = Math.max(dfs(cntMap, memo, a, i - 1), (long)x * cntMap.get(x) + dfs(cntMap, memo, a, j));
    }
}
