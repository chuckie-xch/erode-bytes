package com.fewbug.erodebytes.leetcode.topic.enumerationskill;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/28 09:11
 **/
public class Q03 {

    /**
     * 提示：
     *
     * m == arrays.length <br>
     * 2 <= m <= 105 <br>
     * 1 <= arrays[i].length <= 500 <br>
     * -104 <= arrays[i][j] <= 104 <br>
     * arrays[i] 以 升序 排序。 <br>
     * 所有数组中最多有 105 个整数。<br>
     * 
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> first = arrays.get(0);
        int min = first.get(0);
        int max = first.get(first.size() - 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);
            int a = Math.abs(max - cur.get(0));
            int b = Math.abs(cur.get(cur.size() - 1) - min);
            if (a > b) {
                ans = Math.max(ans, a);
            } else {
                ans = Math.max(ans, b);
            }
            min = Math.min(min, cur.get(0));
            max = Math.max(max, cur.get(cur.size() - 1));
        }
        return ans;
    }
}
