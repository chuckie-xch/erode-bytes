package com.fewbug.erodebytes.datastruct;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/7 22:31
 **/
public class NumArray {

    private final int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }

    public int[] getS() {
        return s;
    }
}
