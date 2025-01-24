package com.fewbug.erodebytes.leetcode.daily.year25.m01;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/22 09:34
 **/
public class Day22 {

    /**
     * 3 <= piles.length <= 10^5
     * piles.length % 3 == 0
     * 1 <= piles[i] <= 10^4
     *
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int ans = 0;
        for (int i = length / 3; i < length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }
}
