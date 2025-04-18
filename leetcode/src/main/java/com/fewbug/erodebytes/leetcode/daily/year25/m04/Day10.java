package com.fewbug.erodebytes.leetcode.daily.year25.m04;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/10 23:00
 **/
public class Day10 {

    /**
     * 提示：
     *
     * 1 <= start <= finish <= 1015 <br>
     * 1 <= limit <= 9 <br>
     * 1 <= s.length <= floor(log10(finish)) + 1 <br>
     * s 数位中每个数字都小于等于 limit 。 <br>
     * s 不包含任何前导 0 。
     * 
     * @param start
     * @param finish
     * @param limit
     * @param s
     * @return
     */
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = "0".repeat(n - low.length()) + low;
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true, low.toCharArray(), high.toCharArray(), limit, s.toCharArray(), memo);
    }

    private long dfs(int i, boolean limitLow, boolean limitHigh, char[] low, char[] high, int limit, char[] s,
        long[] memo) {
        if (i == high.length) {
            return 1;
        }
        if (!limitLow && !limitHigh && memo[i] != -1) {
            return memo[i];
        }

        int lo = limitLow ? low[i] - '0' : 0;
        int hi = limitHigh ? high[i] - '0' : 9;

        long res = 0;
        if (i < high.length - s.length) {
            for (int d = lo; d <= Math.min(hi, limit); d++) {
                res += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi, low, high, limit, s, memo);
            }
        } else {
            int x = s[i - (high.length - s.length)] - '0';
            if (lo <= x && x <= hi) {
                res = dfs(i + 1, limitLow && x == lo, limitHigh && x == hi, low, high, limit, s, memo);
            }
        }
        if (!limitLow && !limitHigh) {
            memo[i] = res;
        }
        return res;
    }
}
