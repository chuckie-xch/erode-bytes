package com.fewbug.erodebytes.leetcode.topic.enumerationskill;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/1 11:15
 **/
public class Q04 {

    /**
     *
     * n == nums1.length <br>
     * n == nums2.length <br>
     * n == nums3.length <br>
     * n == nums4.length <br>
     * 1 <= n <= 200 <br>
     * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
     * 
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                if (cntMap.containsKey(sum)) {
                    cntMap.put(sum, cntMap.get(sum) + 1);
                } else {
                    cntMap.put(sum, 1);
                }
            }
        }
        int ans = 0;
        for (int a : nums3) {
            for (int b : nums4) {
                int sum = a + b;
                if (cntMap.containsKey(-sum)) {
                    ans += cntMap.get(-sum);
                }
            }
        }
        return ans;
    }
}
