package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/28 11:05
 **/
public class Q14 {

    /**
     * n == height.length <br>
     * 1 <= n <= 2 * 104 <br>
     * 0 <= height[i] <= 105 <br>
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int lMax = height[0];
        int rMax = height[n - 1];

        int l = 1, r = n - 2, ans = 0;
        while (l <= r) {
            if (lMax < rMax) {
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }

        return ans;
    }
}
