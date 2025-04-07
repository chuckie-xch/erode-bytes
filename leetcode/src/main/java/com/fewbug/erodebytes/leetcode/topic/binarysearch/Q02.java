package com.fewbug.erodebytes.leetcode.topic.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/13 10:05
 **/
public class Q02 {

    /**
     * 1 <= k <= arr.length <br>
     * 1 <= arr.length <= 104 <br>
     * arr 按 升序 排列 <br>
     * -104 <= arr[i], x <= 104 <br>
     * 
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosedElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        if (n <= k) {
            Arrays.stream(arr).forEach(list::add);
            return list;
        }

        int l = 0, r = n - 1;
        while (l <= r && r - l + 1 > k) {
            int lDiff = Math.abs(arr[l] - x);
            int rDiff = Math.abs(arr[r] - x);
            if (lDiff <= rDiff) {
                r--;
            } else {
                l++;
            }
        }
        for (int i = l; i <= r; i++) {
            list.add(arr[i]);
        }
        return list;
    }

}
