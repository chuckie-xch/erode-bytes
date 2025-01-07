package com.fewbug.erodebytes.leetcode.daily.year25.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/2 09:59
 **/
public class Day01 {


    class MyCalendar {

        List<int[]> booked;

        public MyCalendar() {
            booked = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            for (int[] arr : booked) {
                int l = arr[0];
                int r = arr[1];
                if (!(startTime >= r || endTime <= l)) {
                    return false;
                }
            }
            booked.add(new int[]{startTime, endTime});
            return true;
        }

    }

}



