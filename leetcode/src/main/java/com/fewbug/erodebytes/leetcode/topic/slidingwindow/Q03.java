package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/12 09:20
 **/
public class Q03 {

    /**
     * 1 <= arr.length <= 105
     * 1 <= arr[i] <= 104
     * 1 <= k <= arr.length
     * 0 <= threshold <= 104
     *
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        threshold = threshold * k;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i + 1 < k) {
                continue;
            }
            ans += sum >= threshold ? 1 : 0;
            sum -= arr[i - k + 1];
        }
        return ans;
    }
}
