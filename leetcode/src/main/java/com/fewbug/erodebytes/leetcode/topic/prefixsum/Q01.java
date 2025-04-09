package com.fewbug.erodebytes.leetcode.topic.prefixsum;

import com.fewbug.erodebytes.datastruct.NumArray;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/8 09:39
 **/
public class Q01 {

    /**
     * 提示：
     *
     * 1 <= nums.length <= 105 <br>
     * -104 <= nums[i] <= 104
     * 
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        NumArray numArray = new NumArray(nums);
        int[] s = numArray.getS();
        int min = s[0], max = s[0];
        for (int i = 1; i < s.length; i++) {
            min = Math.min(min, s[i]);
            max = Math.max(max, s[i]);
        }
        return max - min;
    }

    public int solution(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x : nums) {
            s += x;
            mx = Math.max(mx, s);
            mn = Math.min(mn, s);
        }
        return mx - mn;
    }
}
