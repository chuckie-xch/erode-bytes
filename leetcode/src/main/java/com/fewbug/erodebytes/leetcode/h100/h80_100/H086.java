package com.fewbug.erodebytes.leetcode.h100.h80_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/24 15:00
 **/
public class H086 {

    /**
     * 提示：
     * <p>
     * 1 <= people.length <= 2000
     * 0 <= hi <= 106
     * 0 <= ki < people.length
     * 题目数据确保队列可以被重建
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p0, p1) -> {
            if (p0[0] != p1[0]) {
                return p1[0] - p0[0];
            } else {
                return p0[1] - p1[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (res.size() <= people[i][1]) {
                res.add(res.size(), people[i]);
            } else {
                res.add(people[i][1], people[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
