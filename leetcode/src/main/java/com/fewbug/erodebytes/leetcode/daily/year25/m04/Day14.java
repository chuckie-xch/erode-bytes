package com.fewbug.erodebytes.leetcode.daily.year25.m04;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/14 14:42
 **/
public class Day14 {

    /**
     * 提示：
     *
     * 3 <= arr.length <= 100 <br>
     * 0 <= arr[i] <= 1000 <br>
     * 0 <= a, b, c <= 1000 <br>
     * 
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                        && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
