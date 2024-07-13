package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 14:36
 **/
public class H026 {

    /**
     * 提示：
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i + 1 < intervals.length && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
