package com.fewbug.erodebytes.leetcode.topic.enumerationskill;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/24 10:00
 **/
public class Q01 {

    /**
     * 提示：
     *
     * 2 <= values.length <= 5 * 104 <br>
     * 1 <= values[i] <= 1000
     * 
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int mx = values[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, values[i] - i + mx);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}
