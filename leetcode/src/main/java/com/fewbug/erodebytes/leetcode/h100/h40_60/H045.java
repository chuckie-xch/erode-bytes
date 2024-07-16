package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 09:56
 **/
public class H045 {

    /**
     * 提示：
     * <p>
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int ans = 0;
        int rMax = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            ans = Math.max(rMax - prices[i], ans);
            rMax = Math.max(rMax, prices[i]);
        }
        return ans;
    }
}
