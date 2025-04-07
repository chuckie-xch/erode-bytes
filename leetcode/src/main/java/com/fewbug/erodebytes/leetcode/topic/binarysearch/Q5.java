package com.fewbug.erodebytes.leetcode.topic.binarysearch;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/19 09:13
 **/
public class Q5 {

    /**
     * 提示：
     *
     * 1 <= mountainHeight <= 105 <br>
     * 1 <= workerTimes.length <= 104 <br>
     * 1 <= workerTimes[i] <= 106 <br>
     * 
     * @param mountainHeight
     * @param workerTimes
     * @return
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxT = 0;
        for (int t : workerTimes) {
            maxT = Math.max(maxT, t);
        }
        int h = (mountainHeight - 1) / workerTimes.length + 1;
        long left = 1;
        long right = (long)maxT * (h + 1) * h / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
    // 枚举技巧

    private boolean check(long m, int leftH, int[] workerTimes) {
        for (int t : workerTimes) {
            leftH -= ((int)Math.sqrt((m / t) * 8 + 1) - 1) / 2;
            if (leftH <= 0) {
                return true;
            }
        }
        return false;
    }
}
