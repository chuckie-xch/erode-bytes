package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 09:30
 **/
public class H071 {

    /**
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            if (begin >= queue.peek()) {
                queue.poll();
            }
            queue.add(end);
        }
        return queue.size();
    }

}
