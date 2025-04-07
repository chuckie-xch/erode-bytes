package com.fewbug.erodebytes.leetcode.topic.binarysearch;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/18 09:07
 **/
public class Q04 {

    /**
     * 提示：
     *
     * 2 <= k <= price.length <= 105 <br>
     * 1 <= price[i] <= 109
     * 
     * @param price
     * @param k
     * @return
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0, r = (price[n - 1] - price[0]) / (k - 1);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (f(price, mid) >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    private int f(int[] price, int d) {
        int pre = price[0];
        int cnt = 1;
        for (int num : price) {
            if (num >= pre + d) {
                cnt++;
                pre = num;
            }
        }
        return cnt;
    }

}
