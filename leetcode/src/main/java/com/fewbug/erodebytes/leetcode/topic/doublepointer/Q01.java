package com.fewbug.erodebytes.leetcode.topic.doublepointer;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/6 08:51
 **/
public class Q01 {

    /**
     * 1 <= nums.length <= 1000 <br>
     * 0 <= nums[i] <= 1000
     * 
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = n - 1; i >= 2; i--) {
            int maxEge = nums[i];
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum <= maxEge) {
                    l++;
                } else {
                    cnt += r - l;
                    r--;
                }
            }
        }
        return cnt;
    }

}
