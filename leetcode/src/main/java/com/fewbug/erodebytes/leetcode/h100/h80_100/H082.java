package com.fewbug.erodebytes.leetcode.h100.h80_100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/20 14:48
 **/
public class H082 {

    /**
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int cur = i;
            int count = 0;
            while (cur != 0) {
                if (cur % 2 == 1) {
                    count++;
                }
                cur = cur / 2;
            }
            ans[i] = count;
        }

        return ans;
    }
}
