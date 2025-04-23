package com.fewbug.erodebytes.leetcode.competition.y2025.weekly446;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/22 11:23
 **/
public class Q01 {

    public long calculateScore(String[] instructions, int[] values) {
        int cur = 0;
        long ans = 0;
        Set<Integer> excuted = new HashSet<>();

        while (!excuted.contains(cur) && cur >= 0 && cur < instructions.length) {
            String op = instructions[cur];
            excuted.add(cur);
            if ("jump".equals(op)) {
                cur = cur + values[cur];
            } else {
                ans += values[cur];
                cur = cur + 1;
            }
        }
        return ans;
    }
}
