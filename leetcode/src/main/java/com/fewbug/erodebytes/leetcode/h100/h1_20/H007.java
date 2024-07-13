package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 16:12
 **/
public class H007 {

    public int maxArea(int[] height) {
        int res = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
