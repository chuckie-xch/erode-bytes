package com.fewbug.erodebytes.leetcode.h100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/12 23:22
 **/
public class H020 {

    /**
     * 提示：
     * <p>
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        if (height.length < 3) {
            return 0;
        }
        int l = 1, r = height.length - 2;
        int lMax = height[0], rMax = height[height.length - 1];
        while (l <= r) {
            if (lMax < rMax) {
                ans += (lMax > height[l]) ? (lMax - height[l]) : 0;
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                ans += (rMax > height[r]) ? (rMax - height[r]) : 0;
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return ans;
    }
}
