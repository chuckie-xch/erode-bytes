package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 22:38
 **/
public class H063 {

    /**
     * 提示：
     * <p>
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

    public int solution(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> list, int k) {
        Random random = new Random();
        int pivot = list.get(random.nextInt(list.size()));
        List<Integer> moreThanList = new ArrayList<>();
        List<Integer> equalList = new ArrayList<>();
        List<Integer> lessThanList = new ArrayList<>();

        for (Integer num : list) {
            if (num > pivot) {
                moreThanList.add(num);
            } else if (num < pivot) {
                lessThanList.add(num);
            } else {
                equalList.add(num);
            }
        }

        if (moreThanList.size() >= k) {
            return quickSelect(moreThanList, k);
        } else if (list.size() - lessThanList.size() < k) {
            return quickSelect(lessThanList, k - list.size() + lessThanList.size());
        } else {
            return pivot;
        }
    }
}
