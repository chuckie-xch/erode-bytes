package com.fewbug.erodebytes.leetcode.topic.doublepointer;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/7 10:23
 **/
public class Q03 {

    /**
     * 1 <= a.length, b.length <= 100000 <br>
     * -2147483648 <= a[i], b[i] <= 2147483647 <br>
     * 正确结果在区间 [0, 2147483647] 内 <br>
     * 
     * @param a
     * @param b
     * @return
     */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int m = a.length;
        int n = b.length;
        if (m == 1 && n == 1) {
            return Math.abs(a[0] - b[0]);
        }

        long ans = Long.MAX_VALUE;
        int i = 0, j = 0;
        while (i < m && j < n) {
            long diff = (long)a[i] - (long)b[j];
            if (diff == 0) {
                return 0;
            }
            ans = Math.min(ans, Math.abs(diff));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return (int)ans;
    }
}
