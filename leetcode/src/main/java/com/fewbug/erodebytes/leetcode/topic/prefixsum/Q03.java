package com.fewbug.erodebytes.leetcode.topic.prefixsum;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/10 10:44
 **/
public class Q03 {

    /**
     * 提示：单调栈
     *
     * 0 <= low <= high <= 10^9
     * 
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        int diff = high - low + 1;
        if (diff % 2 == 0) {
            return diff / 2;
        }
        if (high % 2 == 0) {
            return diff / 2;
        } else {
            return diff / 2 + 1;
        }
    }

    public int solution(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
