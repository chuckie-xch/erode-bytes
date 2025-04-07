package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/27 10:39
 **/
public class Q12 {

    /**
     * n == plants.length <br>
     * 1 <= n <= 105 <br>
     * 1 <= plants[i] <= 106 <br>
     * max(plants[i]) <= capacityA, capacityB <= 109
     * 
     * @param plants
     * @param capacityA
     * @param capacityB
     * @return
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0, l = 0, r = plants.length - 1, totalA = capacityA, totalB = capacityB;
        while (l < r) {
            if (totalA < plants[l]) {
                ans++;
                totalA = capacityA;
            }
            if (totalB < plants[r]) {
                ans++;
                totalB = capacityB;
            }
            totalA -= plants[l];
            totalB -= plants[r];
            l++;
            r--;
        }
        if (l == r && Math.max(totalA, totalB) < plants[l]) {
            ans++;
        }
        return ans;
    }
}
