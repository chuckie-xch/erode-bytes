package com.fewbug.erodebytes.leetcode.daily.year24.m12;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/12/31 10:06
 **/
public class Day031 {

    /**
     * 提示：
     *
     * 1 <= m, n <= 105
     * horizontalCut.length == m - 1
     * verticalCut.length == n - 1
     * 1 <= horizontalCut[i], verticalCut[i] <= 103
     * @param m
     * @param n
     * @param horizontalCut
     * @param verticalCut
     * @return
     */
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i = 0;
        int j = 0;
        long ans = 0;
        while (i < m - 1 || j < n - 1) {
            if (i == m - 1 || j < n - 1 && verticalCut[j] < horizontalCut[i]) {
                ans += verticalCut[j++] * (m - i);
            } else {
                ans += horizontalCut[i++] * (n - j);
            }
        }
        return ans;
    }


}
