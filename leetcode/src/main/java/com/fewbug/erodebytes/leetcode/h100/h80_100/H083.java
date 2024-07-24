package com.fewbug.erodebytes.leetcode.h100.h80_100;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/20 15:00
 **/
public class H083 {

    /**
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     * <p>
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int pre = nums[0], cur;
        int count = 1;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if (cur != pre) {
                queue.add(new Info(i - 1, count));
                count = 1;
            } else {
                count++;
            }
            pre = cur;
        }
        queue.add(new Info(nums.length - 1, count));
        int index = 0;
        int[] ans = new int[k];
        while (!queue.isEmpty() && index < k) {
            ans[index++] = nums[queue.poll().index];
        }
        return ans;
    }

    public class Info {
        int index;
        int cnt;

        public Info(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }
}
